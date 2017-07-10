package jservices;

import java.math.BigDecimal;

public class Account {
     private String accountId;
     private BigDecimal balance;
	 public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getAccountId() {
		return accountId;
	}
	public Account(String accountId, BigDecimal balance) {
		this.setAccountId(accountId);
		this.setBalance(balance);
       
	}
     
     
}
