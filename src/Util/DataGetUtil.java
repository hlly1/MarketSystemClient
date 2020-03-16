package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Modle.BulkSale;
import Modle.Cart;
import Modle.Customer;
import Modle.Product;
import Modle.PurchaseOrder;
import Modle.Sale;
import Modle.SupperReport;
import Modle.Supplier;
import Modle.User;

public class DataGetUtil {
	
//	User[] allUser = {new User("tim","123456"), new User("kim","12345"), 
//		new User("frank","1234"), new User("cus01","123"), new User("cus02","asd123")};
//	
//	Product[] allProduct = {new Product(1,"apple",5.4,100,1,100,"Kg"), 
//			new Product(2, "avocado", 2, 300, 1,300,"One"), new Product(3, "cherry", 4.8, 1000, 2, 1000,"Pack"), new Product(4, "banana", 2.8, 800, 2, 800,"Kg")};
//	
//	Supplier[] allSupplier = {new Supplier(1,"Leo"), new Supplier(2,"Sam"), new Supplier(3,"Stephen"), new Supplier(4, "Dan")};
	
	public User[] dbUserGet(){
	      User[] allUser = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("src/Util/tmp/users.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         allUser = (User[]) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("User class not found");
	         c.printStackTrace();
	         
	      }
	      
		return allUser;
	}
	
	public Product[] dbProductGet(){
	      Product[] p = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("src/Util/tmp/product.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         p = (Product[]) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Product class not found");
	         c.printStackTrace();
	         
	      }
	      return p;
	}
	
	public Supplier[] dbSupplierGet() {
		
		Supplier[] s = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("src/Util/tmp/supplier.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         s = (Supplier[]) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Supplier class not found");
	         c.printStackTrace();
	         
	      }

	      return s;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cart> cartGet() {
		ArrayList<Cart> c = null;
		 try
	      {
	         FileInputStream fileIn = new FileInputStream("src/Util/tmp/cart.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         c = (ArrayList<Cart>) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         
	      }catch(ClassNotFoundException e)
	      {
	         System.out.println("Cart class not found");
	         e.printStackTrace();
	         
	      }
	      return c;	
	}
	
	public Customer[] customerGet() {
		Customer[] cus = null;
		 try
	      {
	         FileInputStream fileIn = new FileInputStream("src/Util/tmp/customer.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         cus = (Customer[]) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         
	      }catch(ClassNotFoundException e)
	      {
	         System.out.println("customer class not found");
	         e.printStackTrace();
	      }
		return cus;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Sale> saleReportGet() {
		ArrayList<Sale> sale = null;
		try
	      {
	         FileInputStream fileIn = new FileInputStream("src/Util/tmp/saleReport.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         sale = (ArrayList<Sale>) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         
	      }catch(ClassNotFoundException e)
	      {
	         System.out.println("Sale class not found");
	         e.printStackTrace();
	         
	      }
		
		return sale;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<BulkSale> bulkSaleGet(){
		ArrayList<BulkSale> bs = null;
		try
	      {
	         FileInputStream fileIn = new FileInputStream("src/Util/tmp/BulkSale.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         bs = (ArrayList<BulkSale>) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         
	      }catch(ClassNotFoundException e)
	      {
	         System.out.println("Sale class not found");
	         e.printStackTrace();
	         
	      }
		
		
		return bs;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<PurchaseOrder> purchaseOrderGet(){
		ArrayList<PurchaseOrder> po = null;
		try
	      {
	         FileInputStream fileIn = new FileInputStream("src/Util/tmp/PurchaseOrder.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         po = (ArrayList<PurchaseOrder>) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         
	      }catch(ClassNotFoundException e)
	      {
	         System.out.println("Sale class not found");
	         e.printStackTrace();
	         
	      }
		
		
		return po;
		
	}
	@SuppressWarnings("unchecked")
	public ArrayList<SupperReport> supperReportGet(){
		ArrayList<SupperReport> sr =  null;
		try
	      {
	         FileInputStream fileIn = new FileInputStream("src/Util/tmp/SupperReport.txt");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         sr = (ArrayList<SupperReport>) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         
	      }catch(ClassNotFoundException e)
	      {
	         System.out.println("Sale class not found");
	         e.printStackTrace();
	         
	      }
		
		
		return sr;
		
	}
	
	
			
}
