package ru.test.cryptostock.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.test.cryptostock.entity.Currency;
import ru.test.cryptostock.entity.ExchangeRate;
import ru.test.cryptostock.repository.CurrencyRepository;
import ru.test.cryptostock.repository.ExchangeRateRepository;
import ru.test.cryptostock.repository.UserRepository;
import ru.test.cryptostock.entity.Role;
import ru.test.cryptostock.entity.User;

import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final ExchangeRateRepository exchangeRateRepository;

    @Bean
    void addAdmin () {
        var admin = User.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .email("1@mail.ru")
                .password(passwordEncoder().encode("1111"))
                .role(Role.ADMIN)
                .build();
        userRepository.save(admin);
    }
    @Bean
    void addCurrency() {
        var currency = Currency.builder()
                .currencyType("RUB")
                .currencyDescription("ruble")
                .build();
        currencyRepository.save(currency);

        var currency1 = Currency.builder()
                .currencyType("TON")
                .currencyDescription("telegram")
                .build();
        currencyRepository.save(currency1);

        var currency2 = Currency.builder()
                .currencyType("BTC")
                .currencyDescription("bitcoin")
                .build();
        currencyRepository.save(currency2);
    }

    @Bean
    public UserDetailsService userDetailsService () {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
    @Bean
    public AuthenticationProvider authenticationProvider () {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

