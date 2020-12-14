package uppgift5_Daniel_Nagy;

class Konto {

	private String owner;
	private int acc;
	private int balance;
	private int money;
	
	public Konto(String owner, int acc, int balance, int money) {
		super();
		this.owner = owner;
		this.acc = acc;
		this.balance = balance;
		this.money = money;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getAcc() {
		return acc;
	}

	public void setAcc(int acc) {
		this.acc = acc;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Konto [owner=" + owner + ", acc=" + acc + ", balance=" + balance + ", money=" + money + "]";
	}
}
