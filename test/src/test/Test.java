package test;

import inria.communicationprotocol.command.Command;

import java.util.LinkedList;
import java.util.List;

import test.view.ChatFrame;
import test.view.IChatView;
import utils.Request;
import utils.Response;
import utils.ResponseGossip;

public abstract class Test extends
		inria.communicationprotocol.CommunicationProtocolFacade {

	protected IChatView view = null;

	private List<String> all = new LinkedList<String>();

	LinkedList<Long> verified = new LinkedList<Long>();

	public Test() {
		trigger(2000, new Command() {

			@Override
			public void execute() {
				outputRechercheGossip("");
				getView().messageDebug(getIdName(), "CALCULATE NEW VOISIN");
			}
		}, false);// */

	}

	public void input(String expeditor, java.lang.String parameter) {
		System.out.println("[" + expeditor + "] :" + parameter);
		getView().messageArrived(expeditor, parameter);
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
				+ recherche + " " + verified);

		/**
		 * test if the node have the request and the timeout (PROFENDEUR)
		 */
		if (!recherche.getVerified().contains(this.getIdName())
				&& recherche.getProfondeurMax() > 0
				&& !verified.contains(recherche.getId())) {

			// Add ID of Request
			verified.add(recherche.getId());

			// DEMINIER LA PROFENDEUR
			recherche.setProfondeurMax(recherche.getProfondeurMax() - 1);

			// AJOUTER LE NOM AU CHEMIN
			recherche.addVerified(this.getIdName());

			// ESQUE LE NEOEUD RECHERCHER
			if (getIdName().equals(recherche.getRequete())) {
				// SI OUI COMENCER LA REPONSE
				System.out.println("RESPNSE BEGIN with "
						+ recherche.getVerified());

				// CREATION DE LA REPONSE
				Response re = new Response(recherche.getInitiateur(),
						recherche.getRequete(), getIdName(),
						recherche.getVerified());
				re.remove(getIdName());

				getView().messageDebug(
						getIdName(),
						"I Am HERE \n RESPONSE BEGIN with sending for '"
								+ re.getReturned().getLast() + "'");
				outputReponse(re.getReturned().getLast(), re.serializeJSON());

			} else {
				getView().messageDebug(getIdName(),
						"I am serching for '" + recherche.getRequete() + "'");
				outputRecherche(recherche.serializeJSON());
			}
		}

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

			System.out.println(response.getReq() + " I am Here");
			getView().messageDebug(response.getFoundedOn(),
					response.getReq() + " I am Here");

		} else {
			response.getReturned().removeLast();
			outputReponse(response.getReturned().getLast(),
					response.serializeJSON());
			getView().messageDebug(getIdName(),
					"Response to " + response.getReturned().getLast());
		}

	}

	public void inputReponseGossip(String expeditor, String parameter) {
		System.out.println(parameter);
		ResponseGossip result = ResponseGossip.getFromJSON(parameter);
		for (String element : result.getFounded()) {
			getView().addConnected(element);
			all.add(element);
		}
	}

	public void inputRechercheGossip(String expeditor, String parameter) {
		ResponseGossip res = new ResponseGossip();
		for (String element : all) {
			res.addNode(element);
		}
		outputReponseGossip(expeditor, res.serializeJSON());

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
			getView().addConnected(name);
			all.add(name);
		}
	}

	public void disconnectInput(String expeditor) {
		//removeNeighbour(expeditor);
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
