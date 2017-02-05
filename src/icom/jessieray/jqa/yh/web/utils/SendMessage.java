package icom.jessieray.jqa.yh.web.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import net.sf.json.JSONObject;

@Component("sendMessage")
public class SendMessage {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String mobile = "17710171716";
		String tpl_id = "4196";
		String tpl_value = "#code#=1234";
		String url = "http://v.juhe.cn/sms/send?mobile=";// url为请求的api接口地址
		String key = "5d1a8f75f5a65883e3b092757ec00634";// 申请的对应key
		tpl_value = URLEncoder.encode(tpl_value, "utf-8");
		String urlAll = new StringBuffer(url).append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=")
				.append(tpl_value).append("&key=").append(key).toString();
		System.out.println(urlAll);
		String charset = "UTF-8";
		String jsonResult = get(urlAll, charset);// 得到JSON字符串
		JSONObject object = JSONObject.fromObject(jsonResult);// 转化为JSON类
		String code = object.getString("error_code");// 得到错误码
		// 错误码判断
		if (code.equals("0")) {
			// 根据需要取得数据
			System.out.println(object.toString());
		} else {
			System.out.println("error_code:" + code + ",reason:" + object.getString("reason"));
		}
	}

	public String sendMessage(String mobile, String code) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "23320142", "10d7b775d0c5ac07cd0756d1dc13f8d8");
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("易收钱");
		req.setSmsParamString("{\"code\":\""+code+"\",\"product\":\"易收钱\"}");
		req.setRecNum(mobile);
		req.setSmsTemplateCode("SMS_5051203");
		AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);	
		return rsp.getBody();
	}
	
	public int sendMessage(String mobile, String tpl_id, String tpl_value) {
		String url = "http://v.juhe.cn/sms/send?mobile=";// url为请求的api接口地址
		String key = "fe48bdf802cf63c2cd778e5db49dc75b";// 申请的对应key
		try {
			tpl_value = URLEncoder.encode(tpl_value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String urlAll = new StringBuffer(url).append(mobile).append("&tpl_id=").append(tpl_id).append("&tpl_value=")
				.append(tpl_value).append("&key=").append(key).toString();
		System.out.println(urlAll);
		String charset = "UTF-8";
		String jsonResult = get(urlAll, charset);// 得到JSON字符串
		JSONObject object = JSONObject.fromObject(jsonResult);// 转化为JSON类
		String code = object.getString("error_code");// 得到错误码
		// 错误码判断
		if (code.equals("0")) {
			// 根据需要取得数据
			System.out.println(object.toString());
			return 1;
		} else {
			System.out.println("error_code:" + code + ",reason:" + object.getString("reason"));
			return 0;
		}
	}

	/**
	 * 
	 * @param urlAll:请求接口
	 * @param charset:字符编码
	 * @return 返回json结果
	 */
	public static String get(String urlAll, String charset) {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";// 模拟浏览器
		try {
			URL url = new URL(urlAll);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(30000);
			connection.setConnectTimeout(30000);
			connection.setRequestProperty("User-agent", userAgent);
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, charset));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}