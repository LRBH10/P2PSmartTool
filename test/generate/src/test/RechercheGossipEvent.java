/**
 * null
 * null
 * null
 * null
 * 
 * 
 * null
 * null
 * null
 * null
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * null
 **/
package test;

import inria.smarttools.core.util.*;

/**
 **/
public class RechercheGossipEvent extends StEventImpl {
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
   public   RechercheGossipEvent(java.lang.String parameter){
      setParameter(parameter);
   }

   /**
    * Constructor
    **/
   public   RechercheGossipEvent(String adressee, java.lang.String parameter){
      super(adressee);
      setParameter(parameter);
   }


   //
   // Methods 
   //

   /**
    * Return a short description of the RechercheGossipEvent object.
    * @return a value of the type 'String' : a string representation of this RechercheGossipEvent
    **/
   public  String toString(){
      String res = "RechercheGossipEvent";
      return res;
   }


}
