package com.lyhux.jsonparse;

public class JsonValue implements JsonInterface {

	private JsonTypes type;
	private String string;
	private double number;
	private JsonObject obj;
	private JsonArray array;
	private String special;

	public void setType(JsonTypes type) {
		this.type = type;
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

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	@Override
	public JsonTypes getType() {
		return type;
	}

	@Override
	public void display(int n) {

		switch (type) {
		case NUMBER:
			System.out.print(number);
			break;
		case STRING:
			System.out.print(string);
			break;
		case TRUE:
			System.out.print("true");
			break;
		case FALSE:
			System.out.print("false");
			break;
		case NULL:
			System.out.print("null");
			break;
		case OBJECT:
			obj.display(n);
			break;
		case ARRAY:
			array.display(n);
			break;

		default:
			break;
		}

	}
}
