package ru.test.cryptostock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.test.cryptostock.entity.Currency;

public interface CurrencyRepository extends JpaRepository <Currency,Long> {


}
