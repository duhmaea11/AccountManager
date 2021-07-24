package br.com.revobank.usecase.account.impl;

import br.com.revobank.dataprovider.account.AccountDataProvider;
import br.com.revobank.entity.account.Account;
import br.com.revobank.usecase.account.GetAccountUseCase;

import javax.inject.Named;

@Named
public class GetAccountUseCaseImpl implements GetAccountUseCase {

    private final AccountDataProvider _dataProvider;

    public GetAccountUseCaseImpl(AccountDataProvider dataProvider) {
        _dataProvider = dataProvider;
    }

    @Override
    public Account getAccountById(long accountId) {
        return _dataProvider.findById(accountId).orElse(null);
    }
}
