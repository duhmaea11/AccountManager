package br.com.revobank.app.dataprovider.balanceaccount;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceAccountH2Repository extends JpaRepository<BalanceAccountModel, Long> {
    List<BalanceAccountModel> findByAccountId(long accountId);
}
