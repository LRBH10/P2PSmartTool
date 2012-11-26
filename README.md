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
    3. B broadCast vers A;C  
    4. A verifie esqu il deja traiter la requete :  tous les noeud sauvgarde toutes les requete traitees
             si le cas alors ignorer la requete.
    5. D boradcast vers F;E;A (A etape 4)
	6. C broadcast B et F  (B etape 4; F etape 4 de D)
	7.  