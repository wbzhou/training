package base.learn.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @Description:
 * @author wbzhou
 * @date 2016-1-4 上午10:57:53
 */
public class MyThread extends Thread{

    
     
    
    @Override
    public void run() {
        
        try {
            System.out.println("执行了");
            return;
            //System.out.println("了");
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            
            System.out.println("哈哈");
          //  return;
        }
        

        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyThread myThread =new MyThread();
        myThread.start();
        ExecutorService service=Executors.newFixedThreadPool(2);
        service.submit(myThread);

    }

}
