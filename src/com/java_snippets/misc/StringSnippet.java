package com.java_snippets.misc;

public class StringSnippet {

	public String[] splitStrin(String string) {
		String[] strings = string.split(" ");
		return strings;
	}
	
	/*
	 * -------is char test --------
	 * Checking for a (first char only) : true 
	 * Checking for 1 (first char only) : false 
	 * Checking for 0 (first char only) : false
	 */
	public void testString(String s) {
		Character c = s.charAt(0);
		System.out.printf("Checking for %s (first char only) : %b \n", s, Character.isAlphabetic(c));
	}
	
	/*
	 * -------is digit test-----------
	 * Checking for a (first char only) : false 
	 * Checking for 1 (first char only) : true 
	 */
	public void testDigit(String s) {
		Character c = s.charAt(0);
		System.out.printf("Checking for %s (first char only) : %b \n", s, Character.isDigit(c));
	}
	
	public void testStringParse(String s) {
		System.out.printf("Int equivalent for %s == %d \n", s, Integer.parseInt(s));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringSnippet sp = new StringSnippet();
		String[] strings = sp.splitStrin("how are you");
		System.out.println(strings[0]);
		
		System.out.println("-------is char test --------");
		sp.testString("a");
		sp.testString("1");
		sp.testString("0");
		
		System.out.println("-------is digit test-----------");
		sp.testDigit("a");
		sp.testDigit("1");
		
		System.out.println("--- string ==> Int");
		sp.testStringParse("1234");
		sp.testStringParse("0000001");
	}

}
