package br.com.revobank.usecase.balanceaccount.factory;

import br.com.revobank.dataprovider.account.AccountDataProvider;
import br.com.revobank.dataprovider.account.BalanceAccountDataProvider;
import br.com.revobank.entity.account.JobTitle;
import br.com.revobank.usecase.balanceaccount.CreateBalanceAccountUseCase;
import br.com.revobank.usecase.balanceaccount.impl.CreateBalanceCounterAccountUseCaseImpl;
import br.com.revobank.usecase.balanceaccount.impl.CreateBalanceDirectorAccountUseCaseImpl;
import br.com.revobank.usecase.balanceaccount.impl.CreateBalanceProgrammerAccountUseCaseImpl;

public class AccountJobTitleFactory {

    private final BalanceAccountDataProvider _dataProvider;

    public AccountJobTitleFactory(BalanceAccountDataProvider dataProvider) {
        _dataProvider = dataProvider;
    }

    public CreateBalanceAccountUseCase balanceAccountByJobTitle(JobTitle jobTitle) {
        if(jobTitle.equals(JobTitle.DIRECTOR))
            return new CreateBalanceDirectorAccountUseCaseImpl(_dataProvider);
        if(jobTitle.equals(JobTitle.COUNTER))
            return new CreateBalanceCounterAccountUseCaseImpl(_dataProvider);

        return new CreateBalanceProgrammerAccountUseCaseImpl(_dataProvider);
    }
}
