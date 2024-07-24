
public class Clinic {
	
	//attributes 
	private String clinicName;
	private String clinicCode;
	private String clinicTerm;
	private Individual dentist;
	private Individual [] dentalAsst;
	private Individual [] patient;
	
	//default constructors 
	public Clinic() {
		clinicName="";
		clinicCode= "";
		clinicTerm="";
		dentalAsst=null;
		patient =null;
	}
	//parameterized constructor 
	public Clinic(String inClinicName, String inClinicCode, String inClinicTerm, Individual inDentist, Individual[] inDentalAsst, Individual[] inPatient) {
		setClinicName(inClinicName);
		setClinicCode(inClinicCode);
		setClinicTerm(inClinicTerm);
		setDentist(inDentist);
		setDentalAsst(inDentalAsst);
		setPatient(inPatient);
	}
	
	//getters
	public String getClinicName() {
		return clinicName;
	}
	public String getClinicCode() {
		return clinicCode;
	}
	public String getClinicTerm() {
		return clinicTerm;
	}
	public Individual getDentist() {
		return dentist;
	}
	public Individual[] getDentalAsst() {
		if (dentalAsst ==null)
			return null;
		Individual[] array = new Individual[dentalAsst.length];
		for (int i =0; i<dentalAsst.length; i++)
			array[i] = new Individual(dentalAsst[i]);
		return array;
	}
	public Individual[] getPatient() {
	if (patient == null)
		return null;
		Individual[] array = new Individual[patient.length];
		for (int i =0; i<patient.length; i++)
			array[i] = new Individual(patient[i]);
		return array;
	}
	
	//setters
	public void  setClinicName(String inClinicName) {
		clinicName = inClinicName;
	}
	public void setClinicCode(String inClinicCode) {
		clinicCode = inClinicCode;
	}
	public void setClinicTerm(String inClinicTerm) {
		clinicTerm = inClinicTerm;
	}
	public void setDentist(Individual inDentist) {
		dentist = inDentist;
	}
	public void setDentalAsst(Individual[] inClinicAsst) {
		dentalAsst = inClinicAsst;
	}
	public void setPatient(Individual[] inPatient) {
		patient= inPatient;
	}
	
	//Override
	String dentalAsstValues="";
	public String toString() {
		for (int i=0; i <dentalAsst.length; i++)
			dentalAsstValues = dentalAsst[i]+ " " + dentalAsstValues;
		String info = (clinicName + "\n"+ clinicCode + "\n" + clinicTerm +"\n" +  dentist +"\n" +  dentalAsst.length + "\n" + patient.length);
		return info;
	} 
	
	
	public Individual[] appendToIndividualArr(Individual[]newArr, int code) {
		
		//initializing how many rows in new array depending on user code
		int row = (code ==1003? dentalAsst.length + newArr.length: patient.length + newArr.length);
		Individual[] newArray = new Individual[row]; //initializing new array
		
		switch (code) {
		//code 1003 will append new individual to dentalAsst array
		case 1003:
			for (int i=0; i< dentalAsst.length; i++) 
				newArray[i]= dentalAsst[i];
			for (int i=dentalAsst.length, j=0; i< row; i++ , j++ )
				newArray[i]= newArr[j];
			setDentalAsst(newArray);
			break;
		//code 1004 will append new individual to patient array
		case 1004:
			for (int i=0; i< patient.length; i++) 
				newArray[i]= patient[i];
			for (int i=patient.length, j=0; i< row; i++, j++  )
				newArray[i]= newArr[j];
			setPatient(newArray);
			break;
		}
		return newArray.clone();
	}
	public String deleteFromIndividualArr(String inStr, int code) {

		String toGetRidof="";
		Individual person;
		
		switch(code) {
		case 1003:
			//code 1003 will delete from dentalAsst array
			if (dentalAsst ==null)
				return "You cannot delete any entity from an EMPTY array.";
			//checking if inStr is equal to any existing dental assistants  
			for (int j=0; j<dentalAsst.length;j++) {
				person =dentalAsst[j];
				//if inStr is equal to one of the existing dental assistants, it will be removed from array
				if (inStr.equals(person.getEntityID())) { 
					toGetRidof = person.toString();
					Individual[] newArray = new Individual[dentalAsst.length-1];
					for (int i=0, toAdd=0; i<dentalAsst.length-1; i++,toAdd++) {
						if (i==j)
							toAdd+=1;
						newArray[i] = dentalAsst[toAdd];
					}	
					setDentalAsst(newArray);//setting newArray to the new patient array of the class 
					return "Successfully Deleted: " + toGetRidof + "." ;
				}
			}
			//if the inStr does not match any existing array will print message 
			return("Entity NOT found: " + inStr + "." );
			
			case 1004:
				if (patient ==null)
					return "You cannot delete any entity from an EMPTY array";
				//Checking if entity Id entered by user is equal to Id of existing patient
				for (int j=0; j<patient.length;j++) {
					person =patient[j];
					//id ID equals to existing patient then that patient will be deleted 
					if (inStr.equals(person.getEntityID())) { 
						toGetRidof = person.toString();
						Individual[] newArray2 = new Individual[patient.length-1];
						for (int i=0, toAdd=0; i<patient.length-1; i++,toAdd++) {
							if (i==j)
								toAdd+=1;
							newArray2[i] = patient[toAdd];
						}
						setPatient(newArray2); //setting newArray2 as the patient array of the clinic 
						return "Successfully Deleted: " + toGetRidof + "." ;
					}
				}
				//if Id does not equal any existing patients then message will be printed 
				return("Entity NOT found: " + inStr + "." );	
		}
		return "";
		
	}
	public String updateIndividuaCharge(String inStr, int code) {
		if (patient==null)
			return "You cannot add/update charge using an EMPTY array";
		
		//splitting string of id and charge number 
		String[] IdandCharge = inStr.split(",");
		Individual thePatient;
		//the charge number will be set to the patient with corresponding id
		for (int i=0; i<patient.length;i++) {
			thePatient = patient[i];
			if (IdandCharge[0].equals(thePatient.getEntityID())) {
				thePatient.setChargePercent(Double.valueOf(IdandCharge[1]) + thePatient.getChargePercent());
				return "Successfully Added/Updated: Charge for " + thePatient.toString() + ".";
			}
		}
		//if id entered does not equal to any existing patient, the following message will be returned 
		return "Entity not found: "+IdandCharge[0] + ".";
	}
	public void clinicStats() {
		//Displaying table of clinic statistics 
		System.out.println("\n\n" + ".".repeat(25)+ "Office Clinic/Statistics" + ".".repeat(25));
		System.out.println(".".repeat(73));
		System.out.println(". Clinic Name" + " ".repeat(10) + ": " + Individual.upperCase(clinicName) + " ".repeat(47-clinicName.length()) + ".");
		System.out.println(". Clinic Code" + " ".repeat(10) + ": " + Individual.upperCase(clinicCode) + " ".repeat(47-clinicCode.length()) + ".");
		System.out.println(". Term/Permit" + " ".repeat(10) + ": " + clinicTerm + " ".repeat(47-clinicTerm.length()) + ".");
		System.out.println(". Dentist Name" + " ".repeat(9) + ": " + dentist + " ".repeat(42 -(dentist.getEntityID().length()+
				dentist.getFirstname().length()+dentist.getLastName().length())) + ".");
		//printing each dental Assistant by iterating through dentalAsst array
		for (int i=0, j=1; i<dentalAsst.length; i++,j++)
			System.out.println(". Dental Assistant" + " ".repeat(4) +j+": "+ dentalAsst[i] + " ".repeat(42 -(dentalAsst[i].getEntityID().length()+
					dentalAsst[i].getFirstname().length()+dentalAsst[i].getLastName().length())) + ".");
		System.out.println(". Registered patients  : " + patient.length + " ".repeat(46) + ".");
		System.out.println(".".repeat(73));
		
	}
	public void chargeSheet() {
		//displaying table of patients charges 
		System.out.println("\n\n"+ ".".repeat(25)+ "Office Clinic/Chargesheet" + ".".repeat(24));
		System.out.println(". " + "P/N. " + "patient ID  " + "SURNAME" + " ".repeat(14) + "First Name" + " ".repeat(16) + "Charge .");
		System.out.println(".".repeat(74));
		//printing each patient by iterating through patient array
		for (int i=0, j=1; i<patient.length; i++, j++)
			System.out.println(".   " + j + ". " + patient[i].getEntityID() + " ".repeat(12-(patient[i].getEntityID().length())) + patient[i].getLastName() + 
					" ".repeat(21- (patient[i].getLastName().length())) + patient[i].getFirstname() + " ".repeat(33-(patient[i].getFirstname().length() + 
							String.valueOf(patient[i].getChargePercent()).length()))+ patient[i].getChargePercent() + " .");
		System.out.println(".".repeat(74));
	}
}
