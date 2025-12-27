package com.example.netbanking.repository;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.netbanking.model.Accounts;

public interface AccountRepository extends JpaRepository<Accounts,UUID>{

}
