package jservices;

import java.math.BigDecimal;

public class TransferAmountServiceImp implements AccountService {
	   private String fromActID;
	   private String toActID;
	   private BigDecimal fromBalance;
	   private BigDecimal toBalance;
       public void transfer(Account fromAct,Account toAct, BigDecimal amountToTransfer){
        	fromActID = fromAct.getAccountId();
        	toActID = toAct.getAccountId();
        	synchronized(fromAct){fromBalance = fromAct.getBalance();}
        	synchronized(toAct){toBalance = toAct.getBalance();}
        	if (fromBalance.compareTo(amountToTransfer) >= 0) 
        	{
        		fromBalance = fromBalance.subtract(amountToTransfer);
        		toBalance = toBalance.add(amountToTransfer);
        	  	}
        	else System.out.println("Transfer is not done. Required Balance not available");
        	synchronized(fromAct){fromAct.setBalance(fromBalance);}
        	synchronized(toAct){toAct.setBalance(toBalance);}      	
        	
      
        }
        
        
        
}
