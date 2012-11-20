package utils;

import java.util.Calendar;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Request {

	long id;
	boolean directConnection;
	String initiateur;
	String requete;
	int profondeurMax;
	LinkedList<String> verified = new LinkedList<String>();

	public Request(String source, String who, int profondeur, boolean direct) {
		initiateur = source;
		directConnection = direct;
		requete = who;
		profondeurMax = profondeur;
		verified.add(source);
		id = Calendar.getInstance().getTimeInMillis();
	}

	
	public long getId() {
		return id;
	}

	public Request() {
	}

	public void addVerified(String user) {
		verified.add(user);
	}

	public String getInitiateur() {
		return initiateur;
	}

	public void setInitiateur(String initiateur) {
		this.initiateur = initiateur;
	}

	public String getRequete() {
		return requete;
	}

	public void setRequete(String requete) {
		this.requete = requete;
	}

	public int getProfondeurMax() {
		return profondeurMax;
	}

	public void setProfondeurMax(int profondeurMax) {
		this.profondeurMax = profondeurMax;
	}

	public LinkedList<String> getVerified() {
		return verified;
	}

	public void setVerified(LinkedList<String> verified) {
		this.verified = verified;
	}

	public String serializeJSON() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static Request getFromJSON(String json_text) {
		Gson gson = new Gson();
		Request req = gson.fromJson(json_text, Request.class);

		return req;
	}
	
	public boolean isDirectConnection() {
		return directConnection;
	}
	
	public void setDirectConnection(boolean directConnection) {
		this.directConnection = directConnection;
	}

	@Override
	public String toString() {
		return "REQUSET : id "+ id +"\tprof : " + profondeurMax + "\treq : " + requete
				+ "\tinit : " + initiateur + "\tdeja : " + verified;
	}
}
