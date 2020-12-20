package uppgift5_Daniel_Nagy;

class Konto {
	private String userName;
	private String date;
	private String password;
	private int balance;

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

	@Override
	public String toString() {
		return "Konto [userName=" + userName + ", date=" + date + ", password=" + password + ", balance=" + balance
				+ "]";
	}
	
}