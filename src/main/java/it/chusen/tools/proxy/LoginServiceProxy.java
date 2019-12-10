package it.chusen.tools.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chusen
 * @date 2019/12/10 17:57
 */
public class LoginServiceProxy implements InvocationHandler {

    private Logger logger = LoggerFactory.getLogger(LoginServiceProxy.class);
    private Class<?> clazz;

    public LoginServiceProxy(Class<?> clazz) {
        this.clazz = clazz;
    }

    public <T> T getProxyObject() {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("login".equals(method.getName())) {
            logger.info("方法名："+method.getName()+", 参数: " + args[0] +", " + args[1]);
            LoginServiceImpl loginService = new LoginServiceImpl();
            return loginService.login((String) args[0],(String)args[1]);
        } else {
            logger.error("其它方法!");
        }
        return null;
    }
}
