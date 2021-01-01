package uppgift5_Daniel_Nagy;

import java.io.Serializable;

import javafx.collections.ObservableList;
import uppgift4_Daniel_Nagy.Person;

public class Konto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String date;
	private String password;
	private int balance;
	private ObservableList<String> list;
	
	public Konto() {
		
	}
	
	public Konto(String userName, String date, String password, int balance) {
		this.userName = userName;
		this.date = date;
		this.password = password;
		this.balance = balance;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
}