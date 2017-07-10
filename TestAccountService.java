package jservices;

import java.math.BigDecimal;

public class TestAccountService {
	public static void main (String[] args){
		
		TransferAmountServiceImp transferAmount = new TransferAmountServiceImp();
		BigDecimal balanceInFirst = new BigDecimal(60);
		BigDecimal balanceInSecond = new BigDecimal(40);
		BigDecimal amountToTransfer = new BigDecimal(10);
		Account fromAct = new Account("SP123", balanceInFirst);
		Account toAct = new Account("SP346",balanceInSecond);
     	transferAmount.transfer(fromAct, toAct, amountToTransfer);
		System.out.println("Account First"+ fromAct.getBalance().toPlainString());
		System.out.println("Account Second"+ toAct.getBalance().toPlainString());
		new Thread(new ConcurrentTransfers(fromAct, toAct)).start();
		new Thread(new ConcurrentTransfers(fromAct, toAct)).start();
	}
}
