package it.chusen.tools.server;

import com.sun.deploy.util.StringUtils;
import it.chusen.tools.response.RpcResponse;
import it.chusen.tools.request.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author chusen
 * @date 2019/12/10 15:15
 */
public class RequestHandler {

    private static final Logger logger = LoggerFactory.getLogger(RequestHandler.class);


    public static RpcResponse handleRequest(RpcRequest rpcRequest) {
        try {
            Object service = ServiceRegistry.getService(rpcRequest.getClassName());
            if (service != null) {
                Class<?> clazz = service.getClass();
                Method method = clazz.getMethod(rpcRequest.getMethodName(), rpcRequest.getParameterTypes());
                // 执行方法
                Object result = method.invoke(service, rpcRequest.getParameters());
                // 写回结果
                return RpcResponse.ok(result);
            } else {
                logger.error("请求的服务未找到,{},{},{}", rpcRequest.getClassName(), rpcRequest.getMethodName(), StringUtils.join(Arrays.asList(rpcRequest.getParameterTypes()), ", "));
                return RpcResponse.error("未知服务!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("请求处理失败", e);
            return RpcResponse.error(e.getMessage());
        }
    }

}
