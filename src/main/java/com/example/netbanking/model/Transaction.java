package com.example.netbanking.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import com.example.netbanking.model.enums.TransactionStatus;
import com.example.netbanking.model.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Transactions")
@Data

public class Transaction {
  @Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
  @Id 
  @Column(name = "transaction_id")
  private UUID transactionId;

  @Enumerated(EnumType.STRING)
  @Column(name = "transaction_type", nullable = false)
  private TransactionType transType;

  @Column(name = "amount", nullable = false)

  private BigDecimal amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "from_account_id")
  private Accounts fromAccount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "to_account_id")
  private Accounts toAccount;

  @JoinColumn(name = "transaction_status", nullable = false)
  @Enumerated(EnumType.STRING)


  private TransactionStatus transStatus;
  @Column(name="created_at",nullable = false)
  
  private OffsetDateTime createdAt;

}
