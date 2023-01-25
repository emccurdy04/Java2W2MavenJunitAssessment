/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Jan 24, 2023
*/
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.CustV1BusinessLogic;
import model.CustomerV1;


public class TestCustomerV1 {
	/**
	 * JUnit Test case to test CustomerV1 methods
	 */
	// create an instance of CustV1BusinessLogic & CustomerV1 to
	// be used for testing purposes
	CustV1BusinessLogic customerBL = new CustV1BusinessLogic();
	//public CustomerV1(String firstName, String lastName, int phoneDigits, String streetAddress, String city, String state, int zipDigits, String email)
	CustomerV1 customer = new CustomerV1("Bruce", "Wayne", "5157778899", "254 Gotham Ave.", "Gotham", "IA", "55555", "imbatman@manor.edu");
	//CustomerV1 customer = new CustomerV1("Bruce", "Wayne", 5157778899L, "254 Gotham Ave.", "Gotham", "IA", 55555, "imbatman@manor.edu");
	CustomerV1 customer2 = new CustomerV1("Bruce", "Wayne", "5157778899", "254 Gotham Ave.", "Gotham", "IA", "555558888", "imbatman@manor.edu");

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testPhoneNumFormat() {
		//customer.setPhoneDigits("5157778899");
		String formattedPhone = customer.getPhoneNumFormat();
		assertEquals("(515)777-8899", formattedPhone);
	}

	@Test
	public void testZipFormat() {
		//customer.setZipDigits("55555");
		String formattedZip1 = customer.getZipFormat();
		assertEquals("55555", formattedZip1);
		String formattedZip2 = customer2.getZipFormat();
		assertEquals("55555-8888", formattedZip2);
	}
	
	

}
