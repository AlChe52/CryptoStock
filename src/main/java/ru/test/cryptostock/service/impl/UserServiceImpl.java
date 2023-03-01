package ru.test.cryptostock.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.cryptostock.entity.Wallet;
import ru.test.cryptostock.repository.UserRepository;
import ru.test.cryptostock.service.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void createWallet(Long id) {
        var user = userRepository.findById(id).get();
        var wallet = Wallet.builder()
                .creationDate(LocalDateTime.now())
                .walletTransaction(new ArrayList<>())
                .walletFunds(new ArrayList<>())
                .isEnable(true)
                .build();
        List<Wallet> wallets = new ArrayList<>();
        wallets.add(wallet);
        user.setWallet(wallets);
        userRepository.save(user);

    }
}
