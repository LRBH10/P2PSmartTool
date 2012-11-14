package test;

import com.google.gson.Gson;

import utils.Request;
import utils.Response;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Request rr = new Request("rabah","ll",5);
		
		String r = new Gson().toJson(rr);
		
		Request f = new Gson().fromJson(r, Request.class);
		
		
		Response rr1 = new Response("rabah","ll","sss", null);
		String r1 = rr1.serializeJSON();
		System.out.print(new Gson().fromJson(r1, Response.class));
	}

}
