package com.lyhux.jsonparse;

import java.util.ArrayList;

public class JsonArray implements JsonInterface{
	private ArrayList<JsonValue> je;
	
	public JsonArray(ArrayList<JsonValue> je) {
		this.je = je;
	}

	@Override
	public JsonTypes getType() {
		return JsonTypes.ARRAY;
	}

	@Override
	public void display(int n) {
		Tools.space(n);
		System.out.println("[");
		for (JsonValue jv : je) {
			jv.display(n + 1);
		}
		Tools.space(n);
		System.out.println("]");
	}
	

}
