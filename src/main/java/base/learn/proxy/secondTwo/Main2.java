package base.learn.proxy.secondTwo;

/**
@author :zhouwenbin
@time   :2016-12-3
@comment:
 **/
public class Main2 {  
    public static void main(String[] args) {  
        CglibProxy cglibProxy = new CglibProxy();  
  
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(UserServiceImpl.class);
//        enhancer.setCallback(cglibProxy);
//
//        UserService o = (UserService)enhancer.create();
//        o.getName(1);
//        o.getAge(1);
    }  
} 
