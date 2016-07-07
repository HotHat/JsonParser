package com.lyhux.jsonparse;


/**
 * @author lyhux
 *	Designing an interface for a recursive data type
 *	1. Include one constructor for each kind of data in the data type.
 *	2. Include one predicate for each kind of data in the data type.
 *	3. Include one extractor for each piece of data passed to a constructor
 *  of the data type. 
 */


public enum JsonTypes {
	STRING,
	NUMBER,
	OBJECT,
	ARRAY,
	Pair,
	TRUE,
	FALSE,
	NULL,
	VALUE, ELEMENT,TERMINAL
}
