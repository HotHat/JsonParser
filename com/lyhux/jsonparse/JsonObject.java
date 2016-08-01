package com.lyhux.jsonparse;

import java.util.ArrayList;

/**
 * 	Follow the Grammar!
 *  When defining a procedure that operates on inductively defined data, 
 *  the  structure of the program should be patterned after the structure of the data
 * 
 *  More precisely:
 *  1, Write one procedure for each nonterminal in the grammar. 
 *     The procedure will be responsible for handling the data 
 *     corresponding to that nonterminal, and nothing else.
 *  
 *  2, In each procedure, write one alternative for each production corresponding 
 *     to that nonterminal. You may need additional case structure, but this will 
 *     get you started. For each nonterminal that appears in the right-hand side, 
 *     write a recursive call to the procedure for that nonterminal.
 * 
 */




/**
 * @author lyhux
 *	Designing an interface for a recursive data type
 *	1. Include one constructor for each kind of data in the data type.
 *	2. Include one predicate for each kind of data in the data type.
 *	3. Include one extractor for each piece of data passed to a constructor
 *  of the data type. 
 */



/**
 * 
 * @author lyhux
 *	object
		{}
		{ members }
	members
		null,
		pair,
		pair , members
	pair
		string : value
	array
		[]
		[ elements ]
	elements
		value 
		value , elements
	value
		string
		number
		object
		array
		true
		false
		null
 *
 */


public class JsonObject{
	
	private ArrayList<JsonPair> pairs;
	private int level;
	
	public JsonObject() {
		pairs = new ArrayList<>();
		setLevel(0);
	}
	

	
	public JsonValue get(String name) {
		for (JsonPair jp : pairs) {
			if (jp.getName().equals(name)) {
				return jp.getValue();
			}
		}
		return null;
	}
	
	
	
	public void add(String name, JsonValue value) {
		JsonPair p = new JsonPair(name, value);		
		pairs.add(p);
		
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
		
	public JsonTypes getType() {
		return JsonTypes.OBJECT;
	}
	
	
	@Override
	public String toString() {
		String content = "";
		
		content += "\n";
		content += JsonParseTools.toSpace(level);
		content += "{ \n";
		
		for (JsonPair pair : pairs ) {
			if (pair == pairs.get(pairs.size() - 1)) {
				pair.setLevel(level + 1);
				content += pair.toString();
			} else {
				pair.setLevel(level + 1);
				content += pair.toString();
				content += ",\n";
			}
		}
		content += "\n";
		content += JsonParseTools.toSpace(level);
		
		content += "}";
		
		return content;
	}

}
