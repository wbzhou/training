package base.learn.proxy;


import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
  
/** 
 * 使用cglib动态代理 
 *  
 * @author student 
 * JDK实现动态代理需要实现类通过接口定义业务方法，对于没有接口的类，
 * 如何实现动态代理呢，这就需要CGLib了。CGLib采用了非常底层的字节码技术，
 * 其原理是通过字节码技术为一个类创建子类，并在子类中采用方法拦截的技术拦截所有父类方法的调用，
 * 顺势织入横切逻辑。JDK动态代理与CGLib动态代理均是实现Spring AOP的基础。
 *  
 */  
public class BookFacadeCglib implements MethodInterceptor {  
    private Object target;  
  
    /** 
     * 创建代理对象 
     *  
     * @param target 
     * @return 
     */  
    public Object getInstance(Object target) {  
        this.target = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.target.getClass());  
        // 回调方法  
        enhancer.setCallback(this);  
        // 创建代理对象  
        return enhancer.create();  
    }  
  
    @Override  
    // 回调方法  
    public Object intercept(Object obj, Method method, Object[] args,  
            MethodProxy proxy) throws Throwable {  
        System.out.println("事物开始");  
        proxy.invokeSuper(obj, args);  
        System.out.println("事物结束");  
        return null;  
  
  
    }  
  
}  