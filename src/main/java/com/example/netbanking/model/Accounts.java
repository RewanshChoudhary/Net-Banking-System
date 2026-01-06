package com.example.netbanking.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import com.example.netbanking.model.enums.AccountStatus;
import com.example.netbanking.model.enums.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
@Builder
public class Accounts {
  @Id
  @Column(name = "account_id")

  private UUID accountId;
  @Column(name = "account_number")
  private String accountNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "owner_id", nullable = false)

  private Users owner;
  @Column(name = "balance", nullable = false)

  private BigDecimal balance;
  @Enumerated(EnumType.STRING)
  @JoinColumn(name = "account_status", nullable = false)

  private AccountStatus status;

  @Enumerated(EnumType.STRING)
  @JoinColumn(name = "acccunt_type", nullable = false)

  private AccountType accountType;
  @Column(name = "created_at", nullable = false)

  private OffsetDateTime createdAt;

}
