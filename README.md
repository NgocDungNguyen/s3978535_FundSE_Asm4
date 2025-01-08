# Account Registration System

This project implements an **Account Registration System** with validation for email, OTP (One-Time Password), and password strength. It also includes comprehensive **JUnit 5 tests** to verify the functionality of the system.

---

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Project Structure](#project-structure)
4. [Setup Instructions](#setup-instructions)
5. [Test Case Table](#test-case-table)
6. [JUnit Test Results](#junit-test-results)
7. [How to Run Tests](#how-to-run-tests)
8. [Conclusion](#conclusion)

---

## Overview

The **Account Registration System** validates user input during registration. It ensures that:
- The email is in a valid format.
- The OTP is provided and not expired.
- The password meets security requirements.

The system is tested using **JUnit 5** to ensure all edge cases and scenarios are handled correctly.

---

## Features

- **Email Validation**: Ensures the email is in a valid format.
- **OTP Validation**: Checks if the OTP is provided and not expired.
- **Password Strength Validation**: Ensures the password meets security standards.
- **JUnit 5 Tests**: Comprehensive test cases for all scenarios.

---

## Project Structure

```
s3978535_fundse_asm4
│
├── .idea/                     # IntelliJ IDEA project files
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org.example/
│   │   │       ├── Account.java
│   │   │       ├── AccountService.java
│   │   │       ├── ExpiredOTPException.java
│   │   │       ├── InvalidEmailException.java
│   │   │       ├── MissingOTPException.java
│   │   │       ├── WeakPasswordException.java
│   │   │       └── Main.java
│   │   └── resources/
│   └── test/
│       └── java/
│           └── org.example/
│               └── AccountingRegistrationTest.java
├── pom.xml                    # Maven configuration file
└── README.md                  # Project documentation
```

---

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   cd s3978535_fundse_asm4
   ```

2. **Open in IntelliJ IDEA**:
   - Open the project in IntelliJ IDEA.
   - Ensure the JDK version is set to **17**.

3. **Install Dependencies**:
   - Maven will automatically download the required dependencies (JUnit 5) when you build the project.

4. **Run the Tests**:
   - Navigate to `AccountingRegistrationTest.java`.
   - Right-click and select **Run 'AccountingRegistrationTest'**.

---

## Test Case Table

| Test Case                     | Test Data                                                                                     | Expected Result                                                                                     | Test Result |
|-------------------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|-------------|
| **Valid Registration**        | **Set 1**: Full Name: John Doe, Email: john.doe@example.com, Phone: 1234567890, Password: SecurePass123@@, OTP: 123456<br>**Set 2**: Full Name: Mary Smith, Email: mary.smith@example.com, Phone: 0987654321, Password: StrongPass456@, OTP: 654321 | Registration succeeds, displaying a success message and redirecting to the login screen.            | PASS        |
| **Invalid Email**             | **Set 1**: Full Name: Invalid Email User, Email: invalid-email, Phone: 1234567890, Password: Pass123!, OTP: 123456<br>**Set 2**: Full Name: Test User, Email: test.user@domain, Phone: 0987654321, Password: Pass456@, OTP: 654321 | Registration fails, displaying an error message: "Invalid email format."                            | PASS        |
| **Missing OTP**               | **Set 1**: Full Name: Missing OTP User, Email: otp.missing@example.com, Phone: 1234567890, Password: MissingOTP123!, OTP: (empty)<br>**Set 2**: Full Name: No OTP Provided, Email: no.otp@domain.com, Phone: 0987654321, Password: NoOTP456@, OTP: (empty) | Registration fails, displaying an error message: "OTP is required."                                 | PASS        |
| **Expired OTP**               | **Set 1**: Full Name: Expired OTP User, Email: expired.otp@example.com, Phone: 1234567890, Password: ExpiredOTP123!, OTP: 111111<br>**Set 2**: Full Name: OTP Expired Test, Email: otp.expired@domain.com, Phone: 0987654321, Password: ExpiredOTP456@, OTP: 222222 | Registration fails, displaying an error message: "OTP has expired. Please request a new one."       | PASS        |
| **Weak Password**             | **Set 1**: Full Name: Weak Password User, Email: weak.password@example.com, Phone: 1234567890, Password: password, OTP: 123456<br>**Set 2**: Full Name: Test Weak Password, Email: weak.password@domain.com, Phone: 0987654321, Password: 12345, OTP: 654321 | Registration fails, displaying an error message: "Password is too weak. Please use a stronger password." | PASS        |

---

## JUnit Test Results

All test cases have been implemented and executed successfully. Below are the results:

1. **Valid Registration**: ✅ PASS
2. **Invalid Email**: ✅ PASS
3. **Missing OTP**: ✅ PASS
4. **Expired OTP**: ✅ PASS
5. **Weak Password**: ✅ PASS

---

## How to Run Tests

1. Open the `AccountingRegistrationTest.java` file in IntelliJ IDEA.
2. Right-click on the file and select **Run 'AccountingRegistrationTest'**.
3. IntelliJ will execute all the test cases, and the results will be displayed in the **Run** window.

---

## Example Output

### Valid Registration
```
Test Case: Valid Registration
Result: PASS
```

### Invalid Email
```
Test Case: Invalid Email
Result: PASS
Error Message: "Invalid email format."
```

### Missing OTP
```
Test Case: Missing OTP
Result: PASS
Error Message: "OTP is required."
```

### Expired OTP
```
Test Case: Expired OTP
Result: PASS
Error Message: "OTP has expired. Please request a new one."
```

### Weak Password
```
Test Case: Weak Password
Result: PASS
Error Message: "Password is too weak. Please use a stronger password."
```

---

## Conclusion

The **Account Registration System** is fully functional and has been rigorously tested using JUnit 5. All test cases have passed successfully, ensuring the system handles all edge cases and scenarios effectively.

Feel free to contribute or raise issues if you encounter any problems. Happy coding! 🚀


## Author

- **Nguyen Ngoc Dung**
- **s3978535**
- **Email**: s3978535@rmit.edu.vn