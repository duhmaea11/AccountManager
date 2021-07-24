package br.com.revobank.usecase.balanceaccount.impl;

import br.com.revobank.dataprovider.account.BalanceAccountDataProvider;
import br.com.revobank.entity.balanceaccount.Operation;
import br.com.revobank.usecase.balanceaccount.CreateBalanceAccountUseCase;

import javax.inject.Named;

@Named("createBalanceProgrammer")
public class CreateBalanceProgrammerAccountUseCaseImpl implements CreateBalanceAccountUseCase {
    public static final int VALUE = 8000;
    private final BalanceAccountDataProvider _repository;

    public CreateBalanceProgrammerAccountUseCaseImpl(BalanceAccountDataProvider repository) {
        _repository = repository;
    }

    @Override
    public void createBalanceAccount(long idAccount) {
        _repository.increaseBalanceAccount(idAccount, VALUE);
    }
}
