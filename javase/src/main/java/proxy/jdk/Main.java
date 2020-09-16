package proxy.jdk;

import proxy.service.IUserService;
import proxy.service.UserService;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-16 17:07
 **/
public class Main {
    public static void main(String[] args) {
        ProxyFactory proxy = new ProxyFactory();
        proxy.setTarget(new UserService());
        IUserService star = (IUserService) proxy.CreatProxyedObj();
        System.out.println(star.queryUserNameById("chenm"));
    }
}
