package it.chusen.tools.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chusen
 * @date 2019/12/10 16:12
 */
@Component
public class UserTest {
    @Value("123")
    public String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void eat(String foot) {
        System.out.println("吃: " + foot);
    }


    public void sleep() {
        System.out.println("睡觉");
    }

}
