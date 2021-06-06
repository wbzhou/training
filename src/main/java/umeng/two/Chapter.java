package umeng.two;
import lombok.Data;

/**
 * @author zhouwenbin
 * @version 1.0
 * @date 2021/4/7
 */
@Data
public class Chapter {

    /**
     * 所属的bookId
     */
    private int bookId;

    /**
     * 章节id
     */
    private int chapterId;
}
