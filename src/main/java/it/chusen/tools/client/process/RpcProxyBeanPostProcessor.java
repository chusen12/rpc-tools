package it.chusen.tools.client.process;

import it.chusen.tools.client.RpcProxyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chusen
 * @date 2019/12/10 17:08
 */
public class RpcProxyBeanPostProcessor implements BeanPostProcessor {
    private static final Logger logger = LoggerFactory.getLogger(RpcProxyBeanPostProcessor.class);
    private final Map<Class<?>, Object> cache = new HashMap<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        for (Field f : bean.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Class<?> clazz = f.getType();
            Object proxy = null;
            if (cache.containsKey(clazz)) {
                proxy = cache.get(clazz);
            } else {
                proxy = new RpcProxyFactory<>(clazz).getProxyObject();
                cache.put(bean.getClass(), proxy);
            }
            try {
                f.set(bean, proxy);
                logger.info("为{}注入{}", f, proxy);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("属性： " + f + " 注入失败！", e);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
