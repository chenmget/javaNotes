package collection;

import java.util.HashSet;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-11-25 14:50
 **/
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        User u1 = new User();
        User u2 = new User();
        u1.setUserId("1");
        u1.setUserName("张三");
        u2.setUserId("1");
        u2.setUserName("李四");
        hs.add(u1);
        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());
        System.out.println( hs.contains(u2));


    }



}

class  User{
    private String userId;
    private String userName;

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User)) {
            return false;
        }
        User u = (User) obj;
        if (u.userId.equals(this.userId)) {
            return true;
        } else {
            return false;
        }

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
