package br.com.revobank.app.endpoint.balanceaccount;

import br.com.revobank.entity.account.Account;
import br.com.revobank.entity.balanceaccount.BalanceAccount;
import br.com.revobank.usecase.account.GetAccountUseCase;
import br.com.revobank.usecase.balanceaccount.GetBalanceAccountUseCase;
import br.com.revobank.usecase.balanceaccount.OperationBalanceAccountUseCase;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/balance")
public class BalanceAccountEndpoint {
    private final GetAccountUseCase getAccountUseCase;
    private final GetBalanceAccountUseCase getBalanceAccount;
    private final OperationBalanceAccountUseCase operationAccountUseCase;

    public BalanceAccountEndpoint(GetAccountUseCase getAccountUseCase, GetBalanceAccountUseCase getBalanceAccount, OperationBalanceAccountUseCase operationAccountUseCase) {
        this.getAccountUseCase = getAccountUseCase;
        this.getBalanceAccount = getBalanceAccount;
        this.operationAccountUseCase = operationAccountUseCase;
    }

    @GetMapping("/{id}")
    public BalanceAccount getBalanceAccount(@PathVariable("id") long accountId) {
        Account account = getAccountUseCase.getAccountById(accountId);

        System.out.println(account);

        if(account == null)
            throw new IllegalArgumentException("Account not exists.");

        return getBalanceAccount.getBalanceAccount(account);
    }

    @PostMapping("/{id}/decrease")
    public BalanceAccount decreaseBalanceAccount(@PathVariable("id") long accountId,
                                                 @RequestParam("value") double value) throws ParseException {
        Account account = getAccountUseCase.getAccountById(accountId);

        if(account == null)
            throw new IllegalArgumentException("Account not exists.");

        operationAccountUseCase.decrease(account, value);

        return getBalanceAccount.getBalanceAccount(account);
    }
}
