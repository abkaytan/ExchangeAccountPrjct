package com.patika.exchangeAccountDeneme.repository;

import com.patika.exchangeAccountDeneme.entity.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    public Account getAccountByCustomerId (Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE id=1")
    public Account getAccountById();
}
