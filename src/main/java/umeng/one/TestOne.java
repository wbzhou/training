package umeng.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouwenbin
 * @version 1.0
 * @date 2021/4/7
 */
public class TestOne {
    public static void main(String[] args) {

        List<Account> accountList = new ArrayList<>();
        //有二十个账户。每个账户初始余额10000元。
        for (int i = 0; i < 20; i++) {
            Account oneAccount = new Account(i, 10000, true);
            accountList.add(oneAccount);
        }
        //有十个转账线程，对二十个账户中的两个随机选取账户进行转账，转账额度100以内正整数随机数
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future> futureList=new ArrayList<>();
        try {
            for (int i = 0; i < 10; i++) {
                Future submit = pool.submit(new TransferMoneyThread(accountList));
                futureList.add(submit);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }

        double total = 0D;
        // 最后请打印出二十个账户的余额。 这里可能得等所以的转账线程执行完后再统计值
        for (Account account : accountList) {
            System.out.println("账户:" + account.getId() + " ，余额:" + account.getBalance());
            total += account.getBalance();
        }
        System.out.println("最后总total:" + total);

        //future的获取方法
//        for(Future future : futureList){
//            if (future.isDone() && !future.isCancelled()) {
//            } else {
//                try {
//                    Thread.sleep(1000);// 避免CPU高速运转，这里休息1秒
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


    }
}
