package it.chusen.tools.server;

/**
 * RPC的服务接口
 * @author chusen
 * @date 2019/12/10 15:05
 */
public interface RpcServer {
    /**
     * 启动服务
     */
    void start();

    /**
     * 停止服务
     */
    void stop();
}
