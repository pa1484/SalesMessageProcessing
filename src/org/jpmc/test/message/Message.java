package org.jpmc.test.message;

public class Message {
	
	 /**
	 * 
	 * Parent object for all types of Message Objects
	 * @author psikhakolli
	 *
	 */
	
	//name of product
	private String productName;
	
	//constructor for building Message object
	protected Message(String productName)	{
		this.productName = productName;
	}
	
	//Returns productName
	public String getProductName()	{
		return productName;
	}
	
}
