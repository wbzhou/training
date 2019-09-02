package base.learn.proxy.secondTwo;
/**
@author :zhouwenbin
@time   :2016-12-3
@comment:
 **/


public class UserServiceImpl implements UserService {  
    @Override  
    public String getName(int id) {  
        System.out.println("------getNameHere------");  
        return "Tom";  
    }  
  
    @Override  
    public Integer getAge(int id) {  
        System.out.println("------getAgeHere------");  
        return 10;  
    }  
} 
