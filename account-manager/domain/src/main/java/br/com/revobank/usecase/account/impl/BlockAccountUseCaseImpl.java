package br.com.revobank.usecase.account.impl;

import br.com.revobank.dataprovider.account.AccountDataProvider;
import br.com.revobank.entity.account.Account;
import br.com.revobank.usecase.account.BlockAccountUseCase;

import javax.inject.Named;
import java.text.ParseException;

@Named
public class BlockAccountUseCaseImpl implements BlockAccountUseCase {
    private final AccountDataProvider accountDataProvider;

    public BlockAccountUseCaseImpl(AccountDataProvider accountDataProvider) {
        this.accountDataProvider = accountDataProvider;
    }

    @Override
    public void blockAccount(Account account) throws ParseException {
        account.setStatus("BLOCKED");

        accountDataProvider.save(account);
    }
}
