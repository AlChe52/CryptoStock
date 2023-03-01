package ru.test.cryptostock.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.test.cryptostock.entity.Wallet;
import ru.test.cryptostock.service.UserService;

@RestController
@RequestMapping("/api/v1/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/{id}/createwallet")
    public ResponseEntity<String> createWallet(@PathVariable Long id) {
        userService.createWallet(id);

        return ResponseEntity.ok("Wallet created");
    }
}
