package test;

import java.util.LinkedList;

import com.google.gson.Gson;

import utils.Request;
import utils.Response;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> lst= new LinkedList<String>();
		lst.add("test1");
		lst.add("test2");
		
		String str=new Gson().toJson(lst);
		LinkedList<String> lst2 = new LinkedList<String>();
		lst2=new Gson().fromJson(str, LinkedList.class);
		System.out.println();
	}

}
