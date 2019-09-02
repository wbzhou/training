package base.learn.classload;
/**
@author :zhouwenbin
@time   :2017年12月7日
@comment:
**/
public class Parent
{
	
	public Parent()
    {
        System.out.println("父类的构造方法");
    }
	
	
    public static int t = parentStaticMethod2();
    
    {
        System.out.println("父类非静态初始化块");
    }
    static
    {
        System.out.println("父类静态初始化块");
    }
    
    
    public static int parentStaticMethod2()
    {
        System.out.println("父类的静态方法第2个");
        return 9;
    }
    
    public static int parentStaticMethod()
    {
        System.out.println("父类类的静态方法");
        return 10;
    }
 
  
    @Override
    protected void finalize() throws Throwable
    {
        // TODO Auto-generated method stub
        super.finalize();
        System.out.println("销毁父类");
    }
    
}
