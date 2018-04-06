package org.sample.sales.message.processing;

/**
 * 
 * MessageLog for storing all messages recieved.
 * @author psikhakolli
 *
 */


import java.util.ArrayList;

import org.sample.sales.message.processing.message.Message;
import org.sample.sales.message.processing.message.Type3;

public class MessageLog {
	
	//List object for storing messages recieved
	private ArrayList<Message> msgs;
	
	/**
	 * constructor for initializing MessageLog object
	 */
	public MessageLog()	{
		msgs = new ArrayList<>();
	}
	/**
	 * add message to List of Messages
	 * @param msg {@link Message}
	 */
	public void addMessage(Message msg)	{
		msgs.add(msg);
	}
	/**
	 * print Type3 messages to console
	 */
	public void printAdjustmentMessages()	{
		msgs.forEach( msg -> {
			if(msg instanceof Type3)	{
				Type3 type3Msg = (Type3) msg;
				System.out.println("Applied " + type3Msg.getOperation() + " " + formatMessage(type3Msg.getPrice(), type3Msg.getOperation()) + " on " + type3Msg.getProductName());
			}
		});
		
	}
	/**
	 * formats price based on operation
	 * @param price [double]
	 * @param operation {@link Operation}
	 * @return formmated String String
	 */
	private String formatMessage(double price, Operation operation)	{
		switch(operation)	{
			case MULTIPLY :
				return String.format("%2.0f", price);
			default:
				return String.format("%2.0fP", price * 100);
		}
	}

}
