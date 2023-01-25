/**
* @author Elizabeth McCurdy - emccurdy
* CIS 175 - Spring 2023
* Jan 23, 2023
*/
package model;

import model.CustomerV1;



public class CustV1BusinessLogic {
	/**
	 * CustV1BusinessLogic class used to contain the business logic
	 * to be used with the CustomerV1 class
	 */
	
	/**
	 * Method to assign state sales tax to a customer's order based on
	 * their shipping address. Use 5% sales tax first for IA - later
	 * create if/else if to assign values for all states - if more than
	 * one state has same sales tax, then use a if in list of those states
	 * condition to assign stateTax value
	 * @return stateTax - double
	 */
	public double calcStateTax(CustomerV1 customer) {
		double stateTax = 0.0;
		if (customer.getState() == "IA") {
			stateTax = 0.05;
		}
		return stateTax;
	}
	
	/**
	 * Method to assign cost of shipping a customer's order based on
	 * their shipping address. Use 0 S&H cost first - then use
	 * if/else if to assign different S&H cost depending on if
	 * in continental US (2.99) or not in continental US Alaska (AK), Hawaii (HI),
	 * Puerto Rico (PR) - (5.99). 
	 * Later consider adding outside of US category - (19.50). 
	 * @return shipCost - double
	 */
	public double calcShipCost(CustomerV1 customer) {
		double shipCost = 0.0;
		// in future do a if in list of continental states
		if (customer.getState() == "IA") {
			shipCost = 2.99;
		}
		return shipCost;
		//return 0.0;
	}
	
	// Comment out below methods for now
//	/**
//	 * Method assigns discount level to customer depending on their
//	 * order subtotal.
//	 * @return level - string with customer's discount level
//	 */
//	//public String customerLvl(CustomerV1 customer, double orderSubTotal) {
//	public String customerLvl(double orderSubTotal) {
//		// assign default value to level
//		String level = "bronze";
//		//String level = this.getDiscountlvl();
//		if (orderSubTotal >= 100) {
//			level = "platinum";
//		} else if (orderSubTotal >= 75) {
//			level = "gold";
//		} else if (orderSubTotal >= 50) {
//			level = "silver";
//		}
//		return level;
//	}
//	
//	/**
//	 * Method calculates discounted price using the customer discount level
//	 * and order sub total. Platinum 30% off, gold 20% off, silver 10% off,
//	 * bronze 0% off. 
//	 * @return discountPrice - double
//	 */
//	public double calcDiscountPrice(double orderSubTotal, String level) {
//		double discountPrice = orderSubTotal * 1.0;
//		return discountPrice;
//	}
//	
//	/**
//	 * Method calculates order total based on the calculated discount price,
//	 * state tax, & shipping cost.
//	 * @return orderTotal - double
//	 */
//	public double calcOrderTotal(double discountPrice, double stateTax, double shipCost) {
//		double orderTotal = (discountPrice * stateTax) + shipCost;
//		return orderTotal;
//	}

}
