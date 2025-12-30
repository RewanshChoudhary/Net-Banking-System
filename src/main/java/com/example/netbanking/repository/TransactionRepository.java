package com.example.netbanking.repository;

import org.hibernate.validator.constraints.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.netbanking.model.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,UUID>  {
   

}
