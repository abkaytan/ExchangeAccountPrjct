package com.patika.exchangeAccountDeneme.repository;

import com.patika.exchangeAccountDeneme.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUsername(String username);
}
