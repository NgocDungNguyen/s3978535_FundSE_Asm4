package org.example;

import java.util.regex.Pattern;

public class AccountService {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public boolean registerAccount(Account account) throws InvalidEmailException, MissingOTPException, ExpiredOTPException, WeakPasswordException {
        // Validate email
        validateEmail(account.getEmail());

        // Validate OTP
        validateOTP(account.getOtp());

        // Validate password
        validatePassword(account.getPassword());

        // If all validations pass, return true (registration succeeds)
        return true;
    }

    private void validateEmail(String email) throws InvalidEmailException {
        if (!Pattern.compile(EMAIL_REGEX).matcher(email).matches()) {
            throw new InvalidEmailException("Invalid email format");
        }
    }

    private void validateOTP(String otp) throws MissingOTPException, ExpiredOTPException {
        if (otp == null || otp.isEmpty()) {
            throw new MissingOTPException("OTP is required");
        }
        // Simulate an expired OTP for testing purposes
        if ("111111".equals(otp)) {
            throw new ExpiredOTPException("OTP has expired. Please request a new one.");
        }
    }

    private void validatePassword(String password) throws WeakPasswordException {
        if (!Pattern.compile(PASSWORD_REGEX).matcher(password).matches()) {
            throw new WeakPasswordException("Password is too weak. Please use a stronger password.");
        }
    }
}