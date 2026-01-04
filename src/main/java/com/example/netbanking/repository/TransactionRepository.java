package com.example.netbanking.repository;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.netbanking.model.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction,UUID>  {
   

}
