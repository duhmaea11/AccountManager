package br.com.revobank.usecase.balanceaccount.impl;

import br.com.revobank.dataprovider.account.BalanceAccountDataProvider;
import br.com.revobank.entity.account.Account;
import br.com.revobank.entity.balanceaccount.BalanceAccount;
import br.com.revobank.entity.balanceaccount.Operation;
import br.com.revobank.entity.balanceaccount.OperationAccount;
import br.com.revobank.usecase.balanceaccount.GetBalanceAccountUseCase;

import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Named
public class GetBalanceAccountUseCaseImpl implements GetBalanceAccountUseCase {

    private final BalanceAccountDataProvider _repository;

    public GetBalanceAccountUseCaseImpl(BalanceAccountDataProvider repository) {
        _repository = repository;
    }

    @Override
    public BalanceAccount getBalanceAccount(Account account) {
        if(account.getStatus().equals("BLOCKED"))
            throw new IllegalArgumentException("Account is blocked.");

        List<OperationAccount> balances = _repository.getBalances(account.getId());

        AtomicReference<Double> balance = new AtomicReference<>((double) 0);

        balances.forEach(c -> {
            if(c.getOperation().equals(Operation.INCREASE))
                balance.updateAndGet(v -> (v + c.getValue()));
            else
                balance.updateAndGet(v -> (v - c.getValue()));
        });

        return BalanceAccount.builder()
                .account(account.getAccount())
                .balance(balance.get())
                .accountDigit(account.getAccountDigit())
                .document(account.getDocument())
                .build();
    }
}
