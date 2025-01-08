package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Account Registration System");
        System.out.println("===========================================");

        AccountService accountService = new AccountService();
        Scanner scanner = new Scanner(System.in);

        try {
            // Collect user input for account registration
            System.out.print("Enter your full name: ");
            String fullName = scanner.nextLine();

            System.out.print("Enter your email: ");
            String email = scanner.nextLine();

            System.out.print("Enter your phone number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            System.out.print("Enter the OTP sent to your phone: ");
            String otp = scanner.nextLine();

            // Create an Account object
            Account account = new Account(fullName, email, phone, password, otp);

            // Attempt to register the account
            if (accountService.registerAccount(account)) {
                System.out.println("Registration successful! You can now log in.");
            }
        } catch (InvalidEmailException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (MissingOTPException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ExpiredOTPException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (WeakPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Thank you for using the Account Registration System!");
    }
}


