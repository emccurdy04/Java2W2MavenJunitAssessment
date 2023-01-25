/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Jan 24, 2023
*/
package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import model.CustomerV1;

public class TestRunner {

	public static void main(String[] args) {
		/**
		 * Class to execute test cases
		 */
		//CustomerV1 customer = new CustomerV1("Bruce", "Wayne", "5157778899", "254 Gotham Ave.", "Gotham", "IA", "55555", "imbatman@manor.edu");
		//CustomerV1 customer = new CustomerV1("Bruce", "Wayne", 5157778899L, "254 Gotham Ave.", "Gotham", "IA", 55555, "imbatman@manor.edu");
		//System.out.println(customer.toString());
		
		Result result = JUnitCore.runClasses(AllTests.class);
		
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		
		System.out.println(result.wasSuccessful());

	}

}
