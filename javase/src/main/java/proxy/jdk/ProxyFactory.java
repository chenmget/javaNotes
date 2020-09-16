package proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-16 16:35
 **/
public class ProxyFactory implements InvocationHandler {

    private Object target;

    public void setTarget(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我被JDKProxy代理了");
        return method.invoke(target,args);
    }

    public Object CreatProxyedObj()
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

}
