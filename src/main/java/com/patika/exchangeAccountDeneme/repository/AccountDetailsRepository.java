package com.patika.exchangeAccountDeneme.repository;

import com.patika.exchangeAccountDeneme.entity.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM test.account_details WHERE account_id = ?1 ORDER BY account_detail_id DESC LIMIT 5")
    List<AccountDetails> showAccountOperationDetails(long id);

}
