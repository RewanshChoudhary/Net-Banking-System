package com.example.netbanking.model;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.example.netbanking.model.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "userss")
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")

  private UUID id;

  @Column(name = "full_name", nullable = false)

  private String name;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "phone_number", nullable = false, unique = true)
  private String phoneNo;
  @Column(name = "address")

  private String address;

  @Column(name = "password_hash", nullable = false)
  private String passwordHash;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_role")

  private UserRole role;

  @PrePersist
  public void prePersist() {
    if (role == null) {
      role = UserRole.USER;
    }
  }

  @Column(name = "created_at", nullable = false)

  private OffsetDateTime createdAt;
  @Column(name = "updated_at", nullable = false)

  private OffsetDateTime updatedAt;

}
