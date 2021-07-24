package br.com.revobank.app.dataprovider.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountH2Repository extends JpaRepository<AccountModel, Long> {
    @Query("SELECT a FROM AccountModel a WHERE a.document = ?1")
    AccountModel findByDocument(String document);
}
