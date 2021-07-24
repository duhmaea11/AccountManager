package br.com.revobank.app.endpoint.account;

import br.com.revobank.entity.account.Account;
import br.com.revobank.entity.account.JobTitle;
import lombok.Data;

import java.text.ParseException;

@Data
public class AccountRequest {
    private String name;
    private String document;
    private String birthDate;
    private JobTitle jobTitle;

    public Account toAccount() throws ParseException {
        return Account.builder()
                .name(name)
                .document(document)
                .birthDate(birthDate)
                .jobTitle(jobTitle)
                .build();
    }
}
