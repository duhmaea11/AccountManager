package br.com.revobank.dataprovider.account;

import br.com.revobank.entity.account.Account;

import java.text.ParseException;
import java.util.Optional;

public interface AccountDataProvider {
    Account createAccount(Account account) throws ParseException;
    Account findByDocument(String cpf) throws ParseException;
    Optional<Account> findById(long accountId);
    Account save(Account account) throws ParseException;
}
