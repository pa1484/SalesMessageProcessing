package org.sample.sales.message.processing;

import java.io.BufferedReader;
import java.io.FileReader;

import org.sample.sales.message.processing.message.Message;
import org.sample.sales.message.processing.message.Type1;
import org.sample.sales.message.processing.message.Type2;
import org.sample.sales.message.processing.message.Type3;

/**
 * Processing sales messages and stores sales. 
 * @author psikhakolli
 *
 */
public class SalesProcess {

	private static final int MAX_LOG_REPORT_COUNTER = 10;
	private static final int MAX_ADJUSTMENT_REPORT_COUNTER = 50;
	
	private SalesLog sales;
	private MessageLog messages;
	
	/**
	 * constructor for initializing SalesProcess
	 */
	public SalesProcess()	{
		sales = new SalesLog();
		messages = new MessageLog();
	}
	/**
	 * method for start processing sales messages
	 * @param inputFileName String
	 */
	public void start(String inputFileName)	{
		
		System.out.println("Start sales process.....");
		
		// Read inputs from test file
        try {
            String line;
            int msgCounter = 0;
            BufferedReader inputFile = new BufferedReader(new FileReader(inputFileName));
            while((line = inputFile.readLine()) != null) {
            	processMessage(line);
                msgCounter ++;
                //Print report after processing 10 messages
                if(msgCounter % MAX_LOG_REPORT_COUNTER == 0)	{
                	sales.printReport();
                }
                //Prints adjustment report after processing 50 messages and tops accepting new messages
                if(msgCounter % MAX_ADJUSTMENT_REPORT_COUNTER ==0)	{
                	System.out.println("The application has stopped accepting new messages");
                	messages.printAdjustmentMessages();
                	break;
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

		
	}
	/**
	 * process one message and builds appropriate {@link Message} object and adds sales.
	 * @param line String
	 */
	private void processMessage(String line)	{
		Message msg = MessageFactory.buildMessageObject(line);
		messages.addMessage(msg);
		if(msg instanceof Type1)	{
			sales.addSale((Type1)msg);
		} else if(msg instanceof Type2)	{
				sales.addSale((Type2)msg);
		} else if(msg instanceof Type3)	{
			sales.adjustPrice((Type3)msg);
		}
	}

}
