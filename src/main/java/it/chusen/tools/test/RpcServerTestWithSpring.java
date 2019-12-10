package it.chusen.tools.test;

import it.chusen.tools.server.config.RpcServerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author chusen
 * @date 2019/12/10 16:43
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = RpcServerConfig.class)
public class RpcServerTestWithSpring {
//    @Test
//    public void test01() throws InterruptedException {
//        Thread.sleep(Integer.MAX_VALUE);
//    }

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RpcServerConfig.class);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
