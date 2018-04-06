package org.jpmc.test.message;

/**
 * 
 * child object for Type3 Message i.e,  E.g Add 5p pineapples 
 * @author psikhakolli
 *
 */

import org.jpmc.test.Operation;

public class Type3 extends Message{
	
	private double price;
	private Operation operation;
	
	/**
	 * constructor for initializing Type3 Message object 
	 * @param productName String
	 * @param price price
	 * @param operation {@link Operation}
	 */
	public Type3(String productName, double price, Operation operation)	{
		super(productName);
		this.price = price;
		this.operation = operation;
	}
	
	/**
	 * 
	 * @return price double
	 */
	public double getPrice()	{
		return price;
	}
	
	/**
	 * 
	 * @return operation {@link Operation}
	 */
	public Operation getOperation()	{
		return operation;
	}
	
}
