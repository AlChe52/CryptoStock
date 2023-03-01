package ru.test.cryptostock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.cryptostock.entity.Wallet;

public interface WalletRepository  extends JpaRepository<Wallet, Long> {
}
