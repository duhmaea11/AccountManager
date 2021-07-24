package br.com.revobank.app.dataprovider.balanceaccount;

import br.com.revobank.dataprovider.account.BalanceAccountDataProvider;
import br.com.revobank.entity.account.Account;
import br.com.revobank.entity.balanceaccount.BalanceAccount;
import br.com.revobank.entity.balanceaccount.OperationAccount;
import br.com.revobank.entity.balanceaccount.Operation;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named("balanceAccountDataProviderImpl")
public class BalanceAccountDataProviderImpl implements BalanceAccountDataProvider {
    private final BalanceAccountH2Repository _repository;

    public BalanceAccountDataProviderImpl(BalanceAccountH2Repository repository) {
        _repository = repository;
    }

    @Override
    public OperationAccount decreaseBalanceAccount(long idAccount, double value) {
        BalanceAccountModel model = BalanceAccountModel
                .builder()
                .operation(Operation.DECREASE)
                .value(value)
                .accountId(idAccount)
                .build();

        model = _repository.save(model);
        return model.toDomain();
    }

    @Override
    public OperationAccount increaseBalanceAccount(long idAccount, double value) {

        BalanceAccountModel model = BalanceAccountModel
                .builder()
                .operation(Operation.INCREASE)
                .value(value)
                .accountId(idAccount)
                .build();

        model = _repository.save(model);
        System.out.println(model);

        return model.toDomain();
    }

    @Override
    public List<OperationAccount> getBalances(long idAccount) {
        return _repository.findByAccountId(idAccount)
                .stream()
                .map(BalanceAccountModel::toDomain)
                .collect(Collectors.toList());
    }
}
