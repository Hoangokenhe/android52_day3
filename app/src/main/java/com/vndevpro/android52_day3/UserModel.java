package com.vndevpro.android52_day3;

import java.io.Serializable;

public class UserModel implements Serializable {
    private String Name;
    private String password;
    private String phone;
    private String email;

    public UserModel() {
    }

    public UserModel(String userName, String passwords, String address, String email) {
        this.Name = userName;
        this.password = passwords;
        this.phone = address;
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String userName) {
        this.Name = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "Name='" + Name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
