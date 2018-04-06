package org.jpmc.test.message;


/**
 * 
 * child object for Type1 Message i.e, E.g apple at 10p 
 * @author psikhakolli
 *
 */
public class Type1 extends Message	{
	
	private double price;
	/**
	 * constructor for initializing Type1 Message object 
	 * @param productName String
	 * @param price double
	 */
	public Type1(String productName, double price)	{
		super(productName);
		this.price = price;
	}
	
	/**
	 * 
	 * @return price double
	 */
	public double getPrice()	{
		return price;
	}
	

}
