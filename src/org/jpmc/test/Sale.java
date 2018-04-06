package org.jpmc.test;
/**
 * 
 * Object for saving Sale information 
 * @author psikhakolli
 *
 */
public class Sale {
	private String productName;
	private double price;
	private int qty;
	private double adjustedPrice;
	
	//
	/**
	 * constructor for initializing Sale info 
	 * @param productName String
	 * @param price double
	 * @param qty int
	 */
	public Sale(String productName, double price, int qty)	{
		this.productName = productName;
		this.price = price;
		this.qty = qty;
		this.adjustedPrice = price;
	}
	

	/**
	 * 
	 * @return productName String
	 */
	public String getProductName()	{
		return productName;
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
	
	/**
	 * 
	 * @return adjustedPrice
	 */
	public double getAdjustedPrice()	{
		return adjustedPrice;
	}
	
	/**
	 * 
	 * @param adjustedPrice double
	 */
	public void setAdjustedPrice(double adjustedPrice)	{
		this.adjustedPrice = adjustedPrice;
	}
}
