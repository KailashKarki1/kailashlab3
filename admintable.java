package com.example.kailashlab3;


public class admintable{
    private int SN;
    private String UserName;
    private int PhoneNumber;
    private String Address;

    public int getSN() {
        return SN;
    }

    public void setSN(int SN) {
        this.SN = SN;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public admintable(int SN, String userName, int phoneNumber, String address) {
        this.SN = SN;
        UserName = userName;
        PhoneNumber = phoneNumber;
        Address = address;
    }
}