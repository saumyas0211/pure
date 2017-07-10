package jservices;

import java.math.BigDecimal;

public class ConcurrentTransfers implements Runnable{
	Account fromAct ;
	Account toAct ;
	BigDecimal amountToTransfer = new BigDecimal(10);
	public void run(){
		TransferAmountServiceImp transferAmount = new TransferAmountServiceImp();
		
		transferAmount.transfer(fromAct, toAct, amountToTransfer);
		System.out.println("Executing ConcurrentTransfers");
		System.out.println("Account From"+ fromAct.getAccountId());
		System.out.println("Account From"+ fromAct.getBalance());
		System.out.println("Account To"+ toAct.getAccountId());
		System.out.println("Account To"+ toAct.getBalance());
	  }
	public ConcurrentTransfers (Account fromAct, Account toAct){
		System.out.println("Account From"+ fromAct.getAccountId());
		System.out.println("Account From"+ fromAct.getBalance());
		System.out.println("Account To"+ toAct.getAccountId());
		System.out.println("Account To"+ toAct.getBalance());
		this.fromAct = fromAct;
		this.toAct = toAct;
	}


}
