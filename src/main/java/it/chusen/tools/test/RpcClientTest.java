package it.chusen.tools.test;

import it.chusen.tools.client.RpcProxyFactory;
import it.chusen.tools.service.HelloService;
import org.junit.Test;

/**
 * @author chusen
 * @date 2019/12/10 15:52
 */
public class RpcClientTest {
    @Test
    public void test01() {
        HelloService helloService = new RpcProxyFactory<>(HelloService.class).getProxyObject();
        String result = helloService.sayHello("chusen");
        System.out.println(result);
    }
}
