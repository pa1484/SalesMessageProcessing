package org.jpmc.test.main;

import org.jpmc.test.SalesProcess;
/*
 * main class for starting Sales Process.
 * @author psikhakolli
 */
public class InitiateSalesMessageProcess {

	public static void main(String[] args) {
		SalesProcess startSales = new SalesProcess();
		startSales.start("testInput/input.txt");
	}

}
	