package br.com.revobank.usecase.account.impl;

import br.com.revobank.dataprovider.account.AccountDataProvider;
import br.com.revobank.entity.account.Account;
import br.com.revobank.usecase.account.BlockAccountUseCase;
import br.com.revobank.usecase.account.impl.BlockAccountUseCaseImpl;
import br.com.revobank.usecase.mock.AccountMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class BlockAccountUseCaseImplTest {
    @Mock
    private AccountDataProvider accountDataProvider;

    private BlockAccountUseCase blockAccount;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        blockAccount = new BlockAccountUseCaseImpl(accountDataProvider);
    }

    @Test
    void blockAccount() throws ParseException {
        Account account = AccountMock.getAccount().build();
        when(accountDataProvider.save(any())).thenReturn(AccountMock.getAccount().status("BLOCKED").build());
        blockAccount.blockAccount(account);

        Assertions.assertEquals("BLOCKED", account.getStatus());
    }
}