package org.sample.sales.message.processing;

import org.sample.sales.message.processing.message.Message;
import org.sample.sales.message.processing.message.Type1;
import org.sample.sales.message.processing.message.Type2;
import org.sample.sales.message.processing.message.Type3;

 
/**
 * 
 * MessageFactory for parsing and building appropriate Message Class child object
 * @author psikhakolli
 *
 */
 
public class MessageFactory {
	
	/**
	 * avoiding creating instance as there is no need
	 */
	private MessageFactory()	{
		
	}
	
	/**
	 * Returns appropriate Message object based on the message
	 * 
	 * @param message
	 * @return {@link Message}
	 *
	 */
	public static Message buildMessageObject(String message)	{
		
		if (message == null || message.isEmpty()) {
            return null;
        }
		
		String[] messageArray = message.trim().split("\\s+");
        String firstWord = messageArray[0];
        //if the first word matches to Add/Subtract/Multiply try to build Type3 message object.
        if (firstWord.matches("Add|Subtract|Multiply")) {
            return buildMessageObjectType3(messageArray);
        //if the first word matches to numbers then try to build Type2 message object.     
        } else if (firstWord.matches("^\\d+")) {
        	return buildMessageObjectType2(messageArray);
    	//if message contains 3 words try to build Type1 message object.
        } else if (messageArray.length == 3 && messageArray[1].contains("at")) {
            return buildMessageObjectType1(messageArray);
        } else {
            System.out.println("Wrong sales notice");
        }
		
		return null;
	}
	
	/**
	 * Returns appropriate Type1 message object.
	 * 
	 * @param messageArray
	 * @return {@link Type1}
	 *
	 */
	
	private static Type1 buildMessageObjectType1(String[] messageArray)	{
		//check to make sure there are only 3 words.  
		if(messageArray.length != 3) return null;
        return new Type1(parseName(messageArray[0]), parsePrice(messageArray[2]));
	}
	
	/**
	 * Returns appropriate Type2 message object.
	 * 
	 * @param messageArray
	 * @return {@link Type2}
	 *
	 */
	private static Type2 buildMessageObjectType2(String[] messageArray)	{
		//check to make sure there are only 7 words.
		if(messageArray.length != 7) return null;
		 
		return new Type2(parseName(messageArray[3]), parsePrice(messageArray[5]),parseQuantity(messageArray[0]));
	}
	
	/**
	 * Returns appropriate Type3 message object.
	 * 
	 * @param messageArray
	 * @return {@link Type3}
	 *
	 */
	private static Type3 buildMessageObjectType3(String[] messageArray)	{
		//create object based on the operation.
		switch (messageArray[0])	{
			case "Add":	
				return new Type3( parseName(messageArray[2]), parsePrice(messageArray[1]), Operation.ADD);
			case "Subtract":	
				return new Type3( parseName(messageArray[2]), parsePrice(messageArray[1]), Operation.SUBSTRACT);
			case "Multiply" :
				return new Type3( parseName(messageArray[2]), parseFactor(messageArray[1]), Operation.MULTIPLY);
				
		}
		return null;
	}
	
	
	private static String parseName(String productName) {
		return productName;
	}
	
	/**
	 * convert string value to price format
	 * 
	 * @param rawPrice
	 * @return [double] converts 20P to 0.2
	 *
	 */
	private static double parsePrice(String rawPrice) {
		//replace £ or p in the string to empty string.
        double price = Double.parseDouble(rawPrice.replaceAll("£|p", ""));
        //check if there is period in the rawPrice.
        if (!rawPrice.contains(".")) {
            price = Double.valueOf(Double.valueOf(price) / Double.valueOf("100"));
        }
        return price;
    }
	
	/**
	 * convert string value to quantity
	 * 
	 * @param qty
	 * @return [int]
	 *
	 */
	private static int parseQuantity(String qty) {
		return Integer.parseInt(qty);
	}
	/**
	 * convert string value to factor
	 * It is used when operation is multiply
	 * @param factor
	 * @return [double]
	 *
	 */
	private static double parseFactor(String factor)	{
		return Double.parseDouble(factor);
	}

}
