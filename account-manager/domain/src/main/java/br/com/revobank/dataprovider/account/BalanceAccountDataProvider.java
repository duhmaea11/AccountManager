package br.com.revobank.dataprovider.account;

import br.com.revobank.entity.balanceaccount.BalanceAccount;
import br.com.revobank.entity.balanceaccount.OperationAccount;
import br.com.revobank.entity.balanceaccount.Operation;

import java.util.List;

public interface BalanceAccountDataProvider {
    OperationAccount decreaseBalanceAccount(long idAccount, double value);

    OperationAccount increaseBalanceAccount(long idAccount, double value);

    List<OperationAccount> getBalances(long idAccount);
}
