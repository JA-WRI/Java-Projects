//****************************************************************
//Assignment 3
//Written by Jaden Wright-Maurais
//****************************************************************
/* This program computes encoded information/text by pruning and 
preprocessing any given string/text to ensure that the first and last characters of the string/text 
is a non-space character; thereafter, it counts the number of characters in the string/text. If the 
preprocessed string/text is comprised of an even number of characters; then, the new encoded 
string will consist of the reverse of second half of the text, and the first half of the original text. If 
the preprocessed string/text is comprised of an odd number of characters; then, the new 
encoded string will be composed of (i) the reverse of second half of the string after the middle 
character, (ii) the middle character of original string, (iii) the reverse of the first half of the original 
string before the middle character. It will then print the ciphertext*/

import java.util.Scanner;

public class A3_Q1 {

	public static void main(String[] args) {
		
		String encodedText ="";
		String userText = "";
		
		Scanner In = new Scanner(System.in);
		System.out.println("Welcome to Concordia CSSE Drone Cipher Program:");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\nPlease enter your plain message below:");
		String userStr = In.nextLine();
		

		//Taking away any leading or trailing spaces and calculating length
		userText = userStr.trim();
		int sizeText = userText.length();
			
		//when length of word is even number of characters
		if (sizeText %2 == 0) 
		{
			int middleIndex = sizeText/2;
			String secondHalf = userText.substring(middleIndex);
				
			//Reversing second half of string
			String reverseSecondHalf ="";
			for (int index = 0; index < secondHalf.length(); index +=1)
				reverseSecondHalf = secondHalf.charAt(index) + reverseSecondHalf;
			
			//producing cipher message
			encodedText = reverseSecondHalf + userText.substring(0,middleIndex);
		}
		
		//when length of word is odd number characters
		else if (sizeText %2 != 0) 
		{
			int middleIndex = sizeText/2;
			String secondHalf = userText.substring(middleIndex);
			String firstHalf = userText.substring(0,middleIndex);
				
			//Reversing second half of string
			String reverseSecondHalf ="";
			for (int index = 0; index < secondHalf.length(); index +=1)
				reverseSecondHalf = secondHalf.charAt(index) + reverseSecondHalf;
			
			//Reversing first half of string
			String reverseFirstHalf = "";
			for (int index = 0; index < firstHalf.length(); index +=1)
				reverseFirstHalf = firstHalf.charAt(index) + reverseFirstHalf;
				
			//producing cipher message
			encodedText = reverseSecondHalf + reverseFirstHalf;	
		}
			
		System.out.println("\nKindly find below your cipher message output:\n"+encodedText);
		System.out.println("\nThank you for your contribution to Concordia CSSE Drone Cipher Project.");
		In.close();
	}

}
