package br.com.revobank.entity.account;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@ToString
public class Account {
    private long id;
    private String name;
    private String document;
    private String birthDate;
    private String account;
    private int accountDigit;
    private JobTitle jobTitle;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    @Builder
    public Account(long id, String name, String document, String birthDate, String account, int accountDigit, JobTitle jobTitle, String status, Date createdAt, Date updatedAt) throws ParseException {

        try {
            new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        } catch(Exception e){
            throw new IllegalArgumentException("Date informed not is valid.");
        }

        this.id = id;
        this.name = name;
        this.document = document;
        this.birthDate = birthDate;
        this.account = account;
        this.accountDigit = accountDigit;
        this.jobTitle = jobTitle;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
