/**
 * null
 * null
 * null
 **/
package test;

import inria.smarttools.core.util.*;

/**
 **/
public class ReponseGossipEvent extends StEventImpl {
   //
   // Fields 
   //

   /**
    **/
   protected java.lang.String parameter;

   /**
    **/
   public void setParameter(java.lang.String v){
      this.parameter = v;
   }

   public java.lang.String getParameter(){
      return parameter;
   }

   //
   // Constructors 
   //

   /**
    * Constructor
    **/
   public   ReponseGossipEvent(java.lang.String parameter){
      setParameter(parameter);
   }

   /**
    * Constructor
    **/
   public   ReponseGossipEvent(String adressee, java.lang.String parameter){
      super(adressee);
      setParameter(parameter);
   }


   //
   // Methods 
   //

   /**
    * Return a short description of the ReponseGossipEvent object.
    * @return a value of the type 'String' : a string representation of this ReponseGossipEvent
    **/
   public  String toString(){
      String res = "ReponseGossipEvent";
      return res;
   }


}
