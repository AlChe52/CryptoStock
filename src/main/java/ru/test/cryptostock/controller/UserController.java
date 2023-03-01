package ru.test.cryptostock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.test.cryptostock.entity.Wallet;
import ru.test.cryptostock.request.RefillFundRequest;
import ru.test.cryptostock.service.UserService;
import ru.test.cryptostock.service.WalletService;

import java.util.List;

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

    @GetMapping("/{id}/getallwallets")
    public List<Wallet> getAllWallets (@PathVariable Long id) {

        return walletService.getAllWallets(id);
    }

    @PostMapping("/{id}/wallet/{walletId}")
    public ResponseEntity <String> addCash (@PathVariable Long id, @PathVariable String walletId,
                                            @RequestBody RefillFundRequest refillFundRequest) {





    return ResponseEntity.ok(walletService.addCash(id, walletId, refillFundRequest));
    }
}