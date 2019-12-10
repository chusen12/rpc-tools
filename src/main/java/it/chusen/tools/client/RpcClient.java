package it.chusen.tools.client;

import it.chusen.tools.response.RpcResponse;
import it.chusen.tools.request.RpcRequest;

/**
 * @author chusen
 * @date 2019/12/10 15:34
 */
public interface RpcClient  {


    RpcResponse sendRequest(RpcRequest request) throws Exception;

}
