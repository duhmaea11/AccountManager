package br.com.revobank.usecase.balanceaccount.impl;

import br.com.revobank.dataprovider.account.BalanceAccountDataProvider;
import br.com.revobank.usecase.balanceaccount.CreateBalanceAccountUseCase;

import javax.inject.Named;

@Named("createBalanceDirector")
public class CreateBalanceDirectorAccountUseCaseImpl implements CreateBalanceAccountUseCase {
    public static final int VALUE = 20000;
    private final BalanceAccountDataProvider _repository;

    public CreateBalanceDirectorAccountUseCaseImpl(BalanceAccountDataProvider repository) {
        _repository = repository;
    }

    @Override
    public void createBalanceAccount(long idAccount) {
        _repository.increaseBalanceAccount(idAccount, VALUE);
    }
}
