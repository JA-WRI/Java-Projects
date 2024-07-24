//****************************************************************
//Assignment 2
//Written by Jaden Wright-Maurais
//****************************************************************
/*This program will estimate whether a user is eligible for a mortgage
and weather mortgage insurance is needed. If an invalid input is entered then user 
is asked to input valid input*/

import java.util.Scanner;

public class A2_Q1 {

	public static void main(String[] args) {	
		
		int priceProperty = 0;
		int salary = 0;
		int downPayment = 0;
		
		Scanner In = new Scanner(System.in);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("   Welcome to Your Personal Mortgage Broker");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

		do //verifying valid input for price of property
		{
			System.out.print("Please enter the purchase price of your property: ");
			priceProperty = In.nextInt();
		}
		while (priceProperty <= 0);
		
		do //verifying valid input for salary
		{
			System.out.print("Please enter your salary: ");
			salary = In.nextInt();
		}
		while (salary <= 0);
		
		do //verifying valid input for down payment
		{
		System.out.print("Please enter your down payment: ");
		downPayment = In.nextInt();
		}
		while (downPayment <= 0);
		
		
		//when down payment is at least 5% 
		if (downPayment >= (priceProperty*0.2)) 
		{
			//when salary is less than remaining payment 
			if (salary*5 < (priceProperty - downPayment))
				System.out.println("Unfortunately you did not pass the mortgage affordability test!");
			//when salary more than remaining payment 
			else 
				System.out.println("Congradulations! Your down payment is at least 20% of the total price. "
					+ "You passed the mortgage affodability test!");
		}
		
		//down payment is between 5% and 20%
		else if ((priceProperty*0.05) <= downPayment && downPayment < (priceProperty*0.2)) 
		{
			//When salary is less than payment 
			if (salary*5 < (priceProperty - downPayment))
				System.out.println("Unfortunately you did not pass the mortgage affordability test!");
			//When salary is more than payment 
			else
				System.out.println("Your down payment is at least 5% of the total price, but less than 20%. "
						+ "You need to purchase insurance for the mortgage"
						+ "\nCongradulations! You passed the mortgage affordability test!");
		}
			
		//down payment is less than 5%
		else if (downPayment < priceProperty*0.05) 
			System.out.println("The down payment is less than 5% of the total price. No mortgage!");
		
		//printing final message
		System.out.println("\nThank you for using Mortgage Broker!");
		
		In.close();
		
	}

}
