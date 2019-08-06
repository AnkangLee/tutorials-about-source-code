package dev.ankang.design.principle.singleresponsibility.methodlevel;

import org.junit.Test;

public class UserInfoTest {
    /**
     * 方法层面的单一职责.
     */
    @Test
    public void updateUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.updateUserAddress("China");
        userInfo.updateUserName("ankang");
        System.out.println(userInfo);
    }
}