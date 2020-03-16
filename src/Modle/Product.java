package Modle;

import java.io.Serializable;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8514353850638303652L;
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double unitPrice;
	private double quantity;
	private double stockLv;
	private double replenLv;
	private int supplierId;
	private double fullQuan;
	private String unit;
	
	public Product(int id, String name, double unitPrice, double quantity, int supplierId, double fullQuan, String unit){
		
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.supplierId = supplierId;
		this.fullQuan = fullQuan;
		this.unit = unit;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
		getReplenLv();
	}
	
	public double getStockLv() {
		setStockLv();
		return stockLv;
	}
	
	public void setStockLv() {	
		this.stockLv =Math.round((this.quantity/this.fullQuan) * 100.0)/100.0;
	}
	
	public double getReplenLv() {
		setReplenLv();
		return replenLv;
	}
	
	public void setReplenLv() {
		getStockLv();
		this.replenLv =Math.round((1 - this.stockLv) * 100.0)/100.0;
	}
	
	public int getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	public double addQuantity(double add) {
		this.quantity = this.quantity + add;
		return this.quantity;
	}

	public double totalSpend(double q) {
		double total = q * this.unitPrice;
		return Math.round(total * 100.0)/100.0;
	}
	
	public double decreaseQuantity(double quantityBuy) {
		this.quantity = this.quantity - quantityBuy;
		return this.quantity;
	}
	
	public double getFullStock() {
		return this.fullQuan;
	}
	
	
}
