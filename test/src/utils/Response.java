package utils;

import java.util.Calendar;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Response {
	long id;
	String init;
	String req;
	String foundedOn;
	LinkedList<String> returned = new LinkedList<String>();

	public Response() {
	}

	public Response(String init, String req, String found,
			LinkedList<String> returned) {
		this.init = init;
		this.req = req;
		this.returned = returned;
		foundedOn = found;
		id = Calendar.getInstance().getTimeInMillis();
	}

	public long getId() {
		return id;
	}

	public void remove(String cle) {
		returned.remove(cle);
	}

	public String getInit() {
		return init;
	}

	public void setInit(String init) {
		this.init = init;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public LinkedList<String> getReturned() {
		return returned;
	}

	public void setReturned(LinkedList<String> returned) {
		this.returned = returned;
	}

	public String serializeJSON() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static Response getFromJSON(String json_text) {
		Gson gson = new Gson();
		Response req = gson.fromJson(json_text, Response.class);
		return req;
	}

	@Override
	public String toString() {
		return "RESPONSE : FOUNDEDON : " + foundedOn + "\treq : " + req
				+ "\tinit : " + init + "\tchemin : " + returned;
	}

	public String getFoundedOn() {
		return foundedOn;
	}

	public void setFoundedOn(String foundedOn) {
		this.foundedOn = foundedOn;
	}
}
