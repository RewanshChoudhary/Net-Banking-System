package com.example.netbanking.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.example.netbanking.dto.CreateAccountDto;
import com.example.netbanking.model.Accounts;
import com.example.netbanking.model.enums.AccountStatus;
import com.example.netbanking.repository.AccountRepository;
import com.example.netbanking.repository.UserRepository;

@Service
public class AccountService {
  private final AccountRepository accountRepository;
  private final UserRepository userRepository;

  public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
    this.accountRepository = accountRepository;
    this.userRepository = userRepository;
  }

  public String getGeneratedAccountNumber()

  public void createAccount(CreateAccountDto request) {
    Accounts acc = Accounts.builder()
        .owner(userRespository.getUserByEmail())

        .status(AccountStatus.ACTIVE)
        .accountNumber()
        .createdAt(OffsetDateTime.now())

        .balance(0)
        .accountType(request.accountType)
        .build();

    accountRepository.save(acc);

  }

}
