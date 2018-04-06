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
	
	//constructor for initializing Sale info
	public Sale(String productName, double price, int qty)	{
		this.productName = productName;
		this.price = price;
		this.qty = qty;
		this.adjustedPrice = price;
	}
	
	//returns productName
	public String getProductName()	{
		return productName;
	}
	
	//returns price
	public double getPrice()	{
		return price;
	}
	//returns qty
	public int getQty()	{
		return qty;
	}
	
	//returns adjustedPrice
	public double getAdjustedPrice()	{
		return adjustedPrice;
	}
	
	//sets adjustedPrice
	public void setAdjustedPrice(double adjustedPrice)	{
		this.adjustedPrice = adjustedPrice;
	}
}
