package Modle;

import java.io.Serializable;

public class Supplier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3299680128975464316L;
	private int id;
	private String name;
	
	public Supplier(int id, String name) {
		this.id = id;
		this.name = name;

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
}
