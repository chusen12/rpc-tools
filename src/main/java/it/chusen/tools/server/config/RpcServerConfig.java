package it.chusen.tools.server.config;

import it.chusen.tools.server.BioRpcServer;
import it.chusen.tools.server.RpcServer;
import it.chusen.tools.server.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author chusen
 * @date 2019/12/10 16:41
 */
@Configuration
@ComponentScan(basePackages = "it.chusen.tools.server.service")
public class RpcServerConfig {

    @Bean
    public RpcServer rpcServer() {
        return new BioRpcServer();
    }

    @Bean
    public ServiceRegistry serviceRegistry() {
        return new ServiceRegistry();
    }
}
