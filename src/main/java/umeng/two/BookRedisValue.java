package umeng.two;

import lombok.Data;

/**
 * @author zhouwenbin
 * @version 1.0
 * @date 2021/4/7
 * 以“book_”+bookId为key的redis中value对象
 */
@Data
public class BookRedisValue {
    /**
     * 正在阅读用户数量
     */
    private long readUserAmount;
}
