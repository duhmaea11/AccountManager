package br.com.revobank.entity.balanceaccount;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class OperationAccount {
    private long id;
    private Operation operation;
    private double value;
    private long accountId;
}
