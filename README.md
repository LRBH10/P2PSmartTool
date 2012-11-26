P2PSmartTool
============
Expliacation :

           * Recherche un contact 
		        * creation de lien direct quand la requete = contact  (CheckBox)
				           c'est le contact recherché qui va creer la connection vers la requete.
						   
				* creation de connection apres reponse.
                            reprenant exactement le chemin suivi durant la recherche

Example connection apres reponse
=================================

				B - C 
             /      |
            A - D - F -L- I
                 \		 /	
				   E - G 
				   
			supposant que A cherche I

	1. La creation de la requete avec un ID unique (temps actuel en long);
	2. A broadCast vers B;D
    3. 	