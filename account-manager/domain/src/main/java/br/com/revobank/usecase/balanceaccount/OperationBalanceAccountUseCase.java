package br.com.revobank.usecase.balanceaccount;

import br.com.revobank.entity.account.Account;
import br.com.revobank.entity.balanceaccount.BalanceAccount;

import java.text.ParseException;

public interface OperationBalanceAccountUseCase {
    void decrease(Account account, double value) throws ParseException;
    void increase(Account account, double value);
}
