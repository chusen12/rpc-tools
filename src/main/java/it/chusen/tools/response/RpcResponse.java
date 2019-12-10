package it.chusen.tools.response;

import java.io.Serializable;

/**
 * @author chusen
 * @date 2019/12/10 15:01
 */
public class RpcResponse implements Serializable {

    private static final long serialVersionUID = 2L;

    private int status;
    private String error;
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static RpcResponse ok(Object data) {
        return build(1, null, data);
    }

    public static RpcResponse error(String msg) {
        return build(0, msg, null);
    }

    private static RpcResponse build(int status, String error, Object data) {
        RpcResponse response = new RpcResponse();
        response.setStatus(status);
        response.setError(error);
        response.setData(data);
        return response;
    }

}
