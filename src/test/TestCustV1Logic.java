/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Jan 23, 2023
*/
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.CustV1BusinessLogic;
import model.CustomerV1;


public class TestCustV1Logic {
	/**
	 * JUnit Test case to test CustV1BusinessLogic methods"
	 */
	// create an instance of CustV1BusinessLogic & CustomerV1 to
	// be used for testing purposes
	CustV1BusinessLogic customerBL = new CustV1BusinessLogic();
	//public CustomerV1(String firstName, String lastName, int phoneDigits, String streetAddress, String city, String state, int zipDigits, String email)
	CustomerV1 customer = new CustomerV1("Bruce", "Wayne", "5157778899", "254 Gotham Ave.", "Gotham", "IA", "55555", "imbatman@manor.edu");
	//CustomerV1 customer = new CustomerV1("Bruce", "Wayne", 5157778899L, "254 Gotham Ave.", "Gotham", "IA", 55555, "imbatman@manor.edu");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCalcStateTax() {
		//customer.setState("IA");
		double stateTax = customerBL.calcStateTax(customer);
		assertEquals(0.05, stateTax, 0.01);
	}

	@Test
	public void testCalcShipCost() {
		//customer.setState("IA");
		double shipCost = customerBL.calcShipCost(customer);
		assertEquals(2.99, shipCost, 0.01);
	}
}
