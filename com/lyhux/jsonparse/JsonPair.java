package com.lyhux.jsonparse;

/**
 * @author lyhux
 *	Designing an interface for a recursive data type
 *	1. Include one constructor for each kind of data in the data type.
 *	2. Include one predicate for each kind of data in the data type.
 *	3. Include one extractor for each piece of data passed to a constructor
 *  of the data type. 
 */


public class JsonPair implements JsonInterface{
	
	private String name;
	private JsonValue value;
	
	public JsonPair(String name, JsonValue value) {
		this.name = name;
		this.value = value;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public JsonValue getValue() {
		return this.value;
	}
	
	@Override
	public JsonTypes getType(){
		return JsonTypes.Pair;
	}

	 
	@Override
	public void display(int n) {
		Tools.space(n);
		System.out.print(name);
		System.out.print(" : ");
		value.display(n);
		
		
	}
}
