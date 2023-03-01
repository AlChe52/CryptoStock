package ru.test.cryptostock.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefillFundRequest {

    private String currency;
    private BigDecimal transactionAmount;

}
