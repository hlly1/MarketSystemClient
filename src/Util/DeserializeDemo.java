package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Modle.Customer;
import Modle.Product;
import Modle.Supplier;

public class DeserializeDemo {
	public static void main(String [] args)
	   {
	      Customer[] s = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("C:\\eclipse-workspace\\MarketSystemClient\\src\\Util\\tmp\\customer.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         s = (Customer[]) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }

	      System.out.println("Deserialized customer...");
	      for(Customer p1 : s) {
	    	  System.out.println("ID: " + p1.getCreditCardId());
		      System.out.println("Name: " + p1.getCusName());
		      System.out.println("Unit Price: " + p1.getPoint());
		      System.out.println("Money: " + p1.getMoney()); 
	      }

	    }
}
