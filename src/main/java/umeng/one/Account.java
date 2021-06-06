package umeng.one;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhouwenbin
 * @version 1.0
 * @date 2021/4/7
 */
@Data
@AllArgsConstructor
public class Account {
    /**
     * 主键
     */
    private int id;
    /**
     * 余额
     */
    private double balance;

    /**
     * 是否可用
     */
    private boolean useFlag;

    public synchronized void canUse(){

        while (!useFlag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.useFlag = false;
    }

    public synchronized void setCanUse(){
        useFlag=true;
        notifyAll();
    }
}
