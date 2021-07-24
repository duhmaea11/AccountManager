package br.com.revobank.app.dataprovider.balanceaccount;

import br.com.revobank.entity.balanceaccount.OperationAccount;
import br.com.revobank.entity.balanceaccount.Operation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
@Builder
@AllArgsConstructor
@ToString
public class BalanceAccountModel {
    private Operation operation;
    private double value;
    private long accountId;
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public BalanceAccountModel() {

    }

    public static BalanceAccountModel fromDomain(OperationAccount account) {
        return BalanceAccountModel.builder()
                .id(account.getId())
                .operation(account.getOperation())
                .value(account.getValue())
                .accountId(account.getAccountId())
                .build();
    }

    public OperationAccount toDomain() {
        return OperationAccount.builder()
                .id(id)
                .operation(operation)
                .value(value)
                .accountId(accountId)
                .build();
    }
}