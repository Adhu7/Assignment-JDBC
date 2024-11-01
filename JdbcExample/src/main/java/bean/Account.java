package bean;

public class Account {
private int accNo;
private String name;
private float balance;
public Account(int accNo, String name, float balance) {
	super();
	this.accNo = accNo;
	this.name = name;
	this.balance = balance;
}


public int getAccNo() {
	return accNo;
}
public void setAccNo(int accNo) {
	this.accNo = accNo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getBalance() {
	return balance;
}
public void setBalance(float balance) {
	this.balance = balance;
}

}
