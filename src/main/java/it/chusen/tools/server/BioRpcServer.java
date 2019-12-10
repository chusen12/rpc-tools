package it.chusen.tools.server;

import it.chusen.tools.request.RpcRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author chusen
 * @date 2019/12/10 15:21
 */
public class BioRpcServer implements RpcServer {
    private static final Logger logger = LoggerFactory.getLogger(BioRpcServer.class);
    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private int port = 10000;

    private volatile boolean shutdown = false;

    public BioRpcServer(int port) {
        this.port = port;
    }
    public BioRpcServer() {}
    @Override
    public void start() {
        try {
            ServerSocket server = new ServerSocket(this.port);
            while (!this.shutdown) {
                final Socket client = server.accept();
                executor.execute(()-> {
                    try ( ObjectInputStream in = new ObjectInputStream(client.getInputStream());
                          ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream())){
                        RpcRequest request = (RpcRequest) in.readObject();
                        logger.info("接受请求, {}{}{}",request.getClassName(),request.getMethodName(),request.getParameterTypes());
                        out.writeObject(RequestHandler.handleRequest(request));
                    } catch (Exception e) {
                        logger.error("客户端链接异常");
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    @PreDestroy
    public void stop() {
        this.shutdown = true;
        logger.info("服务即将停止");
    }


    @PostConstruct
    public void init() {
        executor.submit(this::start);
    }
}
