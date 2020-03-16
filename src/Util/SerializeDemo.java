package Util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import Modle.Customer;
import Modle.Product;
import Modle.SupperReport;
import Modle.User;

public class SerializeDemo
{
   public static void main(String [] args)
   {
//	   Product[] p = {new Product(1,"apple",5.4,100,1,100, "Kg"), 
//				new Product(2, "avocado", 2, 300, 1,300, "One"), new Product(3, "cherry", 4.8, 1000, 2, 1000,"Pack"), new Product(4, "banana", 2.8, 800, 2, 800,"Kg")};
//	   
	   //Supplier[] s = {new Supplier(1,"Leo"), new Supplier(2,"Sam"), new Supplier(3,"Stephen"), new Supplier(4, "Dan")};
	   
//	   Customer[] cus = {new Customer("cus01", "123",3694521, 22, 0), new Customer("cus02","asd123", 3654232, 18, 100000)
//	   };
//	   
//	   User[] allUser = {new User("tim","123456"), new User("kim","12345"), 
//				new User("frank","1234"), new User("cus01","123"), new User("cus02","asd123")};
	  // ArrayList<Cart> cart = new ArrayList<Cart>();
	   //ArrayList<Sale> sale = new ArrayList<Sale>();
	   //ArrayList<BulkSale> bs = new ArrayList<BulkSale>();
	   //ArrayList<PurchaseOrder> po = new ArrayList<PurchaseOrder>();
//	   ArrayList<SupperReport> sr = new ArrayList<SupperReport>();
	   
//      try
//      {
//    	 Date date = new Date();
//         FileOutputStream fileOut = new FileOutputStream("C:\\eclipse-workspace\\MarketSystemClient\\src\\Util\\tmp\\"+ date.toString().replaceAll(" ", "-").replaceAll(":", "-") +".txt");
//    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/customer.txt");
//    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/users.txt");
//    	 
//    	 FileOutputStream fileOut = new FileOutputStream("src/Util/tmp/product.txt");
//    	 ObjectOutputStream out = new ObjectOutputStream(fileOut);
//         out.writeObject(allUser);
//         out.close();
//         fileOut.close();
//         System.out.printf("Successful!");
//      }catch(IOException i)
//      {
//          i.printStackTrace();
//      }
   }
}
