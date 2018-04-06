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
	
	//constructor for initializing Type3 Message object
	public Type3(String productName, double price, Operation operation)	{
		super(productName);
		this.price = price;
		this.operation = operation;
	}
	
	//returns price
	public double getPrice()	{
		return price;
	}
	
	//returns operation
	public Operation getOperation()	{
		return operation;
	}
	
}
