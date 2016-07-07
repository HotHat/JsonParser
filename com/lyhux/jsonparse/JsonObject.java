package com.lyhux.jsonparse;

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


public class JsonObject implements JsonInterface{
	
	private JsonMembers members;
	
	
	public JsonObject() {
		members = null;
	}
	
	public JsonObject(JsonMembers m) {
		members = m;
	}
	
	
	
	public JsonMembers getMembers() {
		return members;
	}
	
	public JsonValue get(String name) {
		for (JsonPair jp : members.getPairs()) {
			if (jp.getName().equals(name)) {
				return jp.getValue();
			}
		}
		return null;
	}
	
	public void display() {
		display(0);
	}
	
	
	@Override	
	public JsonTypes getType() {
		return JsonTypes.OBJECT;
	}

	@Override
	public void display(int n) {
		// TODO Auto-generated method stub
		// Tools.space(n);
		System.out.print("{\n");
		members.display(n + 1);
		Tools.space(n);
		System.out.print("}");
		
	}

}
