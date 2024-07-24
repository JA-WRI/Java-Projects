//****************************************************************
//Assignment 1
//Written by Jaden Wright-Maurais
//For Comp 248 Section W - Winter 2024
//****************************************************************

/*This program will generate the mixed fraction form of two inputed fractions and 
the subtraction of the two fractions in fraction and decimal form*/

import java.util.Scanner;
public class A1_Question1 {
public static void main(String[] args) {
	
		Scanner myKeyboard = new Scanner(System.in);
	
	System.out.println("********************************");
	System.out.println("Welcome to Fraction Calculator");
	System.out.println("********************************");
	System.out.println("Please enter numerators and non-zero denominators");
		
	//asking user for the numerator and denominator of the first fraction 
	System.out.print("* For the 1st fraction: ");
	int num_frac1 = myKeyboard.nextInt();
	int denom_frac1 = myKeyboard.nextInt();
		
	//asking user for the numerator and denominator of the second fraction 
	System.out.print("* For the 2nd fraction: ");
	int num_frac2 = myKeyboard.nextInt();
	int denom_frac2 = myKeyboard.nextInt();
		
	//calculating the mixed number of 1st fraction 
	int whole_frac1 = (num_frac1 / denom_frac1) ;
	int remain_frac1 = ( num_frac1 % denom_frac1);
		
	//calculating the mixed number of 2nd fraction 
	int whole_frac2 = (num_frac2 / denom_frac2) ;
	int remain_frac2 = ( num_frac2 % denom_frac2) ;
		
	//calculating subtraction of 1st fraction with second fraction 
	double numD_frac1 = num_frac1;
	double numD_frac2 = num_frac2;
	double sub_frac = numD_frac1/denom_frac1 -numD_frac2 / denom_frac2; //decimal form
	int num = (num_frac1*denom_frac2)-(num_frac2*denom_frac1);//fraction form
	int denom = (denom_frac1*denom_frac2);
		
	//printing results 
	System.out.println("The mixed number of the 1st fraction is " + whole_frac1 +" "+ remain_frac1+ "/"+ denom_frac1);
	System.out.println("The mixed number of the 2nd fraction is " + whole_frac2 +" "+ remain_frac2 + "/" + denom_frac2);
	System.out.println("The subtraction of "+ num_frac1 +'/'+ denom_frac1 + " and " +num_frac2+ "/" + 
			denom_frac2+ " is "+ num +"/"+ denom + " or " + sub_frac );
	System.out.println("All done!!");
		
	myKeyboard.close();
	}
}
