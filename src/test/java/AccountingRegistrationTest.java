package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountingRegistrationTest {

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @Test
    public void testValidRegistration() {
        // Test Set 1
        Account account1 = new Account(
                "John Doe",
                "john.doe@example.com",
                "1234567890",
                "SecurePass123@@",
                "123456"
        );
        assertDoesNotThrow(() -> accountService.registerAccount(account1), "Valid registration should not throw an exception");

        // Test Set 2
        Account account2 = new Account(
                "Mary Smith",
                "mary.smith@example.com",
                "0987654321",
                "StrongPass456@",
                "654321"
        );
        assertDoesNotThrow(() -> accountService.registerAccount(account2), "Valid registration should not throw an exception");
    }

    @Test
    public void testInvalidEmail() {
        // Test Set 1
        Account account1 = new Account(
                "Invalid Email User",
                "invalid-email",
                "1234567890",
                "Pass123!",
                "123456"
        );
        assertThrows(InvalidEmailException.class,
                () -> accountService.registerAccount(account1),
                "Should throw InvalidEmailException for invalid email format");

        // Test Set 2
        Account account2 = new Account(
                "Test User",
                "test.user@domain",
                "0987654321",
                "Pass456@",
                "654321"
        );
        assertThrows(InvalidEmailException.class,
                () -> accountService.registerAccount(account2),
                "Should throw InvalidEmailException for invalid email format");
    }

    @Test
    public void testMissingOTP() {
        // Test Set 1
        Account account1 = new Account(
                "Missing OTP User",
                "otp.missing@example.com",
                "1234567890",
                "MissingOTP123!",
                ""
        );
        assertThrows(MissingOTPException.class,
                () -> accountService.registerAccount(account1),
                "Should throw MissingOTPException when OTP is empty");

        // Test Set 2
        Account account2 = new Account(
                "No OTP Provided",
                "no.otp@domain.com",
                "0987654321",
                "NoOTP456@",
                ""
        );
        assertThrows(MissingOTPException.class,
                () -> accountService.registerAccount(account2),
                "Should throw MissingOTPException when OTP is empty");
    }

    @Test
    public void testExpiredOTP() {
        // Test Set 1
        Account account1 = new Account(
                "Expired OTP User",
                "expired.otp@example.com",
                "1234567890",
                "ExpiredOTP123!",
                "111111"
        );
        assertThrows(ExpiredOTPException.class,
                () -> accountService.registerAccount(account1),
                "Should throw ExpiredOTPException when OTP has expired");

        // Test Set 2
        Account account2 = new Account(
                "OTP Expired Test",
                "otp.expired@domain.com",
                "0987654321",
                "ExpiredOTP456@",
                "222222"
        );
        assertThrows(ExpiredOTPException.class,
                () -> accountService.registerAccount(account2),
                "Should throw ExpiredOTPException when OTP has expired");
    }

    @Test
    public void testWeakPassword() {
        // Test Set 1
        Account account1 = new Account(
                "Weak Password User",
                "weak.password@example.com",
                "1234567890",
                "password",
                "123456"
        );
        assertThrows(WeakPasswordException.class,
                () -> accountService.registerAccount(account1),
                "Should throw WeakPasswordException for weak passwords");

        // Test Set 2
        Account account2 = new Account(
                "Test Weak Password",
                "weak.password@domain.com",
                "0987654321",
                "12345",
                "654321"
        );
        assertThrows(WeakPasswordException.class,
                () -> accountService.registerAccount(account2),
                "Should throw WeakPasswordException for weak passwords");
    }
}