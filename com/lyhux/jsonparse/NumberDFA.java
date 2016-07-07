package com.lyhux.jsonparse;



/**
 * 
 * @author Administrator
 *
 *	A DFA can be represented by a 5-tuple (Q, 鈭�, 未, q0, F) where 鈭�

	Q is a finite set of states.

	鈭� is a finite set of symbols called the alphabet.

	未 is the transition function where 未: Q 脳 鈭� 鈫� Q

	q0 is the initial state from where any input is processed (q0 鈭� Q).

	F is a set of final state/states of Q (F 鈯� Q).
 */


/*
	

*/

public class NumberDFA {

	private int state;
	
	private char[] code;
	private int position;
	
	private boolean negative;
	
	
	public NumberDFA(String code) {
		this.code = code.toCharArray();
		
		this.state = 1;
		this.negative = false;
	}
	
	void forward() {
		this.position += 1;
	}
	char getChar() {
		return code[position];
	}
	
	
	boolean isTerminate() {
		if (position == code.length || code[position] == ' ') {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean test() throws Exception {
		
	
		
		if (code[0] == '-') {
			this.negative = true;
			this.position += 1;
		} else {
			this.negative = false;
		}
		
		while (!isTerminate()) {
			
			char c = getChar();
			
			switch (state) {
			case 1:
				
				if (c == '0') {
					this.state = 2;
				} else if (Character.isDigit(c)) {
					this.state = 3;
				} else {
					throw new Exception("Error happed at state 1, near: " + code[position]);
				}
				
				break;
			case 2:	
				
				if (c == '.') {
					this.state = 4;
				} else if (c == 'e' || c == 'E') {
					this.state = 6;
				}  else {
					throw new Exception("Error happed at state 2, near: " + code[position]);
				}
				
				break;	
			case 3:	
				
				if (c == '.') {
					this.state = 4;
				} else if (c == 'e' || c == 'E') {
					this.state = 6;
				}  else if (Character.isDigit(c)) {
					this.state = 3;
				} else {
					throw new Exception("Error happed at state 3, near: " + code[position]);
				}
				
				break;	
			case 4:	
				if (Character.isDigit(c)) {
					this.state = 5;
				} else {
					throw new Exception("Error happed at state 4, near: " + code[position]);
				}
				
				
				break;
			case 5:	
				if (Character.isDigit(c)) {
					this.state = 5;
				} else if (c == 'e' || c == 'E') {
					this.state = 6;
				} else {
					throw new Exception("Error happed at state 5, near: " + code[position]);
				}
				break;	
			case 6:	
				if (c == '+' || c == '-') {
					this.state = 7;
				} else if (Character.isDigit(c)) {
					this.state = 7;
				} else {
					throw new Exception("Error happed at state 6, near: " + code[position]);
				}
				
				break;	
			case 7:	
				if (Character.isDigit(c)) {
					this.state = 7;
				} else {
					throw new Exception("Error happed at state 7, near: " + code[position]);
				}
				break;	
				
//			case 8:	
//				throw new Exception("Error happed at state 8, near: " + code[position]);
//				
//				
			
			default:
				throw new Exception("Error happed! near:" + code[position]);
				
			}
			
			forward();
		}
		
		
		if (state == 3 || state == 5 || state == 6 || state == 7) {
			return true;
		}
		
		
		
		return false;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		String number = "-982E-9823 ao";
		
		NumberDFA ndnf = new NumberDFA(number);
		
		boolean r = ndnf.test();
		
		System.out.println(r);
		
	}
	
	
	
	
	
}
