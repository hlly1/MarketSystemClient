package Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Modle.BulkSale;
import Modle.Cart;
import Modle.Customer;
import Modle.Product;
import Modle.PurchaseOrder;
import Modle.Sale;
import Modle.SupperReport;
import Modle.Supplier;

public class DataWriteUtil {
	
	public void productWrite(Product[] p) {
	      try
	      {
	         FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/product.txt");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(p);
	         out.close();
	         fileOut.close();
	         //System.out.printf("Serialized data is saved in product.txt");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public void supplierWrite(Supplier[] s) {
		 try
	      {
	    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/supplier.txt");
	    	 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(s);
	         out.close();
	         fileOut.close();
	         //System.out.printf("Successful!");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public void cartSave(ArrayList<Cart> c) {
		 try
	      {
	    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/cart.txt");
	    	 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(c);
	         out.close();
	         fileOut.close();
	        // System.out.printf("Cart Saved!");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public void customerSave(Customer[] cus) {
		try
	      {
	    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/customer.txt");
	    	 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(cus);
	         out.close();
	         fileOut.close();
	        // System.out.printf("Customer Saved!");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
	}
	
	public void saleReportSave(ArrayList<Sale> sale) {
		try
	      {
	    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/saleReport.txt");
	    	 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(sale);
	         out.close();
	         fileOut.close();
	        // System.out.printf("Customer Saved!");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
		
		
	}
	
	public void bulkSaleSave(ArrayList<BulkSale> bs) {	
		try
	      {
	    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/BulkSale.txt");
	    	 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(bs);
	         out.close();
	         fileOut.close();
	        // System.out.printf("BulkSale Saved!");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
			
	}
	
	public void purchaseOrderSave(ArrayList<PurchaseOrder> po) {	
		try
	      {
	    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/PurchaseOrder.txt");
	    	 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(po);
	         out.close();
	         fileOut.close();
	        // System.out.printf("BulkSale Saved!");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
			
	}
	
	public void supperReportSave(ArrayList<SupperReport> sr) {	
		try
	      {
	    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/SupperReport.txt");
	    	 ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(sr);
	         out.close();
	         fileOut.close();
	        // System.out.printf("BulkSale Saved!");
	      }catch(IOException i)
	      {
	          i.printStackTrace();
	      }
			
	}
}
