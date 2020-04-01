package com.livtech.demo.algos;

public class StringSamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		reverseNumber();
		reverseString();
		ReplaceSpaces();
	}

	static void reverseNumber() {
		int num = 123;
		int rnum = 0;

		while (num > 0) {
			int r = num % 10;
			rnum = rnum * 10 + r;
			num = num / 10;
		}
		System.out.println("reverse " + rnum);
	}

	static void reverseString() {
		String s1 = "abcdef";
		/*
		 * int l = s1.length();
		 * 
		 * int i = l - 1; while (i >= 0) { System.out.print(s1.charAt(i)); i--;
		 * }
		 */
		reverseStr(s1, 0);
	}

	static void reverseStr(String str, int i) {
		if (i == str.length()) {
			return;
		}
		reverseStr(str, ++i);
		i--;
		System.out.print(str.charAt(i));
	}

	static void ReplaceSpaces() {
		String s1 = "a b      cde ff";
		String strs[] = s1.split(" ");
		System.out.println("\n no of strings " + strs.length);
		s1 = "";
		for (String s : strs) {
			if (!s.isEmpty())
				s1 = s1 + s + " ";
		}
		s1.trim();
		System.out.println(s1);

	}
}
