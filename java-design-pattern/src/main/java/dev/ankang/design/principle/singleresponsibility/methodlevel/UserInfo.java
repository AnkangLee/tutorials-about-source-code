package dev.ankang.design.principle.singleresponsibility.methodlevel;

import lombok.ToString;

@ToString
public class UserInfo {

    private String userName;
    private String address;

    public void updateUserName(String userName) {
        this.userName = "Tom";
    }
    public void updateUserAddress(String address) {
        this.address = "beijing";
    }
}
