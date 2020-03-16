package Modle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Sale implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3806242817956596386L;
	int id;
	private ArrayList<Cart> items;
	double totalSpend;
	double discSpend;
	String cust;
	Date date;
	
	public Sale(int id, ArrayList<Cart> items, double totalSpend, double discSpend, String cust, Date date) {
		this.id = id;
		this.items = items;
		this.totalSpend = totalSpend;
		this.discSpend = discSpend;
		this.cust = cust;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public ArrayList<Cart> getItems() {
		return items;
	}

	public void setItems(ArrayList<Cart> items) {
		this.items = items;
	}

	public double getTotalSpend() {
		return totalSpend;
	}

	public void setTotalSpend(double totalSpend) {
		this.totalSpend = totalSpend;
	}

	public double getDiscSpend() {
		return discSpend;
	}

	public void setDiscSpend(double discSpend) {
		this.discSpend = discSpend;
	}

	public String getCust() {
		return cust;
	}

	public void setCust(String cust) {
		this.cust = cust;
	}
	
	
	
	
}
