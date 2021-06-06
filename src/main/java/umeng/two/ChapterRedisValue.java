package umeng.two;

import lombok.Data;

/**
 * @author zhouwenbin
 * @version 1.0
 * @date 2021/4/7
 * 以”chapter_”+chapterId+bookId为key的redis中value对象
 */
@Data
public class ChapterRedisValue {

    /**
     * 字数
     */
    private long wordNumber;
    /**
     * 正在阅读用户数量
     */
    private long readUserAmount;
}
