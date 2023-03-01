package ru.test.cryptostock.service;

import ru.test.cryptostock.entity.Wallet;

import java.math.BigDecimal;

public interface WalletService {


    Wallet  createWallet(Long id);

    Wallet addCash (Long id, BigDecimal cash);

    Wallet exchangeCurrency(Long id);

    Wallet transferFunds(Long id);

    Wallet withdrawl (Long id);



}
