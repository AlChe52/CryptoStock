package ru.test.cryptostock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<WalletFund> walletFunds;
    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
    private List<WalletTransaction> walletTransaction;
    private LocalDateTime creationDate;
    private Boolean isEnable;




}
