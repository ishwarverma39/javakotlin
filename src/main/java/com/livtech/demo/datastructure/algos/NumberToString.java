package com.livtech.demo.datastructure.algos;

import java.util.ArrayList;

public class NumberToString {

	private static String[] placeValues = { "", "hundred", "thousand", "lakh", "crore" ,"billion"};

	private static String[] uniPlaceValues = { "", "hundred", "thousand", "million", "billion" };

	private static String[] tens = { "", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eigty",
			"nighty" };
	private static String[] oneTo20 = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "twelve", "thirteen", "fournteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"ninteen", "twenty" };

	public static void main(String[] args) {
		String number = "1234109";
		System.out.println(number);
		printIndinSystem(number);
		printUniversalSystem(number);

	}

	private static void printUniversalSystem(String number) {
		ArrayList<String> nums = getNumbers(number,3);
		System.out.println("Universal Standard");
		printUniversalWords(nums);
	}

	private static ArrayList<String> getNumbers(String numberStr, int maxDigits) {
		numberStr = new StringBuilder(numberStr).reverse().toString();
		int length = numberStr.length();
		ArrayList<String> numbers = new ArrayList<>();
		int digits = 0;
		String num = "";
		for (int i = 0; i < length; i++) {
			if(i==0){
				num = String.valueOf(numberStr.charAt(i));
			}else if(i==1){
				num = String.valueOf(numberStr.charAt(i)) + num;
				digits=maxDigits;
			}
			else if (i == 2) {
				num = String.valueOf(numberStr.charAt(i));
				digits=maxDigits;
			} else {
				num = String.valueOf(numberStr.charAt(i)) + num;
				digits++;
			}
			if (digits == maxDigits || i == length - 1) {
				numbers.add(num);
				digits = 0;
				num="";
			}

		}
		return numbers;
	}

	private static void printIndinSystem(String number) {
		ArrayList<String> nums = getNumbers(number, 2);
		System.out.println("Indian Standard");
		printIndianWords(nums);
	}

	private static String getThreeDigitWord(int num) {
		String word = "";
		if (num < 100) {
			word = getTwoDigitWord(num);
		} else {
			int rem = num % 100;
			int q = num / 100;
			word = oneTo20[q] +" hundred "+ getTwoDigitWord(rem);
		}
		return word;
	}

	private static String getTwoDigitWord(int num) {
		String word = "";
		if (num <= 20) {
			word = oneTo20[num] + " " + word;
		} else {
			int first = num % 10;
			int second = num / 10;
			word = tens[second] + " " + oneTo20[first] + " " + word;
		}
		return word;
	}

	/*
	 * this method prints the numbers for each place value
	 */
	private static void printIndianWords(ArrayList<String> nums) {
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < nums.size(); i++) {
			int num = Integer.parseInt(nums.get(i));
			// if number at any place-value is 0 then no need to print
			if (num != 0) {
				word.insert(0, getTwoDigitWord(num) + placeValues[i] + " ");
			}
		}
		System.out.println(word);
	}
	
	/*
	 * this method prints the numbers for each place value
	 */
	private static void printUniversalWords(ArrayList<String> nums) {
		StringBuilder word = new StringBuilder();
		for (int i = 0; i < nums.size(); i++) {
			int num = Integer.parseInt(nums.get(i));
			// if number at any place-value is 0 then no need to print
			if (num != 0) {
				word.insert(0, getThreeDigitWord(num) + uniPlaceValues[i] + " ");
			}
		}
		System.out.println(word);
	}
}
