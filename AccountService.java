package jservices;

import java.math.BigDecimal;

public interface AccountService {
       public void transfer(Account fromAct, Account toAct, BigDecimal amtToTransfer);
}
