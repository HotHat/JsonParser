package com.lyhux.jsonparse;

/**
 * @author lyhux
 *	Designing an interface for a recursive data type
 *	1. Include one constructor for each kind of data in the data type.
 *	2. Include one predicate for each kind of data in the data type.
 *	3. Include one extractor for each piece of data passed to a constructor
 *  of the data type. 
 */


public class JsonPair{
	
	private String name;
	private JsonValue value;
	private int level;
	
	
	
	public JsonPair(String name, JsonValue value) {
		this.name = name;
		this.value = value;
	}
	
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getName() {
		return this.name;
	}
	
	public JsonValue getValue() {
		return this.value;
	}
	


	public JsonTypes getType(){
		return JsonTypes.Pair;
	}

	@Override
	public String toString() {
		String content = "";
		
		content += JsonParseTools.toSpace(level);
		content += name;
		content += " : ";
		value.setLevel(level);
		content += value.toString();
		
		return content;
	}
	
	
}
