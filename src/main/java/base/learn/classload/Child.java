package base.learn.classload;
/**
@author :zhouwenbin
@time   :2017年12月7日
@comment:
**/
public class Child extends Parent
{
    {
        System.out.println("子类非静态初始化块");
    }
    static
    {
        System.out.println("子类静态初始化块");
    }
    public Child()
    {
        System.out.println("子类的构造方法");
    }
    public static int childStaticMethod()
    {
        System.out.println("子静方");
        return 1000;
    }
    @Override
    protected void finalize() throws Throwable
    {
        // TODO Auto-generated method stub
        super.finalize();
        System.out.println("销毁子类");
    }
}