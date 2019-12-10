package it.chusen.tools.proxy;

/**
 * @author chusen
 * @date 2019/12/10 18:08
 */
public class MyProxyTest {
    public static void main(String[] args) {
        LoginService loginService = new LoginServiceProxy(LoginService.class).getProxyObject();
        String res = loginService.login("chusen", "13");
        System.out.println(res);
    }
}
