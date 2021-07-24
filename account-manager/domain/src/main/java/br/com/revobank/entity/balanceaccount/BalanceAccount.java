package br.com.revobank.entity.balanceaccount;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BalanceAccount {
    private String account;
    private int accountDigit;
    private String document;
    private double balance;
}
