package br.com.revobank.usecase.account;

import br.com.revobank.entity.account.Account;

public interface GetAccountUseCase {
    Account getAccountById(long accountId);
}
