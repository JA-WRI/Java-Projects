//****************************************************************
//Assignment 3
//Written by Jaden Wright-Maurais
//For Comp 248 Section W - Winter 2024
//****************************************************************
/* This program represents a simple dental clinic management system. The user will be prompted to choose
 form 1 of 5 options. If the user enters 1 then the particulars of every practitioner dentists in the
 clinic will be printed. If the user enters 2, then they will be able to assign a patient to a dentists
 by entering the associated ID. If the user enters 3, then a new string of dentists can be appended to the 
 already existing list if clinic's dentists. If the user enters 4, then a comprehensive and intuitive
 list of dentists details will appear. This includes the dentists name and ID, with the amount of patients 
 each one is assigned to and their ranking. The user will continue through this program until they enter
 0 to exist out of the SDCMS*/

import java.util.Scanner;
public class A3_Q2 {
public static void main(String[] args) {
	
	
	String task;
	String[] iteam;
	String id ="";
	String name= "";
	String count ="0";
	
	Scanner In = new Scanner(System.in);
	System.out.println("Welcome to Simple Dental Clinic Management System (SDCMS)");
	System.out.println("+".repeat(57));
	System.out.println("\nPlease enter a String collection of dental specialists below:");
	String userInfo = In.nextLine();
	int row = userInfo.split(";").length+10;
	//displaying Handle menu
	System.out.println("*".repeat(39));
	System.out.println("| Code -> Description"+ " ".repeat(17) + "|");
	System.out.println("*".repeat(39));
	System.out.println("|  1   -> Display dentists"+ " ".repeat(12)+ "|");
	System.out.println("|  2   -> Add a patient" + " ".repeat(15)+"|");
	System.out.println("|  3   -> Add new dentist(s)" +" ".repeat(10)+ "|");
	System.out.println("|  4   -> Display details" +" ".repeat(13) +"|");
	System.out.println("|  0   -> Exit SDCMS" + " ".repeat(18)+ "|");
	System.out.println("*".repeat(39));
	
	
	//initializing all dentists to have 0 patients 
	String [][] numPatients = new String[row][1];
		for(int i=0; i< row; i++)
			numPatients[i][0]="0";
	

	do {	
		System.out.print("\nEnter a code, from the aforementioned, that corresponds to your task: ");
		task = In.next();
	}
	while( 0 > Integer.valueOf(task) || Integer.valueOf(task) > 4);
	
	
	//continue to run program until user enters 0
	do {
		//getting number of rows
		int rows = userInfo.split(";").length;
		//creating 2-D array with name, id and number of patients for each dentists
		String[][] dentists = new String[rows][3];
		
		//filling array with string of dental specialists
		for (int i=0; i< rows; i++) 
		{
			iteam = userInfo.split(";")[i].trim().toUpperCase().split(",");
			for (int j = 0; j<2; j++) {
				dentists[i][j] = iteam[j];
				dentists[i][2]="0";
			}
		}
		
		//filling new array with number of patients for each dentists
		for (int r =0; r< rows; r++)
			dentists[r][2]=numPatients[r][0];
			
		
		switch (task) {
		case "1":
			System.out.println("*".repeat(39));
			System.out.println("| ID -> Dentist's Name" + " ".repeat(16) +"|");
			System.out.println("*".repeat(39));
			//iterating through array and printing each ID with corresponding name
			for (int i=0; i <rows; i++)
			{
				id = dentists[i][0];
				name = dentists[i][1];
				System.out.println("| "+ " ".repeat(2-(id.length()-1)) + id +" " + " -> " + name +" ".repeat(28-name.length())+"|");
			}
			System.out.println("*".repeat(39));
			break;
		case "2":
			System.out.print("\nPlease enter the ID of the dentist you want to assign a patient to: ");
			String dentistId = In.next();
			//iterating through dentists array
			for (int i =0; i < rows; i++ ) 
			{
				//when dentists Id matches that of user input then number of patients for that dentist is incremented
				if (dentists[i][0].equals(dentistId)) 
				{
					id = dentists[i][0];
					name = dentists[i][1];
					count = String.valueOf(Integer.valueOf(dentists[i][2])+1); //incrementing number of patients
					dentists[i][2]= count;
					break;
				}
			}
			//iterate through whole dentists list and creating new array of index and number of patients
			for (int m =0; m < rows; m++ ) {
				numPatients[m][0]= dentists[m][2];	
			}
			System.out.println("New patient has been successfully assigned to : " + name + " holding specialist ID: " + id );		
			break;
		case "3":
			System.out.println("\nPlease enter a String collection of the NEW dentist(s) below:");
			String junk =  In.nextLine(); //catching tab space 
			String newuser = In.nextLine();
			userInfo = userInfo + ";" + newuser ; //creating new string of dental specialists 
			rows = userInfo.split(";").length;
			
			System.out.println("Successfully added NEW dentist(s) to the Simple Dental Clinic Management System (SDCMS).");
			break;
			
		case "4": 
			System.out.println("*".repeat(56));
			System.out.println("| Rank | # of patients | ID | Dentist's Name"+" ".repeat(11)+"|");
			System.out.println("*".repeat(56));
		   
			//sorting through array of Dentists in decreasing order of most patients 
			for(int i = 0 ; i < dentists.length;i++){
		       for(int scan = i+1 ; scan< dentists.length;scan++){
		            if(Integer.valueOf((dentists[i][2]))< Integer.valueOf(dentists[scan][2]))
		            {
		                String[] temp = dentists[i]; //storing smaller object in temporary variable 
		                dentists[i] = dentists[scan]; //putting bigger object in lower index 
		                dentists[scan] = temp; //putting smaller object in higher index 
		            }
		        }
		    }
			
			//iterating through array of dentists
			int rank =0;
		    for(int k = 0; k < dentists.length;k++) {
		    	int previousRank =rank;
		    	rank =previousRank+1;
		    	System.out.print("|"+" ".repeat(4));
		    	
		    	//If two dentists have the same number of patients then they have the same rank 
		    	if (k>0)
		    		if (dentists[k][2].equals(dentists[k-1][2]))
		    			rank = previousRank;
		    	//Displaying dentists in decreasing order of most patients with rank
				System.out.println((rank)+" |"+ " ".repeat(13)+ dentists[k][2]+
						" |"+ " ".repeat(3-(dentists[k][0].length()-1))+dentists[k][0]+ " | "+ dentists[k][1] + " ".repeat(24- dentists[k][1].length())+ "|");
		    }
		    System.out.println("*".repeat(56));;
		}
		System.out.print("\nKindly continue by entering a valid code, from the aforementioned, which corresponds to your task: ");
		task = In.next();
	}
	while((task.equals("0"))==false ); //repeat if string value entered by user is not 0
	
	//closing message
	System.out.println("\nThank you for using our Simple Dental Clinic Management System (SDCMS).");
	In.close();
}

}



