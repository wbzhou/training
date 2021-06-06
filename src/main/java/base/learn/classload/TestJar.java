package base.learn.classload;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
@author :zhouwenbin
@time   :2017年12月13日
@comment:
如果accessOrder为true的话，则会把访问过的元素放在链表后面，放置顺序是访问的顺序
如果accessOrder为flase的话，则按插入顺序来遍历
**/
public class TestJar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedHashMap<String, Integer> map = new LinkedHashMap<>(16, 0.75f, false);

		String dbStr="1,2,3";
		String audit="4";

		String reqKind="1,2,3,4,5,6";

		HashMap dbKindMap = new HashMap();
		if(StringUtils.isNotBlank(dbStr)){
			for(String id:dbStr.split(",") ){
				dbKindMap.put(id,id);
			}
		}
		HashSet<String> newAuditing=new HashSet<>();
		if(StringUtils.isNotBlank(audit)){
			for(String id:audit.split(",") ){
				newAuditing.add(id);
			}
		}
		for(String id:reqKind.split(",") ){
			if(dbKindMap.get(id)==null){
				newAuditing.add(id);
			}
		}


		System.out.println(newAuditing);
	}


	public static String getRequestWithAuthcode(String url, String authcode,String sign)
	{
		String resp = "";
		GetMethod get = new GetMethod(url);
		// get.addRequestHeader("Authorization",
		// "Basic MTZDMjg4QzA3MTI3MUQ4N0YzQ0I1REQwMUY3RjI4RUI=");
//		get.addRequestHeader("Authorization", authcode);
		get.addRequestHeader("sign", sign);
//		get.addRequestHeader("Content-Type",
//				"application/x-www-form-urlencoded;charset=utf-8");// gbk

		HttpClient httpClient = new HttpClient();
		try
		{
			httpClient.getHttpConnectionManager().getParams()
					.setConnectionTimeout(50000);
			httpClient.getHttpConnectionManager().getParams()
					.setSoTimeout(100000);
			httpClient.executeMethod(get);
			resp = get.getResponseBodyAsString();
			get.releaseConnection();

		}  catch (Exception e)
		{
		} finally
		{
		}
		return resp;

	}


	public static String sendGet(String url, String param)
	{
		String result = "";
		BufferedReader in = null;
		try
		{
			String urlName = url + "?" + param;
			URL realUrl = new URL(urlName);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("sign", "8946b056bc654959882739adee5accff");
			conn.setRequestProperty("connection", "Keep-Alive");
			// 设置超时时间
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			// 建立实际的连接
			conn.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet())
			{
			}
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null)
			{
				result += line;
			}
		} catch (Exception e)
		{
		}
		// 使用finally块来关闭输入流
		finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
			} catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
		return result;
	}

}
