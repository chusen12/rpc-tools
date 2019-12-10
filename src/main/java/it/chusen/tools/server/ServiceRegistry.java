package it.chusen.tools.server;

import it.chusen.tools.anno.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chusen
 * @date 2019/12/10 15:07
 */
public class ServiceRegistry implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ServiceRegistry.class);

    private static final Map<String, Object> registeredServices = new HashMap();

    public static <T> T getService(String className) {
        return (T) registeredServices.get(className);
    }

    /**
     * 服务注册
     *
     * @param interfaceClass
     * @param implClass
     */
    public static void registerService(Class<?> interfaceClass, Class<?> implClass) {
        try {
            registeredServices.put(interfaceClass.getName(), implClass.newInstance());
            logger.info(interfaceClass.getName() + ": 服务注册成功! ");
        } catch (Exception e) {
            logger.error(interfaceClass.getName() + " : 服务注册失败！");
            e.printStackTrace();
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> services = applicationContext.getBeansWithAnnotation(Service.class);
        if (services != null && services.size() > 0) {
            for (Object service : services.values()) {
                String interfaceName = service.getClass().getAnnotation(Service.class).value().getName();
                registeredServices.put(interfaceName, service);
                logger.info("加载服务: {}", interfaceName);
            }
        }
    }
}
