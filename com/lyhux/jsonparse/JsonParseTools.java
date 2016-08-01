package com.lyhux.jsonparse;

public class JsonParseTools {
	static void space(int n) {
		for (int i = 0; i < n; ++i) {
			System.out.print("\t");
		}
	}
	static String toSpace(int n) {
		String space = "";
		for (int i = 0; i < n; ++i) {
			space += "    ";
		}
		return space;
	}
}
