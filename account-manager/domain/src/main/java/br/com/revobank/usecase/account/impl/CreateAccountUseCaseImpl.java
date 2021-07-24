package br.com.revobank.usecase.account.impl;

import br.com.revobank.dataprovider.account.AccountDataProvider;
import br.com.revobank.dataprovider.account.BalanceAccountDataProvider;
import br.com.revobank.entity.account.Account;
import br.com.revobank.usecase.account.CreateAccountUseCase;
import br.com.revobank.usecase.balanceaccount.CreateBalanceAccountUseCase;
import br.com.revobank.usecase.balanceaccount.factory.AccountJobTitleFactory;
import org.apache.commons.lang.StringUtils;

import javax.inject.Named;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

@Named
public class CreateAccountUseCaseImpl implements CreateAccountUseCase {

    private final AccountDataProvider _dataProvider;
    private final BalanceAccountDataProvider _balanceAccountDataProvider;

    public CreateAccountUseCaseImpl(AccountDataProvider dataProvider, BalanceAccountDataProvider balanceAccountDataProvider) {
        _dataProvider = dataProvider;
        _balanceAccountDataProvider = balanceAccountDataProvider;
    }

    @Override
    public Account createAccount(Account account) throws ParseException {
        if (!StringUtils.isNotEmpty(account.getDocument()))
            throw new RuntimeException("CPF is required.");

        if (!StringUtils.isNotEmpty(account.getName()))
            throw new RuntimeException("Name is required.");

        if (accountExists(account.getDocument()))
            throw new IllegalArgumentException("An account already exists for this document.");

        Random random = new Random();
        account.setAccount(String.valueOf(1000000 + random.nextInt(9000000)));
        account.setAccountDigit(random.nextInt(10));

        account.setStatus("ACTIVE");
        account.setCreatedAt(new Date());
        account.setUpdatedAt(new Date());

        CreateBalanceAccountUseCase balance = new AccountJobTitleFactory(_balanceAccountDataProvider)
                .balanceAccountByJobTitle(account.getJobTitle());

        account = _dataProvider.createAccount(account);

        balance.createBalanceAccount(account.getId());

        return account;
    }

    private boolean accountExists(String document) throws ParseException {
        Account account = _dataProvider.findByDocument(document);

        return account != null;
    }
}
