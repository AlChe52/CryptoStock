package ru.test.cryptostock.service;

import ru.test.cryptostock.entity.Wallet;

public interface WalletService {

    Wallet addCash (Long id);

    Wallet exchangeCurrency(Long id);

    Wallet transferFunds(Long id);

    Wallet withdrawl (Long id);



}
