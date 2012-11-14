/**
 **/
package test;


/**
 **/
public interface TestFacadeInterface {
   //
   // Methods 
   //

   /**
    * recherche
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void inputRecherche(String expeditor, java.lang.String parameter);

   /**
    * reponseGossip
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void inputReponseGossip(String expeditor, java.lang.String parameter);

   /**
    * reponse
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void inputReponse(String expeditor, java.lang.String parameter);

   /**
    * test
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void input(String expeditor, java.lang.String parameter);

   /**
    * disconnect
    * disconnect
    * @param expeditor is the component name who sent this message
    **/
   public  void disconnectInput(String expeditor);

   /**
    * quit
    * quit
    * @param expeditor is the component name who sent this message
    **/
   public  void quit(String expeditor);

   /**
    * rechercheGossip
    * null
    * @param expeditor is the component name who sent this message
    **/
   public  void inputRechercheGossip(String expeditor, java.lang.String parameter);

   /**
    * shutdown
    * shutdown
    * @param expeditor is the component name who sent this message
    **/
   public  void shutdown(String expeditor);

   /**
    * requestInitData
    * 
    * @param expeditor is the component name who sent this message
    **/
   public  Object requestTree(String expeditor);

   /**
    * send
    * 
    **/
   public  void addSendListener(SendListener data);

   /**
    * send
    * 
    **/
   public  void removeSendListener(SendListener data);

   /**
    * reponse
    * null
    **/
   public  void addReponseListener(ReponseListener data);

   /**
    * reponse
    * null
    **/
   public  void removeReponseListener(ReponseListener data);

   /**
    * undo
    * 
    **/
   public  void addUndoListener(UndoListener data);

   /**
    * undo
    * 
    **/
   public  void removeUndoListener(UndoListener data);

   /**
    * test
    * null
    **/
   public  void addTestListener(TestListener data);

   /**
    * test
    * null
    **/
   public  void removeTestListener(TestListener data);

   /**
    * initData
    * 
    **/
   public  void addInitDataListener(InitDataListener data);

   /**
    * initData
    * 
    **/
   public  void removeInitDataListener(InitDataListener data);

   /**
    * log
    * 
    **/
   public  void addLogListener(LogListener data);

   /**
    * log
    * 
    **/
   public  void removeLogListener(LogListener data);

   /**
    * exit
    * 
    **/
   public  void addExitListener(ExitListener data);

   /**
    * exit
    * 
    **/
   public  void removeExitListener(ExitListener data);

   /**
    * connectTo
    * 
    **/
   public  void addConnectToListener(ConnectToListener data);

   /**
    * connectTo
    * 
    **/
   public  void removeConnectToListener(ConnectToListener data);

   /**
    * rechercheGossip
    * null
    **/
   public  void addRechercheGossipListener(RechercheGossipListener data);

   /**
    * rechercheGossip
    * null
    **/
   public  void removeRechercheGossipListener(RechercheGossipListener data);

   /**
    * recherche
    * null
    **/
   public  void addRechercheListener(RechercheListener data);

   /**
    * recherche
    * null
    **/
   public  void removeRechercheListener(RechercheListener data);

   /**
    * reponseGossip
    * null
    **/
   public  void addReponseGossipListener(ReponseGossipListener data);

   /**
    * reponseGossip
    * null
    **/
   public  void removeReponseGossipListener(ReponseGossipListener data);

   /**
    * disconnect
    * 
    **/
   public  void addDisconnectListener(DisconnectListener data);

   /**
    * disconnect
    * 
    **/
   public  void removeDisconnectListener(DisconnectListener data);

   /**
    * logUndo
    * 
    **/
   public  void addLogUndoListener(LogUndoListener data);

   /**
    * logUndo
    * 
    **/
   public  void removeLogUndoListener(LogUndoListener data);


}
