package it.chusen.tools.server.service;

import it.chusen.tools.anno.Service;
import it.chusen.tools.service.HelloService;

/**
 * @author chusen
 * @date 2019/12/10 15:51
 */
@Service(HelloService.class)
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String hello) {
        return "hello : " + hello + "!";
    }
}
