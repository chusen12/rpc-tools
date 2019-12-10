package it.chusen.tools.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chusen
 * @date 2019/12/10 18:05
 */
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Override
    public String login(String userName, String passWord) {
        logger.debug("我只让动态调用");
        if ("chusen".equals(userName) && "123".equals(passWord)) {
            return "登录成功!";
        }
        return "登录失败！";
    }
}
