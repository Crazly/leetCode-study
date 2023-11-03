package com.study.example.leetcodestudy.test.study04;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * 封装的Http
 * 
 * @author lilin
 *
 */
public class HttpUtil {
	private final static String Key_Data = "data";

	private final static String Key_Data_List = "dataList";

	private final static String Key_Cookies = "cookies";

	private static final String USER_AGENT = "Mozilla/5.0";

	private final static String Header_Set_Cookie = "set-cookie";

	public static final String DefaultContentType = "application/json";

	private static final String HTTP = "http";
	private static final String HTTPS = "https";
	private static SSLConnectionSocketFactory sslsf = null;
	private static PoolingHttpClientConnectionManager cm = null;
	private static SSLContextBuilder builder = null;
	static {
		try {
			builder = new SSLContextBuilder();
			// 全部信任 不做身份鉴定
			builder.loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					return true;
				}
			});
			sslsf = new SSLConnectionSocketFactory(builder.build(),
					new String[] { "SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2" }, null, NoopHostnameVerifier.INSTANCE);
			Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register(HTTP, new PlainConnectionSocketFactory()).register(HTTPS, sslsf).build();
			cm = new PoolingHttpClientConnectionManager(registry);
			cm.setMaxTotal(200);// max connection
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static CloseableHttpClient getCloseableHttpClient(String url) throws Exception {
		if (StringUtils.isEmpty(url) || url.toLowerCase().startsWith("http:")) {
			HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
			return closeableHttpClient;
		}

		// Registry<ConnectionSocketFactory> socketFactoryRegistry =
		// RegistryBuilder.<ConnectionSocketFactory>create()
		// .register("http", PlainConnectionSocketFactory.INSTANCE).register("https",
		// trustAllHttpsCertificates())
		// .build();
		// 创建ConnectionManager，添加Connection配置信息
		// PoolingHttpClientConnectionManager connectionManager = new
		// PoolingHttpClientConnectionManager(
		// socketFactoryRegistry);
		// CloseableHttpClient httpClient =
		// HttpClients.custom().setConnectionManager(connectionManager).build();

		if (url.toLowerCase().startsWith("https:")) {
			// CloseableHttpClient httpClient =
			// HttpClients.custom().setSSLSocketFactory(sslsf).setConnectionManager(cm)
			// .setConnectionManagerShared(true).build();
			// return httpClient;
			return getSslHttpClient();
		}
		return null;
	}

	public static CloseableHttpClient getSslHttpClient() throws Exception{
		//采用绕过验证的方式处理https请求  
        SSLContext sslcontext = createIgnoreVerifySSL();  
        
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE)//.register("https", trustAllHttpsCertificates())
				.register("https", new SSLConnectionSocketFactory(sslcontext))
				.build();
		// 创建ConnectionManager，添加Connection配置信息
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
				socketFactoryRegistry);
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
		return httpClient;
	}

	public static String getDataByGet(String url) throws Exception {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpGet httpGet = new HttpGet(url);

		HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
	}

	public static JSONObject getJsonDataByGet(String url) throws Exception {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpGet httpGet = new HttpGet(url);

		HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		JSONObject resObject = new JSONObject();
		if (entity != null) {
			String resJsonStr = EntityUtils.toString(entity, "UTF-8");
			JSONObject dataObject = JSON.parseObject(resJsonStr);
			resObject.put(Key_Data, dataObject);
		}
		Map<String, String> cookies = getCookies(httpResponse);
		resObject.put(Key_Cookies, cookies);
		return resObject;
	}

	public static JSONObject getJsonDataBodyByGet(String url) throws Exception {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setProtocolVersion(HttpVersion.HTTP_1_0);

		HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		String resJsonStr = EntityUtils.toString(entity, "UTF-8");
		return JSON.parseObject(resJsonStr);
	}

	public static JSONObject getJsonDataByPost(String url, Map<String, String> headers, Map<String, String> params)
			throws Exception {
		CloseableHttpClient closeableHttpClient = getCloseableHttpClient(url);

		// 设置头
		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		post.setHeader("Content-Type", DefaultContentType);
		if (headers != null) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				post.setHeader(entry.getKey(), entry.getValue());
			}
		}

		// 设置参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		if (null != params) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		if (list.size() > 0) {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
			post.setEntity(entity);
		}

		HttpResponse response = closeableHttpClient.execute(post);
		int status = response.getStatusLine().getStatusCode();

		JSONObject resObject = new JSONObject();
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String resJsonStr = EntityUtils.toString(entity, "UTF-8");
			if (!StringUtils.isEmpty(resJsonStr) && resJsonStr.startsWith("[")) {// 数组
				JSONArray dataObject = JSONArray.parseArray(resJsonStr);
				resObject.put(Key_Data_List, dataObject);
			} else {
				JSONObject dataObject = JSON.parseObject(resJsonStr);
				resObject.put(Key_Data, dataObject);
			}
		}
		if (status != 200) {
			throw new Exception("post is failure, response-code:" + status + " , data:" + resObject);
		}
		Map<String, String> cookies = getCookies(response);
		resObject.put(Key_Cookies, cookies);
		return resObject;
	}

	public static JSONObject getJsonDataByPost(String url, Map<String, String> headers, JSON postBodyJson)
			throws Exception {
		CloseableHttpClient closeableHttpClient = getCloseableHttpClient(url);

		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		post.setHeader("Content-Type", DefaultContentType);
		if (headers != null) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				post.setHeader(entry.getKey(), entry.getValue());
			}
		}
		StringEntity se = new StringEntity(postBodyJson.toJSONString(), "UTF-8");
		post.setEntity(se);
		HttpResponse response = closeableHttpClient.execute(post);
		int status = response.getStatusLine().getStatusCode();

		JSONObject resObject = new JSONObject();
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String resJsonStr = EntityUtils.toString(entity, "UTF-8");
			if (!StringUtils.isEmpty(resJsonStr) && resJsonStr.startsWith("[")) {// 数组
				JSONArray dataObject = JSONArray.parseArray(resJsonStr);
				resObject.put(Key_Data_List, dataObject);
			} else {
				JSONObject dataObject = JSON.parseObject(resJsonStr);
				resObject.put(Key_Data, dataObject);
			}
		}
		if (status != 200) {
			throw new Exception("post is failure, response-code:" + status + " , data:" + resObject);
		}
		Map<String, String> cookies = getCookies(response);
		resObject.put(Key_Cookies, cookies);
		return resObject;
	}

	public static JSONObject getJsonDataByPost(String url, JSON postBodyJson) throws Exception {
		return getJsonDataByPost(url, null, postBodyJson);
	}

	public static JSONObject getJsonDataByPost(String url, String dataJsonStr) throws Exception {
		if (StringUtils.isEmpty(url) || StringUtils.isEmpty(dataJsonStr)) {
			throw new Exception("[httpUtil.postJson]:url is null or dataJsonStr is null");
		}
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

		HttpPost post = new HttpPost(url);
		post.setHeader("User-Agent", USER_AGENT);
		// StringEntity se = new StringEntity(dataJsonStr, "UTF-8");
		StringEntity se = new StringEntity(dataJsonStr, ContentType.create("application/json", Consts.UTF_8));
		se.setChunked(true);

		post.setEntity(se);
		HttpResponse response = closeableHttpClient.execute(post);
		int status = response.getStatusLine().getStatusCode();
		JSONObject resObject = new JSONObject();
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			String resJsonStr = EntityUtils.toString(entity, "UTF-8");
			JSONObject dataObject = JSON.parseObject(resJsonStr);
			resObject.put(Key_Data, dataObject);
		}
		if (status != 200) {
			throw new Exception("post is failure, " + resObject.get(Key_Data).toString());
		}
		Map<String, String> cookies = getCookies(response);
		resObject.put(Key_Cookies, cookies);
		return resObject;
	}

	public static JSONObject getJsonDataByPost(String url, Map<String, String> data) throws Exception {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpPost httpPost = new HttpPost(url);

		// 设置参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		if (null != data) {
			for (Map.Entry<String, String> entry : data.entrySet()) {
				list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		if (list.size() > 0) {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
			httpPost.setEntity(entity);
		}
		JSONObject resObject = new JSONObject();
		HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
		HttpEntity entity = httpResponse.getEntity();
		if (entity != null) {
			String resJsonStr = EntityUtils.toString(entity, "UTF-8");
			JSONObject dataObject = JSON.parseObject(resJsonStr);
			resObject.put(Key_Data, dataObject);
		}

		Map<String, String> cookies = getCookies(httpResponse);
		resObject.put(Key_Cookies, cookies);
		return resObject;
	}

	// public static JSONObject getJsonDataByPostBody(String urlPath, String json)
	// throws Exception {
	// // Configure and open a connection to the site you will send the request
	// URL url = new URL(urlPath);
	// HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	// // 设置doOutput属性为true表示将使用此urlConnection写入数据
	// urlConnection.setDoOutput(true);
	// // 定义待写入数据的内容类型
	// urlConnection.setRequestProperty("Content-Type", "application/json");
	// // 得到请求的输出流对象
	// OutputStreamWriter out = new
	// OutputStreamWriter(urlConnection.getOutputStream());
	// // 把数据写入请求的Body
	// out.write(json);
	// out.flush();
	// out.close();
	//
	// // 从服务器读取响应
	// InputStream inputStream = urlConnection.getInputStream();
	// String body = IOUtils.toString(inputStream, "UTF-8");
	// if (urlConnection.getResponseCode() != 200) {
	// throw new Exception("post is failure");
	// }
	// JSONObject resObject = JSONObject.parseObject(body);
	// return resObject;
	// }

	@SuppressWarnings("unchecked")
	private static Map<String, String> getCookies(HttpResponse httpResponse) throws Exception {
		if (null == httpResponse) {
			return Collections.EMPTY_MAP;
		}
		Map<String, String> map = new HashMap<String, String>();
		Header[] headerArray = httpResponse.getAllHeaders();
		if (null == headerArray) {
			return Collections.EMPTY_MAP;
		}
		String cookieStr = null;
		for (Header header : headerArray) {
			if (Header_Set_Cookie.equals(header.getName().toLowerCase())) {
				if (StringUtils.isEmpty(header.getValue())) {
					return Collections.EMPTY_MAP;
				}
				cookieStr = header.getValue();
			}
		}
		if (StringUtils.isEmpty(cookieStr)) {
			return Collections.EMPTY_MAP;
		}
		String[] cookiesArray = cookieStr.split(";");
		for (String cookieItem : cookiesArray) {
			String[] itemArray = cookieItem.split("=");
			if (null == itemArray || 2 != itemArray.length || StringUtils.isEmpty(itemArray[0])) {
				continue;
			}
			String key = StringUtils.trimWhitespace(itemArray[0]);
			String value = StringUtils.trimWhitespace(itemArray[1]);
			map.put(key, value);
		}
		return map;
	}

	public static String createUrl(String host, String path) throws Exception {
		if (StringUtils.isEmpty(host)) {
			throw new Exception("[HttpUtil]: host is empty.");
		}
		host = StringUtils.trimWhitespace(host);
		StringBuilder builder = new StringBuilder();
		if (!host.toLowerCase().startsWith("http://")) {
			builder.append("http://");
		}
		builder.append(host);

		if (!StringUtils.isEmpty(path)) {
			path = StringUtils.trimWhitespace(path);
			if (!path.startsWith("/") && !host.endsWith("/")) {
				builder.append("/");
			}
			builder.append(path);
		}
		// jointParams(builder, params);
		return builder.toString();
	}

	public static String createUrl(String url) throws Exception {
		if (StringUtils.isEmpty(url)) {
			throw new Exception("[HttpUtil]: url is empty.");
		}
		url = StringUtils.trimWhitespace(url);
		StringBuilder builder = new StringBuilder();
		if (!url.toLowerCase().startsWith("http://")) {
			builder.append("http://");
		}
		builder.append(url);
		// jointParams(builder, params);
		return builder.toString();
	}

	public static String createUrl(String url, Map<String, String> params) throws Exception {
		if (StringUtils.isEmpty(url)) {
			throw new Exception("[HttpUtil]: url is empty.");
		}
		url = StringUtils.trimWhitespace(url);
		StringBuilder builder = new StringBuilder();
		if (!url.toLowerCase().startsWith("http://")) {
			builder.append("http://");
		}
		builder.append(url);
		jointParams(builder, params);
		return builder.toString();
	}

	public static String createUrl(String host, String path, Map<String, String> params) throws Exception {
		if (StringUtils.isEmpty(host)) {
			throw new Exception("[HttpUtil]: host is empty.");
		}
		host = StringUtils.trimWhitespace(host);
		StringBuilder builder = new StringBuilder();
		if (!host.toLowerCase().startsWith("http://")) {
			builder.append("http://");
		}
		builder.append(host);

		if (!StringUtils.isEmpty(path)) {
			path = StringUtils.trimWhitespace(path);
			if (!path.startsWith("/") && !host.endsWith("/")) {
				builder.append("/");
			}
			builder.append(path);
		}
		jointParams(builder, params);
		return builder.toString();
	}

	private static void jointParams(StringBuilder builder, Map<String, String> params) throws Exception {
		if (null == params) {
			return;
		}
		builder.append("?");
		boolean isFirst = true;
		for (Map.Entry<String, String> kv : params.entrySet()) {
			if (!isFirst) {
				builder.append("&");
			} else {
				isFirst = false;
			}
			builder.append(kv.getKey());
			builder.append("=");
			builder.append(kv.getValue());
		}
	}

	private static void jointParams(StringBuilder builder) throws Exception {
		builder.append("?");
		boolean isFirst = true;
		// for (UrlParamKV kv : params) {
		// if (!isFirst) {
		// builder.append("&");
		// } else {
		// isFirst = false;
		// }
		// builder.append(kv.getKey());
		// builder.append("=");
		// builder.append(kv.getValue());
		// }
	}

	private static SSLConnectionSocketFactory trustAllHttpsCertificates() {
		SSLConnectionSocketFactory socketFactory = null;
		TrustManager[] trustAllCerts = new TrustManager[1];
		TrustManager tm = null; // new SSLTrustManager();
		trustAllCerts[0] = tm;
		SSLContext sc = null;
		try {
			sc = SSLContext.getInstance("TLS");// sc = SSLContext.getInstance("TLS")
			sc.init(null, trustAllCerts, null);
			socketFactory = new SSLConnectionSocketFactory(sc, NoopHostnameVerifier.INSTANCE);
			// HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		}
		return socketFactory;
	}

	/**
	 * 绕过验证
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext sc = SSLContext.getInstance("SSLv3");

		// 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate,
                                           String paramString) throws CertificateException {
			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
		};

		sc.init(null, new TrustManager[] { trustManager }, null);
		return sc;
	}

	public static void main(String[] args) throws Exception {
		JSONObject bodyJson = new JSONObject(); 
		bodyJson.put("project", "nzt");
		bodyJson.put("env", "prod");
		bodyJson.put("service", "orderService");  
		JSONObject json = HttpUtil.getJsonDataByPost("http://autopilot.bnq.com.cn/config/getall", bodyJson);
		System.out.println(json);
	}
	
	
	public static InputStream downloadByUrl(String url) throws Exception{
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
		InputStream is = httpResponse.getEntity().getContent();
		return is;
	}

}
