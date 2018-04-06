package org.jpmc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jpmc.test.message.Type1;
import org.jpmc.test.message.Type2;
import org.jpmc.test.message.Type3;

public class SalesLog {

	private List<Sale> sales;
	
	public SalesLog()	{
		sales = new ArrayList<>();
	}
	
	public void addSale(Type1 msg)	{
		sales.add(new Sale(msg.getProductName(), msg.getPrice(), 1));
	}
	
	public void addSale(Type2 msg)	{
		sales.add(new Sale(msg.getProductName(), msg.getPrice(), msg.getQty()));
	}
	
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
	
	// Format the report with right padding structure. populates product details on each line.
    private void formatReport(String type, CumulativeSale product) {
        String salesByProduct = String.format("|%-18s|%-11d|%-11.2f|", product.getProductName(), product.getTotalQty(), product.getTotalValue());
        System.out.println(salesByProduct);
    }
	
	
}
