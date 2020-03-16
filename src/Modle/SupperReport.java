package Modle;

import java.io.Serializable;
import java.util.Date;

public class SupperReport  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7286572846720697342L;
	int id;
	String name;
	double qty;
	int supplierID;
	Date date;
	
	public SupperReport(int id, String name, double qty, int supplierID, Date date) {
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.supplierID = supplierID;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
	
	
}
