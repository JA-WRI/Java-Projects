//****************************************************************
//Assignment 2
//Written by Jaden Wright-Maurais
//For Comp 248 Section W - Winter 2024
//****************************************************************
/*This program implements a new big-scale system for mobile dental clinics that will serve Quebecers, 
 * anywhere and everywhere. This program allows you to create a clinic and add a main dentist,
 * along with some dental assistants and patients. Using this program, you can also delete any exiting dental Assistances 
 * and or patients as well as update any patient charges.*/

import java.util.Scanner;
public class DentalClinicDriver {

	public static void main(String[] args) {
		
		Clinic newClinic = new Clinic();
		Scanner in = new Scanner(System.in);
		
		//Welcome message
		System.out.println("+".repeat(73));
		System.out.println("+ Welcome to the Simple Mobile Dental Clinic Management System (SMDCMS) +");
		System.out.println("+".repeat(73));
		
		System.out.println("\n\nCode -> Description\n+++++++++++++++++++\n" +
		" 1001 -> Define Office/Clinic\n" +
		" 1002 -> Add Dentist to Office/Clinic\n" +
		" 1003 -> Add Dental Assistants (Hygienists/Clerks) to Office/Clinic\n" +
		" 1004 -> Register Patient(s) to Office/Clinic\n" +
		" 1005 -> Deregister Dental Assisstant(s) and/or Patient(s)\n" +
		" 1006 -> Enter/Update Patient(s) Charges\n" +
		" 1007 -> Display Patients' Statistics\n" +
		" 1008 -> Display office/Clinic Statistics\n" +
		" 1009 -> Display Chargesheet\n" +
		" 1010 -> EXIT\n\n");
		
		System.out.print("Please enter a Code, from the aforementioned, that corresponds to your task: ");
		int code = in.nextInt();
		
		//Run program until user enters 1010
		do {
			switch (code){
			
			case 1001:
				System.out.println("\n\n...Define Office/Clinic...\n..........................");
				System.out.println("Enter Office/Clinic information (ClinicName ClinicCode Term/Permit) as a single-line entry: ");
				in.nextLine();
				//Spiting user input into array to separate clinic name, clinic code and the clinic term
				String [] info = in.nextLine().split(" ");		
				//setting clinic attributes 
				newClinic.setClinicName(info[0]);
				newClinic.setClinicCode(info[1]);
				newClinic.setClinicTerm(info[2]);
				System.out.print("Successful operation! ");
				break;
				
			case 1002:
				System.out.println("\n\n...Add Dentist for Office/Clinic...\n...................................");
				System.out.println("Enter dentist's information (EmployeeID FirstName LastName) as a single line entry: \n");
				in.nextLine();
				//splitting user input to separate dentist ID, first name, and last name
				String[] dentistInfo = in.nextLine().split(" ");
				Individual newDentist = new Individual(dentistInfo[0], dentistInfo[1], dentistInfo[2]);
				//setting dentist to clinic 
				newClinic.setDentist(newDentist);
				System.out.print("Successful operation! ");
				break;
				
			case 1003:
				System.out.println("\n\n...Add Dental Assistants (Hygienists/Clerks) to Office/Clinic...");
				System.out.println(".".repeat(64));
				System.out.println("Enter Dental Assistance(s) information (ID, FirstName1, LastName1; ID2, FirstName2, LastName2): ");
				in.nextLine();
				String input = in.nextLine();
				//creating array of dental assistants of type Individual using method from Individual class 
				Individual[] dental_Ass = Individual.inStrToIndividualArr(input);
				
				//if the dentalAsst array is null we set the first Individual from dental_ass as the first dental assistant in the clinic 
				int starting =0;
				if (newClinic.getDentalAsst()==null) {
					Individual[] arr = new Individual[1];
					arr[0]= dental_Ass[0];
					newClinic.setDentalAsst(arr);
					System.out.println("Successfully Added: " +dental_Ass[0].toString() +"." );
					starting+=1;
				}
				//checking if any individuals entered by user is equal to a dental Assistant in dentalAsst array
				for(int i=starting; i<dental_Ass.length; i++) {
					int count=0;
					for (int j=0; j<newClinic.getDentalAsst().length; j++) {
						if (dental_Ass[i].getEntityID().equals(newClinic.getDentalAsst()[j].getEntityID())) {
							System.out.println("Already Exists: " + dental_Ass[i].toString() + ".");
							count+=1;
						}	
					}
					//appending every individual that didn't already exist in as a dental assistant to the dentalAsst array
					if (count==0) {
					Individual[] appen = new Individual[1];
					appen[0]= dental_Ass[i];
					//appending dental assistant using method from clinic class
					newClinic.appendToIndividualArr(appen, code);
					System.out.println("Successfully Added: " +dental_Ass[i].toString() +"." );
					}
				}
				break;
			case 1004:
				System.out.println("\n\n...Register Patient(s) at Office/Clinic...");
				System.out.println(".".repeat(50));
				System.out.println("Enter Patients information (ID1, FIrstName1, LastName1; ID2, FirstName2, LastName2):");
				in.nextLine();
				String inStr = in.nextLine();
				//creating array of patients of type Individual using method from Individual class 
				Individual[] pat = Individual.inStrToIndividualArr(inStr);
				
				//if the patient array is null we set the first Individual from patient as the first patient in the clinic 
				int start =0;
				if (newClinic.getPatient()==null) {
					Individual[] arr = new Individual[1];
					arr[0]= pat[0];
					newClinic.setPatient(arr);
					System.out.println("Successfully Added: " +pat[0].toString() +"." );
					start+=1;
				}
				//checking if any individuals entered by user is equal to an already existing patient
				for(int i=start; i<pat.length; i++) {
					int count=0;
					for (int j=0; j<newClinic.getPatient().length; j++) {
						if (pat[i].getEntityID().equals(newClinic.getPatient()[j].getEntityID())) {
							System.out.println("Already Exists: " + pat[i].toString());
							count+=1;
							}	
						}
					//appending every patient that didn't already exist to the patient array
					if (count==0) {
					Individual[] appen = new Individual[1];
					appen[0]= pat[i];
					//appending patient using method from clinic class 
					newClinic.appendToIndividualArr(appen, code);
					System.out.println("Successfully Added: " +pat[i].toString() +"." );
					}
				}
				break;
				
			case 1005:
				System.out.println("\n\n...DeRegister Dental Assistant(s) and/or Patient(s)...\n" + ".".repeat(50));
				System.out.println("Enter '1003' to deregister Dental Assistant(s) and '1004' to deregister Patient(s): ");
				code = in.nextInt();
				System.out.println("Enter information of entities (ID1; ID2):");
				String[] id = in.next().split(";");
				//deleting Individuals according to their entity ID using method from clinic class 
				for (int i=0; i<id.length; i++) 
					System.out.println(newClinic.deleteFromIndividualArr(id[i],code));
				break;
				
			case 1006:
				System.out.println("\n\n...Enter/Update Patient(s) Charges...\n" + ".".repeat(50));
				System.out.println("Enter Patients' Charges (ID1, Charge1;Id2,Charge2):");
				String[] charges = in.next().split(";");
				//updating individuals charges using corresponding entity IDs, using method from clinic class 
				for (int i=0; i<charges.length;i++)
					System.out.println(newClinic.updateIndividuaCharge(charges[i],code));
				break;
				
			case 1007:
				//Displaying table 
				System.out.println("\n\n...Display Patients' Statistics...\n" +".".repeat(40));
				System.out.println(Individual.upperCase(newClinic.getClinicName()) + " (" + newClinic.getClinicTerm() + "): " + newClinic.getClinicTerm() +"\n" +
				"dentist: Dr. " + newClinic.getDentist() + "\nDental Assistants: " + newClinic.getDentalAsst().length + " Dental Assistant(s)" +
						"\nThe number of patients rehistered with the clinic: " + newClinic.getPatient().length + " patients\n" + ".".repeat(40));
				//iterating through the patient array to print each patient into the table 
				for (int i=0;i<newClinic.getPatient().length; i++)
					System.out.println(" "+ (i+1) +". " + newClinic.getPatient()[i]);
				System.out.println(".".repeat(40));
				break;
				
			case 1008:
				//display clinic statistics using method from clinic class 
				newClinic.clinicStats();
				break;
			case 1009:
				//displaying patient charges using method from clinic class 
				newClinic.chargeSheet();
				break;
			}
			//go to closing statement if user enters 1010
			if (code==1010)
				break;
			System.out.print("Kindly continue by entering a Code, from the menu above, that corresponds to your task: ");
			code = in.nextInt();
			//System.out.println("\n");
			
		}
		while(code !=1010);
		//closing message
		System.out.println("Simple SMCSMS >>> Exiting...\n\nThank you for fostering our Simple Mobile Dental Clinic Management System (SMDCMS).");	
		in.close();
	}
}
