package ru.test.cryptostock.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private UUID id =UUID.randomUUID();
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<WalletFunds> walletFunds;
    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true)
    private List<WalletTransaction> walletTransaction;
    private LocalDateTime creationDate;
    private Boolean isEnable;




}
