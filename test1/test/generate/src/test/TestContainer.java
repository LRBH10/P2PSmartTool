/**
 **/
package test;

import inria.communicationprotocol.CommunicationProtocolContainer;
import java.util.List;
import java.util.ArrayList;
import inria.smarttools.core.component.*;
import java.lang.String;
import inria.smarttools.core.component.PropertyMap;

/**
 **/
public class TestContainer extends CommunicationProtocolContainer implements inria.smarttools.core.component.Container, test.SendListener, test.TestListener, test.UndoListener, test.DisconnectListener, test.LogUndoListener, test.InitDataListener, test.LogListener, test.ExitListener, test.ConnectToListener {
   {
      List<MethodCall> methodCalls;
      methodCalls = calls.get("test");
      if (methodCalls == null) {
         methodCalls = new ArrayList<MethodCall>();
         calls.put("test", methodCalls);
      }
      methodCalls.add(new MethodCall() {
         public Object call(ContainerProxy expeditor, String expeditorId, String expeditorType, PropertyMap parameters) {
            ((TestFacade) facade).input(expeditorId, (java.lang.String) parameters.get("parameter"));
            return null;
         	}});
      methodCalls = calls.get("disconnect");
      if (methodCalls == null) {
         methodCalls = new ArrayList<MethodCall>();
         calls.put("disconnect", methodCalls);
      }
      methodCalls.add(new MethodCall() {
         public Object call(ContainerProxy expeditor, String expeditorId, String expeditorType, PropertyMap parameters) {
            ((TestFacade) facade).disconnectInput(expeditorId);
            return null;
         	}});
      methodCalls = calls.get("quit");
      if (methodCalls == null) {
         methodCalls = new ArrayList<MethodCall>();
         calls.put("quit", methodCalls);
      }
      methodCalls.add(new MethodCall() {
         public Object call(ContainerProxy expeditor, String expeditorId, String expeditorType, PropertyMap parameters) {
            ((TestFacade) facade).quit(expeditorId);
            return null;
         	}});
      methodCalls = calls.get("shutdown");
      if (methodCalls == null) {
         methodCalls = new ArrayList<MethodCall>();
         calls.put("shutdown", methodCalls);
      }
      methodCalls.add(new MethodCall() {
         public Object call(ContainerProxy expeditor, String expeditorId, String expeditorType, PropertyMap parameters) {
            ((TestFacade) facade).shutdown(expeditorId);
            return null;
         	}});
      methodCalls = calls.get("requestInitData");
      if (methodCalls == null) {
         methodCalls = new ArrayList<MethodCall>();
         calls.put("requestInitData", methodCalls);
      }
      methodCalls.add(new MethodCall() {
         public Object call(ContainerProxy expeditor, String expeditorId, String expeditorType, PropertyMap parameters) {
            Object res = ((TestFacade) facade).requestInitData(expeditorId);
            if (res != null) {
               buildResponseForInOut(expeditor, expeditorId, expeditorType, getContainerDescription().getInOuts().get("requestInitData"), res);
            }
            return null;
         	}});
   }

   //
   // Constructors 
   //

   /**
    * Constructor
    **/
   public   TestContainer(String name, String componentDescriptionResource){
      super(name, componentDescriptionResource);
   }


   //
   // Methods 
   //

   /**
    * createFacade()
    * Do NOT invoke super.createFacade()
    **/
   protected  void createFacade(){
      facade = new test.TestFacade(getIdName());
      initFacadeListeners();
   }

   /**
    * getFacade()

    * Cast to the proper facade class
    **/
   public  test.TestFacade getFacade(){
      return (test.TestFacade) facade;
   }

   /**
    * initFacadeListeners()
    **/
   protected  void initFacadeListeners(){
      super.initFacadeListeners();
      ((TestFacadeInterface) facade).addSendListener(this);
      ((TestFacadeInterface) facade).addTestListener(this);
      ((TestFacadeInterface) facade).addUndoListener(this);
      ((TestFacadeInterface) facade).addDisconnectListener(this);
      ((TestFacadeInterface) facade).addLogUndoListener(this);
      ((TestFacadeInterface) facade).addInitDataListener(this);
      ((TestFacadeInterface) facade).addLogListener(this);
      ((TestFacadeInterface) facade).addExitListener(this);
      ((TestFacadeInterface) facade).addConnectToListener(this);
   }

   /**
    * SendListener
    * @throws IllegalStateException to absolutely care in business methods
    **/
   public  void send(SendEvent e){
      send(new MessageImpl("send", e.getAttributes() , null, e.getAdressee()));
   }

   /**
    * TestListener
    * @throws IllegalStateException to absolutely care in business methods
    **/
   public  void output(TestEvent e){
      send(new MessageImpl("test", e.getAttributes() , null, e.getAdressee()));
   }

   /**
    * UndoListener
    * @throws IllegalStateException to absolutely care in business methods
    **/
   public  void undo(UndoEvent e){
      send(new MessageImpl("undo", e.getAttributes() , null, e.getAdressee()));
   }

   /**
    * DisconnectListener
    * @throws IllegalStateException to absolutely care in business methods
    **/
   public  void disconnectOut(DisconnectEvent e){
      send(new MessageImpl("disconnect", e.getAttributes() , null, e.getAdressee()));
   }

   /**
    * LogUndoListener
    * @throws IllegalStateException to absolutely care in business methods
    **/
   public  void logUndo(LogUndoEvent e){
      send(new MessageImpl("logUndo", e.getAttributes() , null, e.getAdressee()));
   }

   /**
    * InitDataListener
    * @throws IllegalStateException to absolutely care in business methods
    **/
   public  void initData(InitDataEvent e){
      send(new MessageImpl("initData", e.getAttributes() , null, e.getAdressee()));
   }

   /**
    * LogListener
    * @throws IllegalStateException to absolutely care in business methods
    **/
   public  void log(LogEvent e){
      send(new MessageImpl("log", e.getAttributes() , null, e.getAdressee()));
   }

   /**
    * ExitListener
    * @throws IllegalStateException to absolutely care in business methods
    **/
   public  void exit(ExitEvent e){
      send(new MessageImpl("exit", e.getAttributes() , null, e.getAdressee()));
   }

   /**
    * ConnectToListener
    * @throws IllegalStateException to absolutely care in business methods
    **/
   public  void connectTo(ConnectToEvent e){
      send(new MessageImpl("connectTo", e.getAttributes() , null, e.getAdressee()));
   }

   /**
    *  Describe how to serialize this component
    **/
   public  void serialize(){
   }


}
