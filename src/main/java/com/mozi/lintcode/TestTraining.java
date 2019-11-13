package com.mozi.lintcode;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :zhouwenbin
 * @time   :19/11/5
 * @comment:
 **/
public class TestTraining {

	Semaphore sema4h = new Semaphore(2);
	Semaphore sema4o = new Semaphore(1);
	AtomicInteger hcount = new AtomicInteger(0);

	public static void main(String[] args) {

		String str="{ \"status\": 0, \"org\": \"SHA\", \"dst\": \"SYD\", \"date\": \"" +
				"\", \"rdate\": \"\", \"qid\": \"1573116726031329\", \"bid\": \"\", \"cost\": 7, \"total\": 1, \"done\": true, \"progress_bar\": true, \"cabin\": \"Y\", \"passsum\": \"1-0\", \"gouwuchetitle\": \"智选购票 尽在购物车\", \"gouwuchecontent\": \"管家AI帮您实时监测价格波动，帮您发现低价\", \"platformprice\": \"0,0,0\", \"datas\": [ { \"flight_info\": { \"go\": [ { \"fn\": \"QF130$PVG$SYD\", \"accode\": \"QF\", \"alliance\": \"寰宇一家\", \"lcc\": false, \"da\": \"PVG\", \"aa\": \"SYD\", \"src\": \"dt\", \"departuretime\": 1580385900000, \"arrivingtime\": 1580434800000, \"timesrc\": \"qunar-api-custom\", \"proximaterate\": \"\", \"dterminal\": \"T1\", \"aterminal\": \"T1\", \"dcitycode\": \"SHS\", \"acitycode\": \"SYD\", \"optfn\": \"\", \"isshare\": 0, \"wifi\": 0, \"redeye\": \"0\", \"planecode\": \"A330-300\", \"planeyear\": \"\", \"paintingicon\": \"\", \"dtdiff\": 0 } ], \"flightinfoid\": \"v2_0_date{2020-01-30}dst{SYD}dtime{1580385900:48900}fn{QF130$PVG$SYD}org{SHA}cabin{Y}passsum{1-0}\", \"productid\": \"v2_0_date{2020-01-30}dst{SYD}fn{QF130$PVG$SYD}org{SHA}_Y\", \"platformprice\": \"0,0,0\" }, \"src_price\": [ { \"price\": 5726, \"tax\": 980, \"childprice\": 5669, \"childtax\": 980, \"oriprice\": 5669, \"addtozhixiao\": false, \"usefd\": false, \"caigouprice\": 5669, \"childcaigouprice\": 5669, \"pubprice\": -1, \"childpubprice\": -1, \"jsprice\": -1, \"childjsprice\": -1, \"ydfaceprice\": 5669, \"childydfaceprice\": 5669, \"seatleft\": \"A\", \"cabin\": \"Y\", \"pid\": \"\", \"passengerlimit\": \"\", \"share\": false, \"score\": 0, \"deplysrc\": \"\", \"src\": \"qunar-api-custom\", \"analyseSourceEntry\": \"ticketmain\", \"packageid\": 0, \"duocheng_price_type\": 2, \"priceid\": \"v4_0_1{Y}2{Y}3{hbgj}4{L}5{1}7{1}8{125}\", \"cabin_type\": 0, \"seat\": [ { \"fn\": \"QF130$PVG$SYD\", \"bct\": \"Y\", \"sct\": \"\", \"ct\": \"L\", \"extraparameters\": { } } ], \"updatetime\": \"2019-11-07 16:52:10\", \"expired\": false, \"pricetag\": 0, \"apply\": 0, \"hasdetail\": true, \"remark\": \"\", \"srcurl\": \"\", \"newproductid\": \"\", \"ycode\": \"\", \"rule\": \"儿童退改签规定同成人\\n\", \"textrule\": \"\", \"endorsementcondition\": \"\", \"refundmarkup\": \"\", \"changemarkup\": \"\", \"refundcond\": \"\", \"changecond\": \"\", \"usedchangecond\": \"\", \"usedrefundcond\": \"\", \"luggagecond\": \"\", \"refundcondition\": [ { \"title\": \"全程未使用\", \"rule\": [ { \"title\": \"\", \"rule\": [ { \"title\": \"起飞前\", \"desc\": \"不允许\" }, { \"title\": \"起飞后\", \"desc\": \"不允许\" } ] } ] }, { \"title\": \"部分使用\", \"rule\": [ ] } ], \"reroutecondition\": [ { \"title\": \"全程未使用\", \"rule\": [ { \"title\": \"\", \"rule\": [ { \"title\": \"起飞前\", \"desc\": \"不允许\" }, { \"title\": \"起飞后\", \"desc\": \"不允许\" } ] } ] }, { \"title\": \"部分使用\", \"rule\": [ ] } ], \"callrule\": 0, \"luggage\": \"\", \"duoren_price\": 0, \"pricetype\": 1, \"producttype\": \"C2P\", \"tickettime\": \"48.0\", \"minage\": \"0\", \"maxage\": \"0\", \"routetickettype\": \"3\", \"platingcarrier\": \"\", \"vipgrade\": 0, \"extra\": { \"packagetype\": \"0\" }, \"grade\": \"\", \"phone\": \"\", \"jumpurl\": \"\", \"cookie\": \"\", \"hide\": 0, \"sequenceid\": 0, \"orderflag\": 1 } ], \"expired\": false } ] }";


		String verify="123";
		System.out.println(verify.compareTo("20163"));
		System.out.println("20163".compareTo("20163"));
		System.out.println("8888812".compareTo("20163"));
		System.out.println(verify.indexOf("20163"));
		System.out.println("8888812".indexOf("20163"));
		System.out.println("20163".indexOf("20163"));

		;
		JSONObject json=JSONObject.parseObject(str);
		JSONArray datas = json.getJSONArray("datas");
		for(int i=0;i<datas.size();i++){
			JSONObject data = datas.getJSONObject(i);
			JSONArray gos = data.getJSONObject("flight_info").getJSONArray("go");
			JSONArray backs = data.getJSONObject("flight_info").getJSONArray("back");

			for(int g=0;g<gos.size();g++){

				JSONObject gOne = gos.getJSONObject(g);
				if(gOne.getString("fn").equals("QF130$PVG$SYD"))
					gOne.put("fn","周文");

			}


		}

		System.out.println(json);


	}

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
		try {
			sema4h.acquire();
			releaseHydrogen.run();
			if (hcount.incrementAndGet() % 2==0)
				sema4o.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		// releaseOxygen.run() outputs "O". Do not change or remove this line.
		try {
			sema4o.acquire();
			releaseOxygen.run();
			sema4h.release(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static boolean isValid(String s) {
//		System.out.println("得到的值:"+isValid("{[]}"));

//		初始化栈 S。
//		一次处理表达式的每个括号。
//		如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
//		如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
//		如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
//
//		作者：LeetCode
//		链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// If the current character is a closing bracket.
			if (map.containsKey(c)) {
				// Get the top element of the stack. If the stack is empty, set a dummy value of '#'
				char topElement = stack.empty() ? '#' : stack.pop();

				// If the mapping for this bracket doesn't match the stack's top element, return false.
				if (topElement != map.get(c)) {
					return false;
				}
			} else {
				// If it was an opening bracket, push to the stack.
				stack.push(c);
			}
		}

		// If the stack still contains elements, then it is an invalid expression.
		return stack.isEmpty();

	}



	public static String reverse2(String str) {
//		String str="A man, a plan, a canal: Panama";
		char[] chars = str.toCharArray();
		String reverse = "";
		for (int i = chars.length - 1; i >= 0; i--) {
			reverse += chars[i];
		}
		return reverse;
	}

	public  static  int geNum(int n){
		n+=1;
		try {
			int i=n/0;
		} catch (Exception e) {
			n++;
		}
		n++;
		return ++n;
	}


	public static Node reverse(Node curNode){
		Node preNode=null;
		while (curNode.next!=null){
			Node nextNode=curNode.next;
			curNode.next=preNode;
			preNode=curNode;
			curNode=nextNode;
		}
		return preNode;
	}

}
