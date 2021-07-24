package br.com.revobank.app.endpoint.account;

import br.com.revobank.entity.account.Account;
import br.com.revobank.usecase.account.BlockAccountUseCase;
import br.com.revobank.usecase.account.GetAccountUseCase;
import br.com.revobank.usecase.account.UpdateAccountUseCase;
import org.springframework.web.bind.annotation.*;
import br.com.revobank.usecase.account.CreateAccountUseCase;

import java.text.ParseException;

@RestController
@RequestMapping("/account")
public class AccountEndpoint {

    private final CreateAccountUseCase _createAccountUseCase;
    private final BlockAccountUseCase _blockAccountUseCase;
    private final GetAccountUseCase _getAccountUseCase;
    private final UpdateAccountUseCase _updateAccountUseCase;

    public AccountEndpoint(final CreateAccountUseCase createAccountUseCase,
                           BlockAccountUseCase blockAccountUseCase,
                           GetAccountUseCase getAccountUseCase,
                           UpdateAccountUseCase updateAccountUseCase) {
        this._createAccountUseCase = createAccountUseCase;
        _blockAccountUseCase = blockAccountUseCase;
        _getAccountUseCase = getAccountUseCase;
        _updateAccountUseCase = updateAccountUseCase;
    }

    @PostMapping
    public Account createAccount(@RequestBody() AccountRequest accountRequest) throws ParseException {
        return _createAccountUseCase.createAccount(accountRequest.toAccount());
    }

    @PutMapping("/{id}/block")
    public void blockAccount(@PathVariable("id") long accountId) throws ParseException {
        _blockAccountUseCase.blockAccount(_getAccountUseCase.getAccountById(accountId));
    }

    @PutMapping("/{id}")
    public Account updateAccount(@RequestBody AccountUpdate accountRequest) throws ParseException {
        return _updateAccountUseCase.updateAccount(accountRequest.toAccount());
    }
}
