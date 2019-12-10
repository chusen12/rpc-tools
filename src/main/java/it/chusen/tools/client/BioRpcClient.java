package it.chusen.tools.client;

import it.chusen.tools.request.RpcRequest;
import it.chusen.tools.response.RpcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author chusen
 * @date 2019/12/10 15:35
 */
public class BioRpcClient implements RpcClient {
    private static final Logger logger = LoggerFactory.getLogger(BioRpcClient.class);
    private String host;
    private int port;

    public BioRpcClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public RpcResponse sendRequest(RpcRequest request) throws Exception {
        try(
                Socket socket = new Socket(host, port);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ) {
            logger.info("连接建立成功: {}{}", host, port);
            out.writeObject(request);
            return (RpcResponse) in.readObject();
        }
    }
}
