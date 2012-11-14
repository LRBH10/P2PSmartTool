/**
 * 
 * 
 * null
 **/
package test;

import inria.smarttools.core.util.*;

/**
 **/
public class ReponseEvent extends StEventImpl {
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
   public   ReponseEvent(java.lang.String parameter){
      setParameter(parameter);
   }

   /**
    * Constructor
    **/
   public   ReponseEvent(String adressee, java.lang.String parameter){
      super(adressee);
      setParameter(parameter);
   }


   //
   // Methods 
   //

   /**
    * Return a short description of the ReponseEvent object.
    * @return a value of the type 'String' : a string representation of this ReponseEvent
    **/
   public  String toString(){
      String res = "ReponseEvent";
      return res;
   }


}
