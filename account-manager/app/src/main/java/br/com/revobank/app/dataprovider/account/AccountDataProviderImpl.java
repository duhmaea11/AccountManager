package br.com.revobank.app.dataprovider.account;

import br.com.revobank.dataprovider.account.AccountDataProvider;
import br.com.revobank.entity.account.Account;

import javax.inject.Named;
import java.text.ParseException;
import java.util.Optional;

@Named("accountH2ProviderImpl")
public class AccountDataProviderImpl implements AccountDataProvider {
    private final AccountH2Repository _repository;

    public AccountDataProviderImpl(AccountH2Repository repository) {
        _repository = repository;
    }

    @Override
    public Account createAccount(Account account) throws ParseException {
        return _repository.save(AccountModel.fromDomain(account)).toDomain();
    }

    @Override
    public Account findByDocument(String cpf) throws ParseException {
        AccountModel model = _repository.findByDocument(cpf);
        return model != null ? model.toDomain() : null;
    }

    @Override
    public Optional<Account> findById(long accountId) {
        return _repository.findById(accountId).map(c -> {
            try {
                return c.toDomain();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        });
    }

    @Override
    public Account save(Account account) throws ParseException {
        return _repository.save(AccountModel.fromDomain(account)).toDomain();
    }
}
