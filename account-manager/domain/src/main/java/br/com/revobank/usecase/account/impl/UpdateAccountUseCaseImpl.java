package br.com.revobank.usecase.account.impl;

import br.com.revobank.dataprovider.account.AccountDataProvider;
import br.com.revobank.entity.account.Account;
import br.com.revobank.usecase.account.UpdateAccountUseCase;

import javax.inject.Named;
import java.text.ParseException;

@Named
public class UpdateAccountUseCaseImpl implements UpdateAccountUseCase {

    private final AccountDataProvider accountDataProvider;

    public UpdateAccountUseCaseImpl(AccountDataProvider accountDataProvider) {
        this.accountDataProvider = accountDataProvider;
    }

    @Override
    public Account updateAccount(Account account) throws ParseException {

        if(account.getId() == 0)
            throw new IllegalArgumentException("Send an ID to update.");

        Account accountBase = accountDataProvider.findById(account.getId()).orElse(null);

        if(accountBase == null)
            throw new IllegalArgumentException("Account not found.");

        accountBase.setName(account.getName());
        accountBase.setBirthDate(account.getBirthDate());
        accountBase.setJobTitle(account.getJobTitle());
        accountBase.setStatus(account.getStatus());
        accountBase.setCreatedAt(account.getCreatedAt());
        accountBase.setUpdatedAt(account.getUpdatedAt());

        return accountDataProvider.save(accountBase);
    }
}
