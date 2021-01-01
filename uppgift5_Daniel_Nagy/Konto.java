package uppgift5_Daniel_Nagy;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import uppgift4_Daniel_Nagy.Person;

public class Konto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String date;
	private String password;
	private int balance;
	private ArrayList<String> kvittoList = new ArrayList<String>();
	
	public Konto() {
		
	}
	
	public Konto(String userName, String date, String password, int balance, ArrayList<String> kvittoList) {
		this.userName = userName;
		this.date = date;
		this.password = password;
		this.balance = balance;
		this.kvittoList = kvittoList;
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

	public ArrayList<String> getKvittoList() {
		return kvittoList;
	}

	public void setKvittoList(ArrayList<String> kvittoList) {
		this.kvittoList = kvittoList;
	}
}