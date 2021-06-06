package umeng.one;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author zhouwenbin
 * @version 1.0
 * @date 2021/4/7
 */
public class TransferMoneyThread implements Callable {
    private List<Account> accountList;

    TransferMoneyThread(List<Account> accountList){
        this.accountList=accountList;
    }

    @Override
    public Boolean call() {

        Random random=new Random();
        //每个线程执行100次转账操作
        for (int i = 0; i < 100; i++) {
            int a = random.nextInt(20);
            int b = random.nextInt(20);
            while (b == a) {
                b = random.nextInt(20);
            }
            Account accountOne = accountList.get(a);
            Account accountTwo = accountList.get(b);
            //转账额度100以内正整数随机数。
            int amount= random.nextInt(100);

            //校验转账账户是否可用
            accountOne.canUse();
            accountTwo.canUse();

            //优先从one转amount给two,如果one余额不够，则从two转给one
            synchronized(this){
                if(accountOne.getBalance()>=amount){
                    accountOne.setBalance(accountOne.getBalance()-amount);
                    accountTwo.setBalance(accountTwo.getBalance()+amount);
                }else{
                    accountTwo.setBalance(accountTwo.getBalance()-amount);
                    accountOne.setBalance(accountOne.getBalance()+amount);
                }
            }
            //转账完设置为可用
            accountOne.setCanUse();
            accountTwo.setCanUse();
        }
        return true;

    }
}
