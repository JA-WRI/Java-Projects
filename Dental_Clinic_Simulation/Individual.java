
public class Individual {
	
	//attributes
	private String entityID;
	private String firstName;
	private String lastName;
	private double chargePercent;
	
	//default constructors 
	public Individual() {
		entityID = "";
		firstName="";
		lastName="";
		chargePercent=0.0;
	}
	//parameterized constructor 
	public Individual(String inEntityID, String inFirstName, String inLastName) {
		setEntityID(inEntityID);
		setFirstName(inFirstName);
		setLastName(inLastName);
	}
	//copy constructor 
	public Individual(Individual objIndividual){
		entityID = objIndividual.getEntityID();
		firstName = objIndividual.getFirstname();
		lastName = objIndividual.getLastName();
		chargePercent = objIndividual.getChargePercent();
	}

	
	//getters
	public String getEntityID() {
		return entityID;
	}
	public String getFirstname() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public double getChargePercent() {
		return chargePercent;
	}
	
	
	//setters
	public void  setEntityID(String inEntityID) {
		entityID =inEntityID;
	}
	public void setFirstName(String inFirstName) {
		firstName = inFirstName;
	}
	public void setLastName(String inLastName) {
		lastName = inLastName;
	}
	public void setChargePercent(double inChargePercent) {
		chargePercent = inChargePercent;
	}
	
	
	//overload method
	public boolean equals(Individual anotherIndividual) {
		return (entityID.equals(anotherIndividual.getEntityID()));
	}
	
	//override
	public String toString() {
		return upperCamelCase(upperCase(lastName)) + ", " + upperCamelCase(firstName) + " " + "(" +entityID+ ")";
	}
	
	//Turing the first letter of a string to capital letters 
	public static String upperCamelCase(String inStr) {
		
		String newWord = inStr.trim();
		return Character.toUpperCase(inStr.charAt(0))+newWord.substring(1);
	}
	//Turing the first letter of each word in a String to capital letter 
	public static String multiUpperCamelCase(String inStr) {
		
		String newStr ="";
		String[] words = inStr.split(" ");
		for (int i=0; i<words.length; i++) 
			newStr = newStr + upperCamelCase(words[i]);
		return newStr;
	}
	//Turing full string to upper case 
	public static String upperCase(String inStr) {
		return inStr.trim().toUpperCase();
	}
	//creates objects Individual 
	public static Individual[] inStrToIndividualArr(String inStr) {
		String [] eachIndividual = inStr.split(";");
		Individual[] newArr = new Individual[eachIndividual.length];
		for (int i=0;i<eachIndividual.length;i++) {
			String[] eachInd = eachIndividual[i].split(",");
			Individual everyPerson = new Individual(eachInd[0],eachInd[1].trim(), eachInd[2].trim());
			newArr[i] = everyPerson;
			}
			return newArr.clone();
	}
}

