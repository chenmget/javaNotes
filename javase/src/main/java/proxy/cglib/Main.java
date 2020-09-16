package proxy.cglib;

import proxy.service.IUserService;
import proxy.service.UserService;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-16 18:07
 **/
public class Main {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
       IUserService star = (IUserService)proxy.CreatProxyedObj(UserService.class);
        System.out.println(star.queryUserNameById("chenm"));
    }
}
