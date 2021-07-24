package br.com.revobank.usecase.mock;

import br.com.revobank.entity.account.Account;

import java.text.ParseException;
import java.util.Date;

public class AccountMock {
    public static Account.AccountBuilder getAccount() throws ParseException {
        return Account.builder()
                .id(1)
                .name("Eduardo")
                .document("47950842133")
                .account("1234567")
                .accountDigit(1)
                .createdAt(new Date())
                .updatedAt(new Date())
                .status("ACTIVE")
                .birthDate("07/11/1995");
    }
}
