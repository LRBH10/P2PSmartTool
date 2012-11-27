P2PSmartTool
============
Explication :
-------------
           	* Recherche un contact 
		        * creation de lien direct quand la requete = contact  (CheckBox)
			           c'est le contact recherche qui va creer la connection vers la requete.
						   
			* creation de connection apres reponse.
                            reprenant exactement le chemin suivi durant la recherche

		* Recherche Gossip
			*chaque 2000 ms, de maniere periodique l'application de chat effectue des recherche sur les contact disponible dans le chat.

Vue:
------
		* Deux JTextArea
			- une pour les messages entre utilisateurs, 
			-l'autre pour les messages de debug (Connection, recherche ...)

		*Deux JList
			- une pour les amis (la connection est définie)
			- l'autre pour les personnes disponibles.

		* JCheckBox
			- cochée: Conenction va etre creer dans le Noeud recherché
			- sinon c'est l'inititeur de la requete quand il recoit la reponse.

		* JTextField
			- soit un message a envoyé
			- soit un contact a recherché

		* Deux Button  Envoi et Recherche
			- Envoi pour communication 
				Remarque :  si aucun amis selection c'est un Broadcast
			- Recherche un contact donnée dans le JTextField

Example connection apres reponse
=================================

	     B  -  C 
             /     |
            A - D - F -L- I
                 \	 /
		   E - G 
				   
			
		supposant que A cherche I

	1. La creation de la requete avec un ID unique (temps actuel en long);	=> {A}
	2. A broadCast vers B;D							=> {A;B} | {A;D}
    	3. B broadCast vers A;C  						=> {A;B;C} | {A;D}
    	4. A verifie esqu il deja traiter la requete :  tous les noeud sauvgarde toutes les requete traitees
             si le cas alors ignorer la requete.
    	5. D boradcast vers F;E;A (A etape 4)  				=> {A;D;F} | {A;B;C} | {A;D;E}
	6. C broadcast B et F  (B etape 4; F etape 4) 			=> {A;D;F} | {A;D;E} // requete {A;B;C;F} morte
	7. ainsi de suit jusqu a  {A;D;F;L;I} ou nous avons trouvé la requete
		** La reponse serait en utilisons le chemin empreinter  sans faire des broadcast.

	8. quand A recoit la reponse il va creer la connection.



Conception:
==============

	*	Les requetes et les reponse sont des objets sérialisé avec de GSON de GOOGLE.
	*	Les Service
		- envoi de Message entre contact (deja implementé dans test)
		- recherche gossip	recuperer les noeud connecté de maniere dynamique ( à un SAUT)
		- recherce 		recuperer un noeud donné