package com.lyhux.jsonparse;

import java.util.ArrayList;

public class JsonArray {
	private ArrayList<JsonValue> je;
	private int level;
	
	
	public JsonArray() {
		 je = new ArrayList<JsonValue>();
	}
	
	public JsonValue get(int n) {
		return je.get(n);
	}
	
	public void add(JsonValue value) {
		je.add(value);
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public ArrayList<JsonValue> getList() {
		return je;
	}
	
	public JsonTypes getType() {
		return JsonTypes.ARRAY;
	}

	
	@Override
	public String toString() {
			
		String content = "";
		
		content += "\n";
		content += JsonParseTools.toSpace(level);
		content += "[ \n";
		
		for (JsonValue jv : je) {
			if (jv == je.get(je.size() - 1)) {
				jv.setLevel(level + 1);
				if (jv.getType() != JsonTypes.ARRAY ||
					jv.getType() != JsonTypes.OBJECT) {
					content += JsonParseTools.toSpace(level + 1);
				}
				content += jv.toString();
				content += "\n";
			} else {
				jv.setLevel(level + 1);
				if (jv.getType() != JsonTypes.ARRAY ||
						jv.getType() != JsonTypes.OBJECT) {
						content += JsonParseTools.toSpace(level + 1);
				}
				content += jv.toString();
				content += ", \n";
			}
			
		}
		content += JsonParseTools.toSpace(level);
		content += "]";
		
		
		return content;
	}
	 
	

}
