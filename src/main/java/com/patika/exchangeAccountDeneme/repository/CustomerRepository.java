package com.patika.exchangeAccountDeneme.repository;

import com.patika.exchangeAccountDeneme.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM test.customer WHERE id=?1")
    public Customer getCustomerById(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM test.customer WHERE fullName=?1 AND password=?2")
    public Customer getCustomerByFullNameAndPassword(String fullName, String password);

    Customer findByFullName(String fullName);
    //Customer getCustomerByFullNameAndPassword(String fullName, String password);
}
