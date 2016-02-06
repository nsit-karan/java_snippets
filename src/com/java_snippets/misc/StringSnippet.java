package com.java_snippets.misc;

public class StringSnippet {

	public String[] splitStrin(String string) {
		String[] strings = string.split(" ");
		return strings;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringSnippet sp = new StringSnippet();
		String[] strings = sp.splitStrin("how are you");
		System.out.println(strings[0]);
	}

}
