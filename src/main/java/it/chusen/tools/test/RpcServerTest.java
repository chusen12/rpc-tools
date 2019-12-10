package it.chusen.tools.test;

import it.chusen.tools.server.ServiceRegistry;
import it.chusen.tools.server.BioRpcServer;
import it.chusen.tools.service.HelloService;
import it.chusen.tools.server.service.HelloServiceImpl;
import org.junit.Test;

/**
 * @author chusen
 * @date 2019/12/10 15:50
 */
public class RpcServerTest {


    @Test
    public void test01() {
        ServiceRegistry.registerService(HelloService.class, HelloServiceImpl.class);
        new BioRpcServer(10000).start();
    }
}
