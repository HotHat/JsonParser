package com.lyhux.jsonparse;

public class JsonValue {

	private JsonTypes type;
	private String string;
	private double number;
	private JsonObject obj;
	private JsonArray array;
	private int level;
	
	public JsonValue() {
		
	}
	
	public JsonValue(String str) {
		
		if (str.equals("null")) {
			this.type = JsonTypes.NULL;
			this.string = str;
		} else if (str.equals("true")) {
			this.type = JsonTypes.TRUE;
			this.string = str;
		} else if (str.equals("false")) {
			this.type = JsonTypes.FALSE;
			this.string = str;
		} else {
			this.type = JsonTypes.STRING;
			this.string = str;
		}
		
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public JsonValue(Double number) {
		this.type = JsonTypes.NUMBER;
		this.number = number;
	}
	
	public JsonValue(JsonObject jo) {
		this.type = JsonTypes.OBJECT;
		jo.setLevel(level + 1);
		this.obj = jo;
	}
	
	public JsonValue(JsonArray ja) {
		this.type = JsonTypes.ARRAY;
		
		this.array = ja;
	}
	

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public JsonObject getObj() {
		return obj;
	}

	public void setObj(JsonObject obj) {
		this.obj = obj;
	}

	public JsonArray getArray() {
		return array;
	}

	public void setArray(JsonArray array) {
		this.array = array;
	}

	
	public JsonTypes getType() {
		return type;
	}

	
	@Override
	public String toString() {
 		 switch (type) {
		case NUMBER:
			return Double.toString(number);
			
		case STRING:
			return string;
		case TRUE:
			return "true";
		case FALSE:
			 return "false" ;
		case NULL:
			 return "null";
		case OBJECT:
			obj.setLevel(level);
			return obj.toString();
		case ARRAY:
			array.setLevel(level);
			return array.toString();

		default:
			return "";
		}
	}
	
}
