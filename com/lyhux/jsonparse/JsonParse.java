package com.lyhux.jsonparse;

import java.util.ArrayList;

class Token{
	int start;
	int end;
	String content;
	JsonTypes type;	
}



public class JsonParse {

	private char[] json;
	private int position;
	private ArrayList<Token> tokens;
	private int tokenIndex;
	
	
	static char[] terminalChars = {'{', '}', ':', ',' , '[', ']', ' '};
	static String[] terminalString = {"false", "true", "null"};
	
	
	boolean prefix( String prefix) {
	
		if (this.json.length - this.position > prefix.length()) {
			for (int i = 0; i < prefix.length(); ++i) {
				if (json[this.position + i] != prefix.charAt(i)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	boolean isPrefixWithTerminalChars() {
		
		for (char ch : terminalChars) {
			if (ch == json[this.position]) {
				return true;
			}
		}
		
		return false;
		
	}
	
	boolean isPrefixWithTerminalChars(char c) {
		
		for (char ch : terminalChars) {
			if (ch == c) {
				return true;
			}
		}
		
		return false;
		
	}
	
	
	
	boolean isPrefixWithString() {
		for (String str : terminalString) {
			if (prefix(str)) {
				return true;
			}
			
		}
		
		return false;
	}
	boolean isWiteSpace(char c) {
		return c == ' ' || c == '\t' || c == '\n';
	}

	
	// If no such value of k exists, then -1 is returned.
	int toNextString(char[] code, String next) {
			
		return 0;
		
	}
	
	
	void moveNext() {
		this.position += 1;
	}
	
	void moveTo(int n) {
		this.position = n;
	}
	
	char getChar() {
		return this.json[this.position];
	}
	
	boolean isEndJson() {
		return this.position == this.json.length;
	}
	
	boolean isEndJson(int p) {
		return p >= this.position;
	}
	
	
	int findNext(char c) {
		
		int p = this.position + 1;
		int l = json.length;
		
		while (p < l) {
			if (json[p] == c) {
				return p;
			}
			
			p += 1;
		}
		
		return -1;
		
	}
	
	String fetchContent(int n) {
		String content = "";
		int start = this.position + 1;
		
		while (start < n){
			content += json[start];
			start += 1;
		}
		
		
		return content;
	}
	
	
	
	boolean isNumber() {
		if (Character.isDigit(getChar()) ) {
			return true;
		} else if (getChar() == '-' && Character.isDigit(getChar(position + 1))) {
			return true;
		} else {
			return false;
		}
		
	}
	
	boolean isTerminateChar(int p) {
		
		if (p == json.length || isPrefixWithTerminalChars(getChar(p)) ) {
			return true;
		}
		
		return false;
	}
	
	char getChar(int p) {
		
		return this.json[p];
		
	}
	
	String fetchNumber() throws JsonParseException {
		
		String numberStr = "";
		
		int p = this.position;
		
		int state = 1;
		
		
		if (json[p] == '-') {
			numberStr += "-";
			p += 1;
		} else {
			// this.negative = false;
		}
		
		while ( !isTerminateChar(p)) {
			
			char c = getChar(p);
			
			switch (state) {
			case 1:
				
				if (c == '0') {
					state = 2;
				} else if (Character.isDigit(c)) {
					state = 3;
				} else {
					throw new JsonParseException("Error happed at state 1, near: " + json[position]);
				}
				
				break;
			case 2:	
				
				if (c == '.') {
					state = 4;
				} else if (c == 'e' || c == 'E') {
					state = 6;
				}  else {
					throw new JsonParseException("Error happed at state 2, near: " + json[position]);
				}
				
				break;	
			case 3:	
				
				if (c == '.') {
					state = 4;
				} else if (c == 'e' || c == 'E') {
					state = 6;
				}  else if (Character.isDigit(c)) {
					state = 3;
				} else {
					throw new JsonParseException("Error happed at state 3, near: " + json[position]);
				}
				
				break;	
			case 4:	
				if (Character.isDigit(c)) {
					state = 5;
				} else {
					throw new JsonParseException("Error happed at state 4, near: " + json[position]);
				}
				
				
				break;
			case 5:	
				if (Character.isDigit(c)) {
					state = 5;
				} else if (c == 'e' || c == 'E') {
					state = 6;
				} else {
					throw new JsonParseException("Error happed at state 5, near: " + json[position]);
				}
				break;	
			case 6:	
				if (c == '+' || c == '-') {
					state = 7;
				} else if (Character.isDigit(c)) {
					state = 7;
				} else {
					throw new JsonParseException("Error happed at state 6, near: " + json[position]);
				}
				
				break;	
			case 7:	
				if (Character.isDigit(c)) {
					state = 7;
				} else {
					throw new JsonParseException("Error happed at state 7, near: " + json[position]);
				}
				break;	
				

			
			default:
				throw new JsonParseException("Error happed! near:" + json[position]);
				
			}
			
			p += 1;
			
			numberStr += c;	
			
		}
		
		
		if (state == 3 || state == 5 || state == 6 || state == 7) {
			return numberStr;
		}
		
		
		return "";
	}
	
	
	
	
	public JsonParse(String jsonstr) throws JsonParseException {

		this.json = jsonstr.toCharArray();
		
		System.out.println(jsonstr);
		
		this.position = 0;
		this.tokenIndex = 0;
		this.tokens = new ArrayList<>();
		
		System.err.println(this.json.length);
		
		scan();
		
		
	}
	
	public JsonObject parse() throws JsonParseException {
		
		return parseObject();
	}
	
	// Help function
	public void displayTokens() {
		for (Token token : this.tokens) {
			System.out.print(token.content + "\t\t");
			System.out.print(token.start + "\t\t");
			System.out.print(token.type);
			System.out.println(token.end);
		}
		
	}
	
	
	private Token scan1() throws JsonParseException {
		Token token = new Token();
		
		
		if (isPrefixWithTerminalChars()) {
			char c = getChar();
			token.content = c + "";
			token.start = this.position;
			token.end = this.position + 1;
			token.type = JsonTypes.TERMINAL;
			moveNext();
			
			
		} else if (isPrefixWithString()) {
			switch (getChar()) {
			case 't':
				token.content = "true";
				token.start = this.position;
				token.end = this.position + 4;
				token.type = JsonTypes.TERMINAL;
				
				moveTo(token.end);
				
				break;
			case 'f':
				token.content = "false";
				token.start = this.position;
				token.end = this.position + 5;
				token.type = JsonTypes.TERMINAL;
				
				
				
				moveTo(token.end);
				
				break;
			case 'n':
				token.content = "null";
				token.start = this.position;
				token.end = this.position + 4;
				token.type = JsonTypes.TERMINAL;
				
				moveTo(token.end);
				
				break;
				
			default:
				throw new JsonParseException("Wrong prefix string at " + this.position);
				
			}
		} else if (getChar() == '"') {
			int next = findNext('"');
			
			System.err.println(next);
			
			if (next != -1) {
				token.content = fetchContent(next);
				token.start = this.position;
				token.end = next;
				token.type = JsonTypes.STRING;
				
				moveTo(next + 1);
				
				System.err.println("move to: " + this.position);
				
			} else {
				throw new JsonParseException("Wrong string content start at " + this.position);
			}
			
		} else if (isNumber()) {
			String numberStr = fetchNumber();
			
			if (numberStr != "") {
				token.content = numberStr;
				token.start = this.position;
				token.end = this.position + numberStr.length();
				token.type = JsonTypes.NUMBER;
				
				
				moveTo(token.end);
			} else {
				
				throw new JsonParseException("Wrong string content start at " + this.position);
			}
			
			System.out.println(numberStr);
		}
		
		
		return token;
	}
	
	
	private void scan() throws JsonParseException {
		
		while (!isEndJson()) {
			
			if (isWiteSpace(getChar())) {
				
				moveNext();
			
			} else {
				
					Token tk = scan1();
					
					tokens.add(tk);
					
			}
			
		}
		
	}
	
	

	private Token getToken() {
		Token token = tokens.get(tokenIndex);
		return token;
	}
	
	private void tokenIndexForward() {
		tokenIndex += 1;
	}
	
	
	private JsonValue parseJsonValue() throws JsonParseException {
		
		Token tk = getToken();
		if (tk.content.equals("true")) {
			tokenIndexForward();
			return new JsonValue("true");
			
		} else if (tk.content.equals("false")) {
			tokenIndexForward();
			return new JsonValue("fales");
			
		} else if (tk.content.equals("null")) {
			tokenIndexForward();
			return new JsonValue("null");
			
		} else if (tk.content.equals("{")) {
		
			JsonObject jo = parseObject();
			return new JsonValue(jo);
			
		} else if (tk.content.equals("[")) {
			JsonArray ja = parseJsonArray();
			return new JsonValue(ja);
			
		} else if (tk.type == JsonTypes.NUMBER) {
			tokenIndexForward();
			return new JsonValue(Double.valueOf(tk.content));
			
		} else if (tk.type == JsonTypes.STRING) {
			tokenIndexForward();
			return new JsonValue(tk.content);
			
		} else {
			throw new JsonParseException("Error Type : in parseJsonValue");
		}		
		
	}
	
	
	
	
	
	private JsonArray parseJsonArray() throws JsonParseException {
		JsonArray ja = new JsonArray();
		
		
		Token tk = getToken();
		if (tk.content.equals("[")) {
			tokenIndexForward();
			
			Token tk0 = getToken();
			if (tk0.content.equals("]")) {
			
				return ja;
			
			} else {
				
				JsonValue je = parseJsonValue();
				ja.add(je);

				Token tk1 = getToken();
				while (tk1.content.equals(",")) {
					tokenIndexForward();

					JsonValue je1 = parseJsonValue();
					ja.add(je1);

					tk1 = getToken();
				}

				Token tk2 = getToken();
				if (tk2.content.equals("]")) {
					tokenIndexForward();
					return ja;
				} else {
					throw new JsonParseException("Need terminal ] in parseJsonArray");
				}

			}
			
			
		} else {
			throw new JsonParseException("Need Array begin terminal [");
		}
		

	}
	
	
	

	private JsonPair parseJsonPair() throws JsonParseException {
		
		Token tk = getToken();
		tokenIndexForward();
		
		
		Token tk1 = getToken();
		
		if (tk1.content.equals(":")) {
			tokenIndexForward();
			
			JsonValue jValue = parseJsonValue();
			return new JsonPair(tk.content, jValue);
			
		} else {
			throw new JsonParseException("Need terminal : in parseJsonPair");
		}
		
		
	}
	
	//  members : null  | moremembers;
	// moremembers : pair | pair , moremembers 
	
	

//	private JsonMembers parseJsonMembers() throws JsonParseException {
//		
//		ArrayList<JsonPair> aList = new ArrayList<>();
//		Token tk = getToken();
//		if (tk.content.equals("}")) {
//			
//			return null;
//			
//		} else {
//			
//			JsonPair jPair = parseJsonPair();
//			aList.add(jPair);
//			
//			Token tk1 = getToken();
//			
//			while (tk1.content.equals(",")) {
//				
//				tokenIndexForward();
//				
//				JsonPair jPair1 = parseJsonPair();
//				aList.add(jPair1);
//				
//				tk1 = getToken();
//			}
//			
//		}
//		
//		Token tk2 = getToken();
//		if (tk2.content.equals("}")) {
//			return new JsonMembers(aList);
//		} else {
//			throw new JsonParseException("Need terminal } in parseJsonMembers");
//		}
//		
//	}
	
	
	// object : { members }
	
	 
	private JsonObject parseObject() throws JsonParseException {
		 
		JsonObject jo = new JsonObject();

		Token tk = getToken();
		
		if (tk.content.equals("{")) {
			
			tokenIndexForward();    // index forward;
			 
			Token tkend = getToken();
			
			
			if (tkend.content.equals("}")) {
				return jo;
			} else {
				
				
				JsonPair jPair = parseJsonPair();
				jo.add(jPair.getName(), jPair.getValue());
			
				Token tk1 = getToken();
			
				while (tk1.content.equals(",")) {
				
					tokenIndexForward();
				
					JsonPair jPair1 = parseJsonPair();
					jo.add(jPair1.getName(), jPair1.getValue());
				
					tk1 = getToken();
				}

			
				if (tk1.content.equals("}")) {
					tokenIndexForward();
					return jo;
				
				} else {
					throw new JsonParseException("Need terminal } in parseObject ");
				}
				
			}

			
		} else {
			throw new JsonParseException("Parse Error: At " + tk );
		}
		
		
	}
	
	
	
}
