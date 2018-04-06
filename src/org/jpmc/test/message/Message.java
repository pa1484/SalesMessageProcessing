package org.jpmc.test.message;

/**
 * 
 * Parent object for all types of Message Objects
 * @author psikhakolli
 *
 */

public class Message {
	
	//name of product
	private String productName;
	
	/**
	 * constructor for creating Message object 
	 * @param productName string
	 */
	protected Message(String productName)	{
		this.productName = productName;
	}
	
	/**
	 * Returns productName 
	 * @return productName
	 */
	public String getProductName()	{
		return productName;
	}
	
}
