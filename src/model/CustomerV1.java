/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Jan 23, 2023
*/
package model;

//import java.time.LocalDate;
//import java.util.Date;
import model.CustV1BusinessLogic;


public class CustomerV1 {
	/**
	 * Java 2 Week 2 - Maven & JUnit/Test Driven Development(TDD) Assessment
	 * Customer class version1 - for POJO class example - used to create a
	 * Customer class object to practice coding for business logic type
	 * questions-program functionality. 
	 */
	// instance variables for CustomerV1 class
	private String firstName;
	private String lastName;
	// ? birthday variable to possibly be used in the future 
	// ? will decide later if want to use 'Date' or 'LocalDate' version
	//private Date birthday;
	//private LocalDate birthday;
	//private int phoneDigits;
	//private long phoneDigits;
	private String phoneDigits;
	// ? formatted version of phone number w/ () & -'s
	// ?unsure if want to keep instance variable for this or 
	// just have a method that formats the digits every time it is output?
	private String phoneNumFormat;
	private String streetAddress;
	private String streetAddress2;
	private String city;
	private String state;
	//private int zipDigits;
	private String zipDigits;
	// ? formatted version of zip code w/ -'s if 9 rather then just 5 digit
	// version of zip code
	// ?unsure if want to keep instance variable for this or 
	// just have a method that formats the digits every time it is output?
	private String zipFormat; 
	private String email;
	// ? password, & username variables to possibly be used in the future
	//private String password;
	//private String username;
	
	// comment out discountLvl instance variable for now
	//private String discountLvl;
	//private String discountLevel;
	private int custID;
	// create static variable for class not object of this class
	// to keep track of last assigned cust ID number so each
	// new instance of CustomerV1 class gets a unique ID number
	private static int lastCustIdAssigned = 101;
	
	
//	//Remove default constructor in future since don't want outside source
	// to be able to create a customer object w/o the required inputs
//	/**
//	 * Default no-args constructor
//	 */
//	public CustomerV1() {
//		//super();
//		setStreetAddress("address");
//		setStreetAddress2("address2");
//		setCity("city");
//		//setState("state");
//		this.state = "state";
//		//setZipFormat("zipcode");
//		this.zipFormat = "zipcode";
//		// increment local static variable by one
//		lastCustIdAssigned++;
//		// then set custID to local incremented static variable value
//		this.custID = lastCustIdAssigned;
//	}
//	
	
	/**
	 * Non-default constructor - takes parameters (excluding streetAddress2)
	 * @param firstName
	 * @param lastName
	 * @param phoneDigits
	 * @param streetAddress
	 * @param city
	 * @param zipDigits
	 * @param email
	 */
	public CustomerV1(String firstName, String lastName, String phoneDigits, String streetAddress, String city, String state, String zipDigits, String email) {
	//public CustomerV1(String firstName, String lastName, long phoneDigits, String streetAddress, String city, String state, int zipDigits, String email) {
		//super();
		//this.firstName = firstName;
		//this.lastName = lastName;
		setFirstName(firstName);
		setLastName(lastName);
		//this.phoneDigits = phoneDigits;
		// using setInstanceVariableName(valuePassedWhenConstructorCalled)
		// rather than this.instanceVariableName = valuePassedWhenConstructorCalled
		// since doing validation checks before assigning values
		setPhoneDigits(phoneDigits);
		setPhoneNumFormat();
		//this.phoneNumFormat = phoneNumFormat;
		// pass to setPhoneFormat the validated phoneDigits passed in when 
		// object constructor called - rather than using this.phoneNumFormat
		// to assign
		//setPhoneNumFormat(this.phoneDigits);
		this.streetAddress = streetAddress;
		this.city = city;
		setState(state);
		//this.zipDigits = zipDigits;
		setZipDigits(zipDigits);
		setZipFormat();
		//this.zipFormat = zipFormat;
		// pass to setZipFormat the validated zipDigits passed in 
		// when object constructor called
		//setZipFormat(this.zipDigits);
		this.email = email;
		// removed - String discountLvl - get/set since will be doing later?
		//this.discountLvl = discountLvl;
		//setDiscountLvl();
		// set discountLvl to default value of "bronze"
		//this.discountLvl = "bronze";
		//setDiscountLevel("bronze");
		
		// increment local static variable by one
		lastCustIdAssigned++;
		// then set custID to local incremented static variable value
		this.custID = lastCustIdAssigned;
		// delete the automatically created setCustID() method since it is
		// automatically set when object created and helps with data
		// protection - keep getCustID() method.
		
		// Use 'if statement' to check if any 'null' values exist after instance
		// variables are set w/ values passed in through the constructor - throw
		// an IllegalArgumentException to let user know object not created.
		if ((getFirstName() == null) || (getLastName() == null) || (getState() == null)) { //|| (getPhoneDigits() == null)? add this & one for zip digits?
			throw new IllegalArgumentException("Object not created");
		}
	}
	
	/**
	 * Non-default constructor - takes parameters (including streetAddress2)
	 * @param firstName
	 * @param lastName
	 * @param phoneDigits
	 * @param streetAddress
	 * @param streetAddress2
	 * @param city
	 * @param zipDigits
	 * @param email
	 */
	public CustomerV1(String firstName, String lastName, String phoneDigits, String streetAddress, String streetAddress2, String city, String state, String zipDigits, String email) {
	//public CustomerV1(String firstName, String lastName, long phoneDigits, String streetAddress, String streetAddress2, String city, String state, int zipDigits, String email) {
		//super();
		//this.firstName = firstName;
		//this.lastName = lastName;
		setFirstName(firstName);
		setLastName(lastName);
		this.phoneDigits = phoneDigits;
		setPhoneNumFormat();
		//this.phoneNumFormat = phoneNumFormat;
		// pass to setPhoneFormat the phoneDigits passed in when object constructor 
		// called - rather than using this.phoneNumFormat to assign
		//setPhoneNumFormat(this.phoneDigits);
		this.streetAddress = streetAddress;
		this.streetAddress2 = streetAddress2;
		this.city = city;
		setState(state);
		this.zipDigits = zipDigits;
		setZipFormat();
		//this.zipFormat = zipFormat;
		// pass to setZipFormat the zipDigits passed in when object constructor 
		// called
		//setZipFormat(this.zipDigits);
		this.email = email;
		//this.discountLvl = discountLvl;
		//setDiscountLvl();
		//this.discountLvl = "bronze";
		
		// increment local static variable by one
		lastCustIdAssigned++;
		// then set custID to local incremented static variable value
		this.custID = lastCustIdAssigned;
		// delete the automatically created setCustID() method since it is
		// automatically set when object created and helps with data
		// protection - keep getCustID() method.
		
		// Use 'if statement' to check if any 'null' values exist after instance
		// variables are set w/ values passed in through the constructor - throw
		// an IllegalArgumentException to let user know object not created.
		if ((getFirstName() == null) || (getLastName() == null) || (getState() == null)) {
			throw new IllegalArgumentException("Object not created");
		}
	}


	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		// validation check to verify firstName String is not an empty String
		// before setting the value
		if (firstName.length() > 0) {
			this.firstName = firstName;
		}
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		// validation check to verify lastName String is not an empty String
		// before setting the value
		if (lastName.length() > 0) {
			this.lastName = lastName;
		}
	}


	/**
	 * @return the phoneDigits
	 */
	public String getPhoneDigits() {
	//public long getPhoneDigits() {
		return phoneDigits;
	}


	/**
	 * Method sets the phone digits to passed in int/long, if it is 
	 * 10 digits long, but set to 'null' if not
	 * 
	 * @param phoneDigits the phoneDigits to set
	 */
	public void setPhoneDigits(String phoneDigits) {
	//public void setPhoneDigits(long phoneDigits) {
		// validation check that 10 digits passed in for the
		// phone number. 
		if (phoneDigits.length() == 10) {
		//if (phoneDigits == 10) {
			this.phoneDigits = phoneDigits;
		} //else {
			//this.phoneDigits = null;
		//}
		//this.phoneDigits = phoneDigits;
	}


	/**
	 * @return the phoneNumFormat
	 */
	public String getPhoneNumFormat() {
		return phoneNumFormat;
	}


	/**
	 * @param phoneDigitsInput the phoneNumFormat to set
	 */
	//public void setPhoneNumFormat(this.phoneDigits) {
	public void setPhoneNumFormat() {
	//public void setPhoneNumFormat(String phoneDigitInput) {
	//public void setPhoneNumFormat(long phoneDigitInput) {
		// cast phoneDigitInput to a string
		//String phoneNumDigits = this.phoneDigits;
		String phoneNumDigits = this.getPhoneDigits();
		//String phoneNumDigits = "" + phoneDigitInput;
		//System.out.println(phoneNumDigits);
		//System.out.println(phoneNumDigits.length());
		// initialize an empty string
		String formattedPhoneNum = "";
		formattedPhoneNum += "(" + phoneNumDigits.substring(0,3) + ")" + phoneNumDigits.substring(3, 6) + "-" + phoneNumDigits.substring(6, phoneNumDigits.length());
		//System.out.println(formattedPhoneNum);
		this.phoneNumFormat = formattedPhoneNum;
	}


	/**
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}


	/**
	 * @param streetAddress the streetAddress to set
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	/**
	 * @return the streetAddress2
	 */
	public String getStreetAddress2() {
		return streetAddress2;
	}


	/**
	 * @param streetAddress2 the streetAddress2 to set
	 */
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * setState() method that only accepts 2 characters for the passed in 
	 * state parameter/argument value.  Will set value to null if it is not
	 * 2 characters long.
	 * @param state - String the state is set to if meets validation check
	 * requirement. 
	 */
	public void setState(String state) {
		// validation check that only 2 character String passed in
		// for state
		if (state.length() !=2) {
			this.state = null;
		} else {
			this.state = state;
		}
	}

	/**
	 * @return the zipDigits
	 */
	public String getZipDigits() {
	//public int getZipDigits() {
		return zipDigits;
	}


	/**
	 * Method sets the zip code digits to passed in int, if it is 
	 * between/or equal to 5 to 9 int long, but set to 'null' if 
	 * not in this range. 
	 * @param zipDigits the zipDigits to set
	 */
	public void setZipDigits(String zipDigits) {
	//public void setZipDigits(int zipDigits) {
		// validation check that at least 5 digits passed in for the
		// zip code and no more than 9 digits passed in. 
		if (zipDigits.length() >= 5 && zipDigits.length() <= 9) {
		//if (zipDigits >= 5 && zipDigits <= 9) {
			this.zipDigits = zipDigits;
		} //else {
			//this.zipDigits = null;
		//}
	}


	/**
	 * @return the zipFormat
	 */
	public String getZipFormat() {
		return zipFormat;
	}


	/**
	 * @param zipFormat the zipFormat to set
	 */
	public void setZipFormat() {
	//public void setZipFormat(String zipDigitInput) {
	//public void setZipFormat(int zipDigitInput) {
		// cast zipDigitInput to a string
		String zipNumDigits = this.getZipDigits();
		//String zipNumDigits = this.zipDigits;
		//System.out.println(zipNumDigits);
		//System.out.println(zipNumDigits.length());
		//System.out.println(zipNumDigits.substring(0, 5));
		//System.out.println(zipNumDigits.substring(5, 8));
		//String zipNumDigits = "" + zipDigitInput;
		// initialize an empty string
		String formattedZipCode = "";
		if (zipNumDigits.length() <= 5) {
			formattedZipCode += zipNumDigits.substring(0,5);
		} else if (zipNumDigits.length() == 9) {
			formattedZipCode += zipNumDigits.substring(0,5) + "-" + zipNumDigits.substring(5, zipNumDigits.length());	
		}
		//System.out.println(formattedZipCode);
		this.zipFormat = formattedZipCode;
		//this.zipFormat = zipFormat;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	// comment out get/set methods related to discountLvl for now
//	/**
//	 * @return the discountLvl
//	 */
//	public String getDiscountLvl() {
//		return discountLvl;
//	}

//
//	/**
//	 * Use sub order total to set customer discount level
//	 * ? call to CustV1BusinessLogic class to use method in 
//	 * business logic to determine this?
//	 * @param subTotal - takes double
//	 * ?@param discountLvl the discountLvl to set
//	 */
//	public void setDiscountLvl(double subTotal) {
//	//public void setDiscountLvl(String discountLvl) {
//		String discountLevel;
//		try {
//			discountLevel = CustV1BusinessLogic.customerLvl(subTotal);
//			//discountLevel = customerLvl(subTotal);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		this.discountLvl = discountLevel;
//		//CustomerV1 customer = this.customerV1;
//		//this.discountLvl = customer.customerLvl(subTotal);
//		//this.discountLvl = customerLvl(subTotal);
//		//this.discountLvl = discountLvl;
//	}


	/**
	 * @return the custID
	 */
	public int getCustID() {
		return custID;
	}

	// Deleted setCustID() method since set automatically when object
	// created. 
//	/**
//	 * @param custID the custID to set
//	 */
//	public void setCustID(int custID) {
//		this.custID = custID;
//	}


	/**
	 * @return the lastCustIdAssigned
	 */
	public static int getLastCustIdAssigned() {
		return lastCustIdAssigned;
	}

	// Delete setLastCustIdAssigned() method to prevent outside source
	// from modifying - to help protect data
//	/**
//	 * @param lastCustIdAssigned the lastCustIdAssigned to set
//	 */
//	public static void setLastCustIdAssigned(int lastCustIdAssigned) {
//		CustomerV1.lastCustIdAssigned = lastCustIdAssigned;
//	}


	// In future create helper method to format address output
	
	// In future create helper method to display customer information output
	

	/**
	 * toString() method created to test/display each instance of object
	 * created to help with testing if program working correctly
	 */
	@Override
	public String toString() {
		return "CustomerV1 [firstName=" + firstName + ", lastName=" + lastName + ", phoneDigits=" + phoneDigits
				+ ", phoneNumFormat=" + phoneNumFormat + ", streetAddress=" + streetAddress + ", streetAddress2="
				+ streetAddress2 + ", city=" + city + ", state=" + state + ", zipDigits=" + zipDigits + ", zipFormat="
				+ zipFormat + ", email=" + email + ", custID=" + custID + "]";
	}
	
	

}
