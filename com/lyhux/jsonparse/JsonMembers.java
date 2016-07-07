package com.lyhux.jsonparse;

import java.util.ArrayList;

/**
 * @author lyhux
 *	Designing an interface for a recursive data type
 *	1. Include one constructor for each kind of data in the data type.
 *	2. Include one predicate for each kind of data in the data type.
 *	3. Include one extractor for each piece of data passed to a constructor
 *  of the data type. 
 */


public class JsonMembers implements JsonInterface{

	private ArrayList<JsonPair> pairs;
	
	public JsonMembers() {
		pairs = new ArrayList<>();
	}
	
	
	public JsonMembers(ArrayList<JsonPair> p) {
		pairs = p;
	}
	
	
	
	@Override
	public JsonTypes getType() {
		return JsonTypes.NUMBER;
	}
	
	
	public ArrayList<JsonPair> getPairs() {
		return pairs;
	}


	@Override
	public void display(int n) {
		for (JsonPair jp : pairs) {
			jp.display(n);
			//Tools.space(n);
			System.out.print(", \n");
		}
	}
}
