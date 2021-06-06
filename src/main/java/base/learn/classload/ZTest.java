package base.learn.classload;

import java.math.BigDecimal;
import java.util.*;

/**
@author :zhouwenbin
@time   :2017年12月7日
@comment:
输出

父类的静态方法2
父类静态初始化块
父类类的静态方法
类中static 方法在第一次调用时加载，类中static成员按在类中出现的顺序加载。当调用静态方法2时输出

父类的静态方法2
父类静态初始化块
父类的静态方法2
注释掉Parent.parentStaticMethod();

去掉注释Child child = new Child();



父类的静态方法2
父类静态初始化块
子类静态初始化块
父类非静态初始化块
父类的构造方法
子类非静态初始化块
子类的构造方法
复制代码

父静子静父非静初父构造了子非静初 子构造

父静态块--》子静--》--》父非静初始块 --》父构造--》子非静初始块--》子构造--》
**/
public class ZTest
{
   
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
//        Parent.parentStaticMethod();
//        Parent.parentStaticMethod();
//        Child child = new Child();
//        Child.childStaticMethod();
        ZTest test= new ZTest();
        List tmpList=new ArrayList<>();
//        String tmStr="111";
//        String[] arr="11".split("");
//        System.out.println(tmStr.length());
//        System.out.println(arr.length);
//
//        HashMap map=new HashMap();
//        map.put(1,1);
//        map.put(1,1);
//        System.out.println(map.size());
//        map.put(1,2);
//        System.out.println(map.size());

        LinkedList<Integer> linkedList=new LinkedList<>();

//        tmpList.size()


//        System.out.println("最后:"+left);

//        test.exp();

//
    }


//    public String exp(){
//        try{
//            throw new Exception("  ");
//        }catch(Exception e){
//            log.info("xxx你好");
//            throw new Exception("  ");
//        }finally{
//            log.info("xxx我好");
//            return "false";
//        }
//
////		return "true";
//    }


}
