package org.jpmc.test;

/**
 * 
 * Contains information about a total sale value and total quantity for a prodcut. 
 * @author psikhakolli
 *
 */

public class CumulativeSale {
	private String productName;
	private int totalQty;
	private double totalValue;
	/**
	 * Constructor for initializing CumulativeSale info
	 * @param productName String
	 * @param totalQty int
	 * @param totalValue double 
	 */
	public CumulativeSale(String productName, int totalQty, double totalValue)	{
		this.productName = productName;
		this.totalQty = totalQty;
		this.totalValue = totalValue;
	}
	
	/**
	 *@returns productName String 
	 */
	public String getProductName()	{
		return productName;
	}
	
	/**
	 *@returns totalQty int 
	 */
	public int getTotalQty()	{
		return totalQty;
	}
	
	
	/**
	 * sets totalQty
	 *@param totalQty int 
	 */
	public void setTotalQty(int totalQty)	{
		this.totalQty = totalQty;
	}
	
	/**
	 *@returns totalValue double 
	 */
	public double getTotalValue()	{
		return totalValue;
	}
	
	/**
	 * sets totalValue
	 *@param totalValue double 
	 */
	public void setTotalValue(double totalValue)	{
		this.totalValue = totalValue;
	}

}
