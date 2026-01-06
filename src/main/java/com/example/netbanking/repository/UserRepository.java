package com.example.netbanking.repository;


import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.netbanking.model.Users;
@Repository

public interface UserRepository extends JpaRepository<Users ,UUID> {
 boolean existsByEmail(String email);
  @Query(value="""
  Select * from userss where email= email
  """")
Users getUserByEmail(String email);



}
