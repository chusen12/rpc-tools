package it.chusen.tools.client.config;

import it.chusen.tools.client.process.RpcProxyBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chusen
 * @date 2019/12/10 17:16
 */
@Configuration
public class RpcClientConfig {


    @Bean
    public RpcProxyBeanPostProcessor serviceReferenceHandler() {
        return new RpcProxyBeanPostProcessor();
    }

}
