package br.com.revobank.usecase.balanceaccount;

import br.com.revobank.entity.account.Account;
import br.com.revobank.entity.balanceaccount.BalanceAccount;

public interface GetBalanceAccountUseCase {
    BalanceAccount getBalanceAccount(Account account);
}
