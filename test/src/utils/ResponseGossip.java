package utils;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ResponseGossip {
	LinkedList<String> founded = new LinkedList<String>();

	public void setFounded(LinkedList<String> founded) {
		this.founded = founded;
	}

	public LinkedList<String> getFounded() {
		return founded;
	}

	public void addNode(String name) {
		founded.add(name);
	}

	public String serializeJSON() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}

	public static ResponseGossip getFromJSON(String json_text) {
		Gson gson = new Gson();
		ResponseGossip req = gson.fromJson(json_text, ResponseGossip.class);

		return req;
	}
}
