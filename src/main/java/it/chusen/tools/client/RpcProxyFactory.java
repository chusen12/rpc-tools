package it.chusen.tools.client;

import it.chusen.tools.response.RpcResponse;
import it.chusen.tools.request.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chusen
 * @date 2019/12/10 15:40
 */
public class RpcProxyFactory<T> implements InvocationHandler {

    private static final Logger logger = LoggerFactory.getLogger(RpcProxyFactory.class);
    private Class<T> clazz;

    public RpcProxyFactory(Class<T> clazz) {
        this.clazz = clazz;
    }


    public T getProxyObject() {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class == method.getDeclaringClass()) {
            String name = method.getName();
            // 处理Object中的方法
            if ("equals".equals(name)) {
                return proxy == args[0];
            } else if ("hashCode".equals(name)) {
                return System.identityHashCode(proxy);
            } else if ("toString".equals(name)) {
                return proxy.getClass().getName() + "@" +
                        Integer.toHexString(System.identityHashCode(proxy)) +
                        ", with InvocationHandler " + this;
            } else {
                throw new IllegalStateException(String.valueOf(method));
            }
        }
        RpcRequest request = new RpcRequest();
        request.setClassName(clazz.getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        request.setParameterTypes(method.getParameterTypes());

        try {
            RpcClient client = new BioRpcClient("127.0.0.1", 10000);
            RpcResponse rpcResponse = client.sendRequest(request);
            if (rpcResponse.getStatus() == 1) {
                logger.info("调用远程服务成功");
                return rpcResponse.getData();
            }
        } catch (Exception e) {
            logger.error("远程调用异常", e);
            throw new RuntimeException(e);
        }
        return null;
    }
}
