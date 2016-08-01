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


public class JsonElements {
	private ArrayList<JsonValue> values;
	
	public JsonElements() {
		values = new ArrayList<>();
	}
	
	public JsonElements(ArrayList<JsonValue> values) {
		this.values = values;
	}
	
	public ArrayList<JsonValue> getValues() {
		return values;
	}
	
	
	public JsonTypes getType() {
		return JsonTypes.ELEMENT;
	}

	public void display() {
		
	}
	
	
}
