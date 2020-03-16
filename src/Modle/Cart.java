package Modle;

import java.io.Serializable;

public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1174354439406939545L;
	/**
	 * 
	 */
	
	
	private int id;
	private String name;
	private double quantity;
	private double spend;
	
	public Cart(int id, String name, double quantity, double spend) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.spend = spend;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getQuantity() {
		return quantity;
	}


	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getSpend() {
		return spend;
	}

	public void setSpend(double spend) {
		this.spend = spend;
	}


	
	

	
}
