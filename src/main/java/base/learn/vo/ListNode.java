package base.learn.vo;

/**
 * @author :zhouwenbin
 * @time   :20/3/12
 * @comment:
 **/
public class ListNode {

	public  ListNode next = null;//下一个结点
	int data;//结点数据
	public ListNode(int data){
		this.data = data;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
