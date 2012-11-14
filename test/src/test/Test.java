package test;

import inria.smarttools.core.component.PropertyMap;
import test.view.ChatFrame;
import test.view.IChatView;
import utils.Request;
import utils.Response;

public abstract class Test extends
		inria.communicationprotocol.CommunicationProtocolFacade {

	protected IChatView view = null;

	public Test() {
	}

	public void input(String expeditor, java.lang.String parameter) {
		System.out.println("[" + expeditor + "] :" + parameter);
		getView().messageArrived(expeditor, parameter + " ---Simple");
	}

	/**
	 * To SEARCH
	 * 
	 * @param expeditor
	 *            from who
	 * @param parameter
	 *            REQUEST in json
	 */
	public void inputRecherche(String expeditor, String parameter) {

		// get REQUEST FROM JSON
		Request recherche = Request.getFromJSON(parameter);

		// TO DEBUG
		System.out.println(getIdName() + " from :[" + expeditor + "] :"
				+ recherche);

		/**
		 * test if the node have the request and the timeout (PROFENDEUR)
		 */
		if (!recherche.getVerified().contains(this.getIdName())
				&& recherche.getProfondeurMax() > 0) {

			// AFFICHAGE DES AMIS
			System.out.print("MES AMIS : ");
			for (String friend : this.getNeighbours("test")) {
				System.out.print(friend + "-");
			}
			System.out.println();

			// DEMINIER LA PROFENDEUR
			recherche.setProfondeurMax(recherche.getProfondeurMax() - 1);

			// AJOUTER LE NOM AU CHEMIN
			recherche.addVerified(this.getIdName());

			// ESQUE LE NEOEUD RECHERCHER EST UN AMI
			if (getNeighbours("test").contains(recherche.getRequete())) {
				// SI OUI COMENCER LA REPONSE
				System.out.println("RESPNSE BEGIN with "
						+ recherche.getVerified());

				
				// CREATION DE LA REPONSE
				Response re = new Response(recherche.getInitiateur(),
						recherche.getRequete(), getIdName(),
						recherche.getVerified());
				re.remove(getIdName());
				outputReponse(re.getReturned().getLast(), re.serializeJSON());
			} else {

				outputRecherche(recherche.serializeJSON());
			}
		}
		// getView().messageArrived(expeditor, parameter + " ---Recherche");

	}

	/**
	 * RESPONSE
	 * 
	 * @param expeditor
	 * @param parameter
	 */
	public void inputReponse(String expeditor, String parameter) {
		Response response = Response.getFromJSON(parameter);
		System.out.println(getIdName() + " from [" + expeditor + "] :"
				+ response);

		if (response.getInit().equals(getIdName())) {

			System.out.println(response.getReq() + " est Mon AMI");
			getView().messageArrived(response.getFoundedOn(),
					response.getReq() + " est Mon AMI");

		} else {
			response.getReturned().removeLast();
			outputReponse(response.getReturned().getLast(),
					response.serializeJSON());
		}

	}

	public void inputReponseGossip(String expeditor, String parameter) {

	}

	public void inputRechercheGossip(String expeditor, String parameter) {

	}

	public abstract void output(java.lang.String parameter);

	public abstract void output(String destination, java.lang.String parameter);

	public abstract void outputRecherche(java.lang.String parameter);

	public abstract void outputRecherche(String destination,
			java.lang.String parameter);

	public abstract void outputReponse(java.lang.String parameter);

	public abstract void outputReponse(String destination,
			java.lang.String parameter);

	public abstract void outputRechercheGossip(java.lang.String parameter);

	public abstract void outputRechercheGossip(String destination,
			java.lang.String parameter);

	public abstract void outputReponseGossip(java.lang.String parameter);

	public abstract void outputReponseGossip(String destination,
			java.lang.String parameter);

	public IChatView getView() {
		if (view == null) {
			view = new ChatFrame(this);
		}
		return view;
	}

	@Override
	protected void neighbourJustConnected(String name, String service) {
		if (service.equals("test")) {
			System.out.println(getIdName() + " can now talk to " + name);
			getView().addNeighbour(name);
		}
	}

	public void disconnectInput(String expeditor) {
		// TODO Auto-generated method stub

	}

	public void shutdown(String expeditor) {
		// TODO Auto-generated method stub

	}

	public Object requestTree(String expeditor) {
		// TODO Auto-generated method stub
		return null;
	}

	public void quit(String expeditor) {
		// TODO Auto-generated method stub

	}

}
