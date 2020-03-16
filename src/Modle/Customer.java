package Modle;

import java.io.Serializable;

public class Customer extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3223457160106734625L;
	private String cusName;
	private int creditCardId;
	private int point;
	private double money;

	public Customer(String cusName, String passwd, int creditCardId, int point, double money) {
		super(cusName, passwd);
		this.cusName = cusName;
		this.creditCardId = creditCardId;
		this.point = point;
		this.money = money;
	}
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public int getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(int creditCardId) {
		this.creditCardId = creditCardId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public void addPoint(int add) {
		this.point = this.point + add;
	}
}
