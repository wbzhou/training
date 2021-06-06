package csdn;

import lombok.Data;

/**
 * @author zhouwenbin
 * @version 1.0
 * @date 2021/5/17
 */
public class TestDD {

    public ListNode findFirst(ListNode headA,ListNode headB){

        ListNode a=headA;
        ListNode b=headB;
        while(a!=b){
            a=a==null ? headB : a.next;
            b=b==null ? headA : b.next;
        }
        return a;

    }

    @Data
    public static class ListNode{
        private ListNode next;
        private int val;

    }
}
