package base.learn.proxy.secondTwo;

import net.sf.cglib.proxy.MethodInterceptor;  
import net.sf.cglib.proxy.MethodProxy;  
  
import java.lang.reflect.Method; 
/**
@author :zhouwenbin
@time   :2016-12-3
@comment:
 **/
public class CglibProxy implements MethodInterceptor {  
    @Override  
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {  
        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");  
        System.out.println(method.getName());  
        Object o1 = methodProxy.invokeSuper(o, args);  
        System.out.println("++++++after调用的 " + methodProxy.getSuperName() + "++++++");  
        return o1;  
    }  
} 
