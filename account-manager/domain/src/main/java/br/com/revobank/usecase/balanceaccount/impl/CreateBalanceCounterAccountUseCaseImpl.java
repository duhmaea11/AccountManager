package br.com.revobank.usecase.balanceaccount.impl;

import br.com.revobank.dataprovider.account.BalanceAccountDataProvider;
import br.com.revobank.usecase.balanceaccount.CreateBalanceAccountUseCase;

import javax.inject.Named;

@Named("createBalanceCounter")
public class CreateBalanceCounterAccountUseCaseImpl implements CreateBalanceAccountUseCase {

    public static final int VALUE = 5000;
    private final BalanceAccountDataProvider _repository;

    public CreateBalanceCounterAccountUseCaseImpl(BalanceAccountDataProvider repository) {
        _repository = repository;
    }

    @Override
    public void createBalanceAccount(long idAccount) {
        _repository.increaseBalanceAccount(idAccount, VALUE);
    }
}
