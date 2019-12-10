package it.chusen.tools.test;

import it.chusen.tools.anno.Reference;
import it.chusen.tools.client.config.RpcClientConfig;
import it.chusen.tools.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chusen
 * @date 2019/12/10 17:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RpcClientConfig.class)
public class RpcClientTestWithSpring {

    @Reference
    private HelloService helloService;

    @Test
    public void test01() {
        String result = this.helloService.sayHello("楚森");
        System.out.println(result);
    }
}
