package umeng.two;

import lombok.Data;

import java.util.List;

/**
 * @author zhouwenbin
 * @version 1.0
 * @date 2021/4/7
 */
@Data
public class Book {
    /**
     * 书id
     */
    private int bookId;

    /**
     * 书章节
     */
    private List<Chapter> chapters;
}
