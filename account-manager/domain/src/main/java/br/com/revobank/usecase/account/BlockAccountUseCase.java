package br.com.revobank.usecase.account;

import br.com.revobank.entity.account.Account;

import java.text.ParseException;

public interface BlockAccountUseCase {
    void blockAccount(Account account) throws ParseException;
}
