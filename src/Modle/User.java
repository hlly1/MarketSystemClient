package Modle;

import java.io.Serializable;

public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 551215312836291434L;
	private int id;
	private String userName;
	private String passwd;
	

	public User(String userName, String passwd) {
		this.userName = userName;
		this.passwd = passwd;
	}

//	public User() {
//		// TODO Auto-generated constructor stub
//		
//	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	
}
