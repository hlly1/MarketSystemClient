package Modle;

import java.io.Serializable;

public class PurchaseOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6997515045146601463L;
	int id;
	String name;
	double qty;
	int supplierID;
	
	public PurchaseOrder(int id, String name, double qty, int supplierID) {
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.supplierID = supplierID;
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

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	
	
	
	
}
