package proxy.service;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-16 16:27
 **/
public class UserService implements IUserService {
    @Override
    public String queryUserNameById(String userId) {
        return "hi user "+userId;
    }
}
