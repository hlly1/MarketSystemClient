package Modle;

import java.io.Serializable;

public class BulkSale implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2657221620041473064L;
	int id;
	String name;
	double bulk;
	double discount;
	
	public BulkSale(int id, String name, double bulk, double discount) {
		this.id = id;
		this.name = name;
		this.bulk = bulk;
		this.discount = discount;

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

	public double getBulk() {
		return bulk;
	}

	public void setBulk(double bulk) {
		this.bulk = bulk;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	


	
	
	
	
	
	
}
