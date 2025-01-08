package org.example;

public class Account {
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private String otp;

    public Account(String fullName, String email, String phone, String password, String otp) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.otp = otp;
    }

    // Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}