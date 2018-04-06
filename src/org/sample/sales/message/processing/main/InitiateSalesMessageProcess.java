package org.sample.sales.message.processing.main;

import org.sample.sales.message.processing.SalesProcess;
/*
 * main class for starting Sales Process.
 * @author psikhakolli
 */
public class InitiateSalesMessageProcess {

	public static void main(String[] args) {
		SalesProcess startSales = new SalesProcess();
		startSales.start("sampleInput/input.txt");
	}

}
	