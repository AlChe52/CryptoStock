package ru.test.cryptostock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.cryptostock.entity.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository <ExchangeRate,Long> {
}
