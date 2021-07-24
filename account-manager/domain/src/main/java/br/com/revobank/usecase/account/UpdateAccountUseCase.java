package br.com.revobank.usecase.account;

import br.com.revobank.entity.account.Account;

import java.text.ParseException;

public interface UpdateAccountUseCase {
    Account updateAccount(Account account) throws ParseException;
}
