package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: javaNotes
 * @description:
 * @author: cm
 * @create: 2020-09-16 17:58
 **/
public class CglibProxy implements MethodInterceptor {

    // 根据一个类型产生代理类，此方法不要求一定放在MethodInterceptor中
    public Object CreatProxyedObj(Class<?> clazz)
    {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(this);

        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 这里增强
        System.out.println("cglib 增强");
        return methodProxy.invokeSuper(o, objects);
    }
}
