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
	//constructor for initializing Type2 Message object
	public Type2(String productName, double price, int qty)	{
		super(productName);
		this.price = price;
		this.qty = qty;
	}
	
	//returns price
	public double getPrice()	{
		return price;
	}
	
	//returns qty
	public int getQty()	{
		return qty;
	}

}
