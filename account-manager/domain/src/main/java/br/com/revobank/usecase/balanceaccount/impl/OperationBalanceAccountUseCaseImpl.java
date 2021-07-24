package br.com.revobank.usecase.balanceaccount.impl;

import br.com.revobank.dataprovider.account.BalanceAccountDataProvider;
import br.com.revobank.entity.account.Account;
import br.com.revobank.entity.account.JobTitle;
import br.com.revobank.entity.balanceaccount.BalanceAccount;
import br.com.revobank.entity.balanceaccount.Operation;
import br.com.revobank.usecase.account.BlockAccountUseCase;
import br.com.revobank.usecase.balanceaccount.GetBalanceAccountUseCase;
import br.com.revobank.usecase.balanceaccount.OperationBalanceAccountUseCase;

import javax.inject.Named;
import java.text.ParseException;

@Named
public class OperationBalanceAccountUseCaseImpl implements OperationBalanceAccountUseCase {
    private final BalanceAccountDataProvider _repository;
    private final GetBalanceAccountUseCase balanceAccountUseCase;
    private final BlockAccountUseCase blockAccountUseCase;

    public OperationBalanceAccountUseCaseImpl(BalanceAccountDataProvider repository, GetBalanceAccountUseCase balanceAccountUseCase, BlockAccountUseCase blockAccountUseCase) {
        _repository = repository;
        this.balanceAccountUseCase = balanceAccountUseCase;
        this.blockAccountUseCase = blockAccountUseCase;
    }

    @Override
    public void decrease(Account account, double value) throws ParseException {
        if(account.getStatus().equals("BLOCKED"))
            throw new IllegalArgumentException("Account is blocked.");

        BalanceAccount balance = balanceAccountUseCase.getBalanceAccount(account);

        if(balance.getBalance() < value && !account.getJobTitle().equals(JobTitle.DIRECTOR))
            blockAccountUseCase.blockAccount(account);
        else
            _repository.decreaseBalanceAccount(account.getId(), value);
    }

    @Override
    public void increase(Account account, double value) {
        _repository.increaseBalanceAccount(account.getId(), value);
    }
}
