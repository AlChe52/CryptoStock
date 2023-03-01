package ru.test.cryptostock.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.test.cryptostock.entity.TransactionType;
import ru.test.cryptostock.entity.Wallet;
import ru.test.cryptostock.entity.WalletFund;
import ru.test.cryptostock.entity.WalletTransaction;
import ru.test.cryptostock.repository.CurrencyRepository;
import ru.test.cryptostock.repository.UserRepository;
import ru.test.cryptostock.repository.WalletRepository;
import ru.test.cryptostock.request.RefillFundRequest;
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
        walletFund.setBalance(BigDecimal.ZERO);
        List<WalletFund> walletFunds = new ArrayList<>();
        walletFunds.add(walletFund);
        List < WalletTransaction> walletTransactions =new ArrayList<>();
        var wallet = new Wallet();
        wallet.setCreationDate(LocalDateTime.now());
        wallet.setWalletFunds(walletFunds);
        wallet.setWalletTransaction(walletTransactions);
        wallet.setIsEnable(true);

       var wallets = new ArrayList<Wallet>();
       wallets.add(wallet);

       user.setWallet(wallets);
       userRepository.save(user);

      return user.getWallet().get(wallets.size()-1);
    }

    @Override
    public List<Wallet> getAllWallets(Long id) {
        var user = userRepository.findById(id).get();

        return user.getWallet();
     }



//    @Override
//    public String addCash(Long id, String walletId, RefillFundRequest refillFundRequest) {
//
//
//
//        var user = userRepository.findById(id);
//        var wallet = walletRepository.findById(walletId);
//        Wallet wallet = null;
//
//        for (int i=0; i<wallets.size();i++) {
//            if (wallets.get(i).getId().equals(walletId)) {
//                wallet = wallets.get(i);
//                System.out.println(wallet);
//                break;
//            }
//        }
//
//
//            var walletTransactions = wallet.getWalletTransaction();
//
//                if (wallet.getWalletTransaction().isEmpty()) {
//                    walletTransactions = new ArrayList<>();
//                }
//
//                var walletTransaction = new WalletTransaction();
//
//                walletTransaction.setTransactionType(TransactionType.ADD);
//                walletTransaction.setTransactionDate(LocalDateTime.now());
//                walletTransaction.setCurrencyTo(currencyRepository.findCurrencyByCurrencyType(refillFundRequest.getCurrency()));
//                walletTransaction.setTransactionAmount(refillFundRequest.getTransactionAmount());
//                walletTransactions.add(walletTransaction);
//
//                wallet.setWalletTransaction(walletTransactions);
//
//                var walletFunds = wallet.getWalletFunds();
//                WalletFund walletFund = null;
//
//                for (int i = 0; i < wallets.size(); i++) {
//                    if (walletFunds.get(i).getCurrency().equals(refillFundRequest.getCurrency())) {
//                        walletFund = walletFunds.get(i);
//                        break;
//                    }
//                }
//                walletFund.setBalance(walletFund.getBalance().add(refillFundRequest.getTransactionAmount()));
//
//                walletFunds.add(walletFund);
//
//                wallet.setWalletFunds(walletFunds);
//                wallets.add(wallet);
//                user.get().setWallet(wallets);
//
//
//        userRepository.save(user.get());
//
//        String s = "Balance wallet "+wallet.getId()+" = ";
//
//        return s;
//    }

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
