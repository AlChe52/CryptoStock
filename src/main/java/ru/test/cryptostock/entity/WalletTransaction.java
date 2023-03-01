package ru.test.cryptostock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @OneToOne(cascade = CascadeType.ALL)
    private Currency currencyFrom;
    @OneToOne(cascade = CascadeType.ALL)
    private Currency currencyTo;
    private BigDecimal transactionAmount;
    private LocalDateTime transactionDate;

}
