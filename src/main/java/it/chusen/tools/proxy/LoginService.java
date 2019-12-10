package it.chusen.tools.proxy;

/**
 * @author chusen
 * @date 2019/12/10 17:56
 */
public interface LoginService {
    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @return
     */
    String login(String userName, String passWord);
}
