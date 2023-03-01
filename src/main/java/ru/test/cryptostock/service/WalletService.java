package ru.test.cryptostock.service;

import org.springframework.http.ResponseEntity;
import ru.test.cryptostock.entity.Wallet;
import ru.test.cryptostock.request.RefillFundRequest;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService {


     Wallet createWallet(Long id);

    List<Wallet>getAllWallets(Long id);

    String addCash (Long id, String walletId, RefillFundRequest refillFundRequest);

    Wallet exchangeCurrency(Long id);

    Wallet transferFunds(Long id);

    Wallet withdrawl (Long id);



}
