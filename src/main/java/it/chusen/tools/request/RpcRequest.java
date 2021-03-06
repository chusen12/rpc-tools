package it.chusen.tools.request;

import java.io.Serializable;

/**
 * @author chusen
 * @date 2019/12/10 14:59
 */
public class RpcRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private String className;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
