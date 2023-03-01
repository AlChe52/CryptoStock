package ru.test.cryptostock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.test.cryptostock.entity.Wallet;
import ru.test.cryptostock.service.UserService;
import ru.test.cryptostock.service.WalletService;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final WalletService walletService;
    @PostMapping("/{id}/createwallet")
    public ResponseEntity<String> createWallet(@PathVariable Long id) {
        walletService.createWallet(id);

        return ResponseEntity.ok("Wallet created");
    }
}
