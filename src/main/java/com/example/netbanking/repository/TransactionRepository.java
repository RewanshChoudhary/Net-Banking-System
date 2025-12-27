package com.example.netbanking.repository;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.netbanking.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,UUID>  {


}
