package br.com.revobank.app.dataprovider.account;


import br.com.revobank.entity.account.Account;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.text.ParseException;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
public class AccountModel {
    private String name;
    private String document;
    private String birthDate;
    private String account;
    private int accountDigit;
    private br.com.revobank.entity.account.JobTitle jobTitle;
    private String status;
    private Date createdAt;
    private Date updatedAt;
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public AccountModel() {

    }

    public static AccountModel fromDomain(Account account) {
        return AccountModel.builder()
                .id(account.getId())
                .name(account.getName())
                .document(account.getDocument())
                .birthDate(account.getBirthDate())
                .account(account.getAccount())
                .accountDigit(account.getAccountDigit())
                .jobTitle(account.getJobTitle())
                .status(account.getStatus())
                .createdAt(account.getCreatedAt())
                .updatedAt(account.getUpdatedAt())
                .build();
    }

    public Account toDomain() throws ParseException {
        return Account.builder()
                .id(id)
                .name(name)
                .document(document)
                .birthDate(birthDate)
                .account(account)
                .accountDigit(accountDigit)
                .jobTitle(jobTitle)
                .status(status)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
