package org.jpmc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jpmc.test.message.Type1;
import org.jpmc.test.message.Type2;
import org.jpmc.test.message.Type3;
/**
 * Stores all sales processed.
 * @author psikhakolli
 *
 */
public class SalesLog {

	private List<Sale> sales;
	
	/**
	 * Intializes SalesLog object
	 */
	public SalesLog()	{
		sales = new ArrayList<>();
	}
	
	/**
	 * add a sale using message for Type1.
	 * @param msg {@link Type1}
	 */
	public void addSale(Type1 msg)	{
		sales.add(new Sale(msg.getProductName(), msg.getPrice(), 1));
	}
	/**
	 * add a sale using message for Type2.
	 * @param msg {@link Type2}
	 */
	public void addSale(Type2 msg)	{
		sales.add(new Sale(msg.getProductName(), msg.getPrice(), msg.getQty()));
	}
	
	/**
	 * adjsut price based Type3 Message
	 * @param msg {@link Type3}
	 */
	public void adjustPrice(Type3 msg)	{
		sales.forEach(sale -> { if( sale.getProductName().equals(msg.getProductName()) ) {
			switch(msg.getOperation())	{
				case ADD :
					sale.setAdjustedPrice(sale.getAdjustedPrice() + msg.getPrice());
					break;
				case SUBSTRACT :
					sale.setAdjustedPrice(sale.getAdjustedPrice() - msg.getPrice());
					break;
				case MULTIPLY :
					sale.setAdjustedPrice(sale.getAdjustedPrice() * msg.getPrice());
					break;
			}
		}
			
		});
		
	}
	/**
	 * prints sales report
	 */
	public void printReport()	{
		HashMap<String,CumulativeSale> salesByProduct = calculateReport();
		 System.out.println("10 sales appended to log");
         System.out.println("*************** Report *****************");
         System.out.println("|ProductName           |Quantity   |Value      |");
        
		
		if(salesByProduct != null && salesByProduct.size() > 0)	{
			salesByProduct.forEach( (k, v) -> { formatReport(k, v);
			});
		}
	}
	
	/**
	 * calculates sales by product for messages processed so far
	 * @return HashMap<String,CumulativeSale>
	 */
	private HashMap<String,CumulativeSale> calculateReport()	{
		HashMap<String,CumulativeSale> salesByProduct = new HashMap<>();
		
		sales.forEach(sale -> { if(salesByProduct.containsKey(sale.getProductName()))	{
					CumulativeSale product = salesByProduct.get(sale.getProductName());
					product.setTotalQty( product.getTotalQty() + sale.getQty());
					product.setTotalValue( product.getTotalValue() + (sale.getQty()* sale.getAdjustedPrice()));
				} else {
					salesByProduct.put(sale.getProductName(),new CumulativeSale(sale.getProductName(), sale.getQty(), sale.getQty() * sale.getAdjustedPrice()));
				}
		});
		return salesByProduct;
	}
	
	/**
	 * Format the report with right padding structure. populates product details on each line.
	 * @param type String
	 * @param product CumulativeSale
	 */
    private void formatReport(String type, CumulativeSale product) {
        String salesByProduct = String.format("|%-18s|%-11d|%-11.2f|", product.getProductName(), product.getTotalQty(), product.getTotalValue());
        System.out.println(salesByProduct);
    }
}
