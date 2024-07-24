//****************************************************************
//Assignment 1
//Written by Jaden Wright-Maurais
//****************************************************************

//This program will generate a random username and password for a user.

import java.util.Scanner;

public class A1_Question2 {
public static void main(String[] args) {
	
		
	Scanner myKeyboard = new Scanner(System.in);
	System.out.println("********************************");
	System.out.println("Welcome New Users");
	System.out.println("********************************");
		
	//Asking for name
	System.out.print("Please enter your first and last name: ");
	String first_name = myKeyboard.next();
	String last_name = myKeyboard.next();
	
	//Asking for three words 
	System.out.print("\nPlease enter 3 random words for password generation: "); 
		 
	String word1 = myKeyboard.next();
	String word2 = myKeyboard.next();
	String word3 = myKeyboard.next();
	String words = word1+word2+word3;
		
	//making middle letter upper case
	int length_of_string = words.length();
	int middle_index = (int)(Math.round(length_of_string/2.0)-1);
	char middle_letter = Character.toUpperCase(words.charAt(middle_index));
	String password = words.substring(0,middle_index) + middle_letter + words.substring(middle_index +1);

	//changing fourth and ninth letter
	char fourth_letter = password.charAt(3);
	char ninth_letter = password.charAt(8);
	String new_password = password.substring(0,3)+ ninth_letter +password.substring(4,8) +
			fourth_letter + password.substring(9);
		
	//add random integer at index 5
	String finale_password = new_password.substring(0,4)+ (int)(Math.random()*10) +
			new_password.substring(4);
		
		
	//Generating random integer between 0-9
	int randInt = (int)(Math.random()*10);
		
	//printing user name and password
	System.out.println("Your auto-generated username is " + first_name.substring(0,3) +"_" 
			+ last_name.substring(0,3) + randInt );
 	System.out.println("Your auto-generated password is "+ finale_password);
		
	myKeyboard.close();

	}
}
