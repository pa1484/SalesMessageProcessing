package org.jpmc.test.message;


/**
 * 
 * child object for Type2 Message i.e,  E.g 20 sales of apples at 10p each 
 * @author psikhakolli
 *
 */
public class Type2 extends Message{
	
	private double price;
	private int qty;

	/**
	 * constructor for initializing Type2 Message object 
	 * @param productName String
	 * @param price double
	 * @param qty int
	 */
	public Type2(String productName, double price, int qty)	{
		super(productName);
		this.price = price;
		this.qty = qty;
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
	 * @return qty int
	 */
	public int getQty()	{
		return qty;
	}

}
