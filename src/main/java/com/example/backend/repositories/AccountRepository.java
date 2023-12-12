package com.example.backend.repositories;

import com.example.backend.models.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("SELECT a FROM Account a ")
    Page<Account> getAll2(Pageable pageable);
}