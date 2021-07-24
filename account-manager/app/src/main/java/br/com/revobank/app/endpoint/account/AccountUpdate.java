package br.com.revobank.app.endpoint.account;

import br.com.revobank.entity.account.Account;
import br.com.revobank.entity.account.JobTitle;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class AccountUpdate {
    private long id;
    private String name;
    private String birthDate;
    private JobTitle jobTitle;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    public Account toAccount() throws ParseException {
        return Account.builder()
                .id(id)
                .name(name)
                .birthDate(birthDate)
                .jobTitle(jobTitle)
                .status(status)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
