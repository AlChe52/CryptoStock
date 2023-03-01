package ru.test.cryptostock.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.cryptostock.entity.Wallet;
import ru.test.cryptostock.entity.WalletFund;
import ru.test.cryptostock.entity.WalletTransaction;
import ru.test.cryptostock.repository.CurrencyRepository;
import ru.test.cryptostock.repository.UserRepository;
import ru.test.cryptostock.repository.WalletRepository;
import ru.test.cryptostock.service.WalletService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final WalletRepository walletRepository;
    @Override
    public Wallet createWallet(Long id) {
        var user = userRepository.findById(id).get();
        var currency = currencyRepository.findById(1L).get();
        var walletFund = new WalletFund();
        walletFund.setCurrency(currency);
        walletFund.setWalletFunds(BigDecimal.ZERO);
        List<WalletFund> walletFunds = new ArrayList<>();
        walletFunds.add(walletFund);
        List < WalletTransaction> walletTransactions =new ArrayList<>();
        var wallet = new Wallet();
        wallet.setCreationDate(LocalDateTime.now());
        wallet.setWalletFunds(walletFunds);
        wallet.setWalletTransaction(walletTransactions);
        wallet.setIsEnable(true);
       var walletResponce=  walletRepository.save(wallet);
       var wallets = new HashMap<String,Wallet>();
       wallets.put(walletResponce.getId().toString(),wallet);
       user.setWallet(wallets);
       userRepository.save(user);
       return walletResponce;
    }

    @Override
    public Wallet addCash(Long id,BigDecimal cash) {
        var user = userRepository.findById(id).get();



        return null;
    }

    @Override
    public Wallet exchangeCurrency(Long id) {
        return null;
    }

    @Override
    public Wallet transferFunds(Long id) {
        return null;
    }

    @Override
    public Wallet withdrawl(Long id) {
        return null;
    }
}
