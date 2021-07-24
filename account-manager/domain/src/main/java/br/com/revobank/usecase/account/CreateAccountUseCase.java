package br.com.revobank.usecase.account;

import br.com.revobank.entity.account.Account;

import javax.inject.Named;
import java.text.ParseException;

@Named
public interface CreateAccountUseCase {
    Account createAccount(Account account) throws ParseException;
}
