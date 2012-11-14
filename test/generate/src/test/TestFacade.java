/**
 **/
package test;

import inria.smarttools.core.component.PropertyMap;

import java.util.Vector;

/**
 **/
public class TestFacade extends Test implements TestFacadeInterface {
   //
   // Fields 
   //

   /**
    * send
    * 
    **/
   protected Vector<SendListener> sendListeners = new Vector<SendListener>();
   /**
    * reponse
    * null
    **/
   protected Vector<ReponseListener> reponseListeners = new Vector<ReponseListener>();
   /**
    * undo
    * 
    **/
   protected Vector<UndoListener> undoListeners = new Vector<UndoListener>();
   /**
    * test
    * null
    **/
   protected Vector<TestListener> testListeners = new Vector<TestListener>();
   /**
    * initData
    * 
    **/
   protected Vector<InitDataListener> initDataListeners = new Vector<InitDataListener>();
   /**
    * log
    * 
    **/
   protected Vector<LogListener> logListeners = new Vector<LogListener>();
   /**
    * exit
    * 
    **/
   protected Vector<ExitListener> exitListeners = new Vector<ExitListener>();
   /**
    * connectTo
    * 
    **/
   protected Vector<ConnectToListener> connectToListeners = new Vector<ConnectToListener>();
   /**
    * rechercheGossip
    * null
    **/
   protected Vector<RechercheGossipListener> rechercheGossipListeners = new Vector<RechercheGossipListener>();
   /**
    * recherche
    * null
    **/
   protected Vector<RechercheListener> rechercheListeners = new Vector<RechercheListener>();
   /**
    * reponseGossip
    * null
    **/
   protected Vector<ReponseGossipListener> reponseGossipListeners = new Vector<ReponseGossipListener>();
   /**
    * disconnect
    * 
    **/
   protected Vector<DisconnectListener> disconnectListeners = new Vector<DisconnectListener>();
   /**
    * logUndo
    * 
    **/
   protected Vector<LogUndoListener> logUndoListeners = new Vector<LogUndoListener>();
   /**
    **/
   private String idName;

   /**
    **/
   public void setIdName(String v){
      this.idName = v;
   }

   public String getIdName(){
      return idName;
   }

   //
   // Constructors 
   //

   /**
    * Constructor
    **/
   public   TestFacade(String idName){
      setIdName(idName);
   }

   /**
    * Constructor
    **/
   public   TestFacade(){
   }


   //
   // Methods 
   //

   /**
    *  request init data 
    **/
   public  Object requestInitData(String expeditor){
      return "";
   }

   /**
    * recherche
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void inputRecherche(String expeditor, java.lang.String parameter){
      super.inputRecherche(expeditor, parameter);
   }

   /**
    * reponseGossip
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void inputReponseGossip(String expeditor, java.lang.String parameter){
      super.inputReponseGossip(expeditor, parameter);
   }

   /**
    * reponse
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void inputReponse(String expeditor, java.lang.String parameter){
      super.inputReponse(expeditor, parameter);
   }

   /**
    * test
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void input(String expeditor, java.lang.String parameter){
      super.input(expeditor, parameter);
   }

   /**
    * disconnect
    * disconnect
    * @param expeditor is the component name who sent this message
    **/
   public  void disconnectInput(String expeditor){
      super.disconnectInput(expeditor);
   }

   /**
    * quit
    * quit
    * @param expeditor is the component name who sent this message
    **/
   public  void quit(String expeditor){
      super.quit(expeditor);
   }

   /**
    * rechercheGossip
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void inputRechercheGossip(String expeditor, java.lang.String parameter){
      super.inputRechercheGossip(expeditor, parameter);
   }

   /**
    * shutdown
    * shutdown
    * @param expeditor is the component name who sent this message
    **/
   public  void shutdown(String expeditor){
      super.shutdown(expeditor);
   }

   /**
    * requestInitData
    * 
    * @param expeditor is the component name who sent this message
    **/
   public  Object requestTree(String expeditor){
      return super.requestTree(expeditor);
   }

   /**
    * send
    * 
    * @param ev a <code>Object</code> value : data
    **/
   public  void send(java.lang.String messageName, java.lang.String messageExpeditor){
      send(null, messageName, messageExpeditor);
   }

   /**
    * send
    * 
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void send(String adressee, java.lang.String messageName, java.lang.String messageExpeditor){
      PropertyMap args = new PropertyMap();
      args.put("messageName",messageName);
      args.put("messageExpeditor",messageExpeditor);
      SendEvent ev =  new SendEvent(adressee, messageName, messageExpeditor);
      ev.setAttributes(args);
      for(int i = 0 ; i < sendListeners.size() ; i++)
      (( SendListener ) sendListeners.elementAt(i)).send(ev);
   }

   /**
    * reponse
    * null
    * @param ev a <code>Object</code> value : data
    **/
   public  void outputReponse(java.lang.String parameter){
      outputReponse(null, parameter);
   }

   /**
    * reponse
    * null
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void outputReponse(String adressee, java.lang.String parameter){
      PropertyMap args = new PropertyMap();
      args.put("parameter",parameter);
      ReponseEvent ev =  new ReponseEvent(adressee, parameter);
      ev.setAttributes(args);
      for(int i = 0 ; i < reponseListeners.size() ; i++)
      (( ReponseListener ) reponseListeners.elementAt(i)).outputReponse(ev);
   }

   /**
    * undo
    * 
    * @param ev a <code>Object</code> value : data
    **/
   public  void undo(java.lang.String message, java.lang.String receiver){
      undo(null, message, receiver);
   }

   /**
    * undo
    * 
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void undo(String adressee, java.lang.String message, java.lang.String receiver){
      PropertyMap args = new PropertyMap();
      args.put("message",message);
      args.put("receiver",receiver);
      UndoEvent ev =  new UndoEvent(adressee, message, receiver);
      ev.setAttributes(args);
      for(int i = 0 ; i < undoListeners.size() ; i++)
      (( UndoListener ) undoListeners.elementAt(i)).undo(ev);
   }

   /**
    * test
    * null
    * @param ev a <code>Object</code> value : data
    **/
   public  void output(java.lang.String parameter){
      output(null, parameter);
   }

   /**
    * test
    * null
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void output(String adressee, java.lang.String parameter){
      PropertyMap args = new PropertyMap();
      args.put("parameter",parameter);
      TestEvent ev =  new TestEvent(adressee, parameter);
      ev.setAttributes(args);
      for(int i = 0 ; i < testListeners.size() ; i++)
      (( TestListener ) testListeners.elementAt(i)).output(ev);
   }

   /**
    * initData
    * 
    * @param ev a <code>Object</code> value : data
    **/
   public  void initData(inria.smarttools.core.component.PropertyMap inits){
      initData(null, inits);
   }

   /**
    * initData
    * 
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void initData(String adressee, inria.smarttools.core.component.PropertyMap inits){
      PropertyMap args = new PropertyMap();
      args.put("inits",inits);
      InitDataEvent ev =  new InitDataEvent(adressee, inits);
      ev.setAttributes(args);
      for(int i = 0 ; i < initDataListeners.size() ; i++)
      (( InitDataListener ) initDataListeners.elementAt(i)).initData(ev);
   }

   /**
    * log
    * 
    * @param ev a <code>Object</code> value : data
    **/
   public  void log(java.lang.String info){
      log(null, info);
   }

   /**
    * log
    * 
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void log(String adressee, java.lang.String info){
      PropertyMap args = new PropertyMap();
      args.put("info",info);
      LogEvent ev =  new LogEvent(adressee, info);
      ev.setAttributes(args);
      for(int i = 0 ; i < logListeners.size() ; i++)
      (( LogListener ) logListeners.elementAt(i)).log(ev);
   }

   /**
    * exit
    * 
    * @param ev a <code>Object</code> value : data
    **/
   public  void exit(){
      exit(null);
   }

   /**
    * exit
    * 
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void exit(String adressee){
      PropertyMap args = new PropertyMap();
      ExitEvent ev =  new ExitEvent(adressee);
      ev.setAttributes(args);
      for(int i = 0 ; i < exitListeners.size() ; i++)
      (( ExitListener ) exitListeners.elementAt(i)).exit(ev);
   }

   /**
    * connectTo
    * 
    * @param ev a <code>Object</code> value : data
    **/
   public  void connectTo(java.lang.String id_src, java.lang.String type_dest, java.lang.String id_dest, java.lang.String dc, java.lang.String tc, java.lang.String sc, inria.smarttools.core.component.PropertyMap actions){
      connectTo(null, id_src, type_dest, id_dest, dc, tc, sc, actions);
   }

   /**
    * connectTo
    * 
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void connectTo(String adressee, java.lang.String id_src, java.lang.String type_dest, java.lang.String id_dest, java.lang.String dc, java.lang.String tc, java.lang.String sc, inria.smarttools.core.component.PropertyMap actions){
      PropertyMap args = new PropertyMap();
      args.put("id_src",id_src);
      args.put("type_dest",type_dest);
      args.put("id_dest",id_dest);
      args.put("dc",dc);
      args.put("tc",tc);
      args.put("sc",sc);
      args.put("actions",actions);
      ConnectToEvent ev =  new ConnectToEvent(adressee, id_src, type_dest, id_dest, dc, tc, sc, actions);
      ev.setAttributes(args);
      for(int i = 0 ; i < connectToListeners.size() ; i++)
      (( ConnectToListener ) connectToListeners.elementAt(i)).connectTo(ev);
   }

   /**
    * rechercheGossip
    * null
    * @param ev a <code>Object</code> value : data
    **/
   public  void outputRechercheGossip(java.lang.String parameter){
      outputRechercheGossip(null, parameter);
   }

   /**
    * rechercheGossip
    * null
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void outputRechercheGossip(String adressee, java.lang.String parameter){
      PropertyMap args = new PropertyMap();
      args.put("parameter",parameter);
      RechercheGossipEvent ev =  new RechercheGossipEvent(adressee, parameter);
      ev.setAttributes(args);
      for(int i = 0 ; i < rechercheGossipListeners.size() ; i++)
      (( RechercheGossipListener ) rechercheGossipListeners.elementAt(i)).outputRechercheGossip(ev);
   }

   /**
    * recherche
    * null
    * @param ev a <code>Object</code> value : data
    **/
   public  void outputRecherche(java.lang.String parameter){
      outputRecherche(null, parameter);
   }

   /**
    * recherche
    * null
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void outputRecherche(String adressee, java.lang.String parameter){
      PropertyMap args = new PropertyMap();
      args.put("parameter",parameter);
      RechercheEvent ev =  new RechercheEvent(adressee, parameter);
      ev.setAttributes(args);
      for(int i = 0 ; i < rechercheListeners.size() ; i++)
      (( RechercheListener ) rechercheListeners.elementAt(i)).outputRecherche(ev);
   }

   /**
    * reponseGossip
    * null
    * @param ev a <code>Object</code> value : data
    **/
   public  void outputReponseGossip(java.lang.String parameter){
      outputReponseGossip(null, parameter);
   }

   /**
    * reponseGossip
    * null
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void outputReponseGossip(String adressee, java.lang.String parameter){
      PropertyMap args = new PropertyMap();
      args.put("parameter",parameter);
      ReponseGossipEvent ev =  new ReponseGossipEvent(adressee, parameter);
      ev.setAttributes(args);
      for(int i = 0 ; i < reponseGossipListeners.size() ; i++)
      (( ReponseGossipListener ) reponseGossipListeners.elementAt(i)).outputReponseGossip(ev);
   }

   /**
    * disconnect
    * 
    * @param ev a <code>Object</code> value : data
    **/
   public  void disconnectOut(){
      disconnectOut(null);
   }

   /**
    * disconnect
    * 
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void disconnectOut(String adressee){
      PropertyMap args = new PropertyMap();
      DisconnectEvent ev =  new DisconnectEvent(adressee);
      ev.setAttributes(args);
      for(int i = 0 ; i < disconnectListeners.size() ; i++)
      (( DisconnectListener ) disconnectListeners.elementAt(i)).disconnectOut(ev);
   }

   /**
    * logUndo
    * 
    * @param ev a <code>Object</code> value : data
    **/
   public  void logUndo(java.lang.String message, java.lang.String receiver){
      logUndo(null, message, receiver);
   }

   /**
    * logUndo
    * 
    * @param adressee component name, which will receive this message
    * @param ev a <code>Object</code> value : data
    **/
   public  void logUndo(String adressee, java.lang.String message, java.lang.String receiver){
      PropertyMap args = new PropertyMap();
      args.put("message",message);
      args.put("receiver",receiver);
      LogUndoEvent ev =  new LogUndoEvent(adressee, message, receiver);
      ev.setAttributes(args);
      for(int i = 0 ; i < logUndoListeners.size() ; i++)
      (( LogUndoListener ) logUndoListeners.elementAt(i)).logUndo(ev);
   }

   /**
    * send
    * 
    **/
   public  void addSendListener(SendListener data){
      sendListeners.add(data);
   }

   /**
    * send
    * 
    **/
   public  void removeSendListener(SendListener data){
      sendListeners.remove(data);
   }

   /**
    * reponse
    * null
    **/
   public  void addReponseListener(ReponseListener data){
      reponseListeners.add(data);
   }

   /**
    * reponse
    * null
    **/
   public  void removeReponseListener(ReponseListener data){
      reponseListeners.remove(data);
   }

   /**
    * undo
    * 
    **/
   public  void addUndoListener(UndoListener data){
      undoListeners.add(data);
   }

   /**
    * undo
    * 
    **/
   public  void removeUndoListener(UndoListener data){
      undoListeners.remove(data);
   }

   /**
    * test
    * null
    **/
   public  void addTestListener(TestListener data){
      testListeners.add(data);
   }

   /**
    * test
    * null
    **/
   public  void removeTestListener(TestListener data){
      testListeners.remove(data);
   }

   /**
    * initData
    * 
    **/
   public  void addInitDataListener(InitDataListener data){
      initDataListeners.add(data);
   }

   /**
    * initData
    * 
    **/
   public  void removeInitDataListener(InitDataListener data){
      initDataListeners.remove(data);
   }

   /**
    * log
    * 
    **/
   public  void addLogListener(LogListener data){
      logListeners.add(data);
   }

   /**
    * log
    * 
    **/
   public  void removeLogListener(LogListener data){
      logListeners.remove(data);
   }

   /**
    * exit
    * 
    **/
   public  void addExitListener(ExitListener data){
      exitListeners.add(data);
   }

   /**
    * exit
    * 
    **/
   public  void removeExitListener(ExitListener data){
      exitListeners.remove(data);
   }

   /**
    * connectTo
    * 
    **/
   public  void addConnectToListener(ConnectToListener data){
      connectToListeners.add(data);
   }

   /**
    * connectTo
    * 
    **/
   public  void removeConnectToListener(ConnectToListener data){
      connectToListeners.remove(data);
   }

   /**
    * rechercheGossip
    * null
    **/
   public  void addRechercheGossipListener(RechercheGossipListener data){
      rechercheGossipListeners.add(data);
   }

   /**
    * rechercheGossip
    * null
    **/
   public  void removeRechercheGossipListener(RechercheGossipListener data){
      rechercheGossipListeners.remove(data);
   }

   /**
    * recherche
    * null
    **/
   public  void addRechercheListener(RechercheListener data){
      rechercheListeners.add(data);
   }

   /**
    * recherche
    * null
    **/
   public  void removeRechercheListener(RechercheListener data){
      rechercheListeners.remove(data);
   }

   /**
    * reponseGossip
    * null
    **/
   public  void addReponseGossipListener(ReponseGossipListener data){
      reponseGossipListeners.add(data);
   }

   /**
    * reponseGossip
    * null
    **/
   public  void removeReponseGossipListener(ReponseGossipListener data){
      reponseGossipListeners.remove(data);
   }

   /**
    * disconnect
    * 
    **/
   public  void addDisconnectListener(DisconnectListener data){
      disconnectListeners.add(data);
   }

   /**
    * disconnect
    * 
    **/
   public  void removeDisconnectListener(DisconnectListener data){
      disconnectListeners.remove(data);
   }

   /**
    * logUndo
    * 
    **/
   public  void addLogUndoListener(LogUndoListener data){
      logUndoListeners.add(data);
   }

   /**
    * logUndo
    * 
    **/
   public  void removeLogUndoListener(LogUndoListener data){
      logUndoListeners.remove(data);
   }


}
