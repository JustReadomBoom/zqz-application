//package com.zqz.service.utils;
//
//import org.apache.http.util.EntityUtils;
//
///**
// * @Author: ZQZ
// * @Description:
// * @ClassName: HttpUtil2
// * @Date: Created in 8:37 2022/4/28
// */
//public class HttpUtil2 {
//
//
//    package com.cmhb.common.orika;
//
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.security.KeyManagementException;
//import java.security.NoSuchAlgorithmException;
//import java.security.cert.X509Certificate;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.X509TrustManager;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpDelete;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.client.methods.HttpPut;
//import org.apache.http.conn.ClientConnectionManager;
//import org.apache.http.conn.scheme.Scheme;
//import org.apache.http.conn.scheme.SchemeRegistry;
//import org.apache.http.conn.ssl.SSLSocketFactory;
//import org.apache.http.entity.ByteArrayEntity;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.apache.http.util.EntityUtils;
//
//
//        /**
//         * get
//         *
//         * @param host
//         * @param path
//         * @param method
//         * @param headers
//         * @param querys
//         * @return
//         * @throws Exception
//         */
//        public static HttpResponse doGet(String host, String path, String method,
//                                         Map<String, String> headers,
//                                         Map<String, String> querys)
//                throws Exception {
//            HttpClient httpClient = wrapClient(host);
//
//            HttpGet request = new HttpGet(buildUrl(host, path, querys));
//            for (Map.Entry<String, String> e : headers.entrySet()) {
//                request.addHeader(e.getKey(), e.getValue());
//            }
//
//            return httpClient.execute(request);
//        }
//
//        /**
//         * post form
//         *
//         * @param host
//         * @param path
//         * @param method
//         * @param headers
//         * @param querys
//         * @param bodys
//         * @return
//         * @throws Exception
//         */
//        public static HttpResponse doPost(String host, String path, String method,
//                                          Map<String, String> headers,
//                                          Map<String, String> querys,
//                                          Map<String, String> bodys)
//                throws Exception {
//            HttpClient httpClient = wrapClient(host);
//
//            HttpPost request = new HttpPost(buildUrl(host, path, querys));
//            for (Map.Entry<String, String> e : headers.entrySet()) {
//                request.addHeader(e.getKey(), e.getValue());
//            }
//
//            if (bodys != null) {
//                List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
//
//                for (String key : bodys.keySet()) {
//                    nameValuePairList.add(new BasicNameValuePair(key, bodys.get(key)));
//                }
//                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nameValuePairList, "utf-8");
//                formEntity.setContentType("application/x-www-form-urlencoded; charset=UTF-8");
//                request.setEntity(formEntity);
//            }
//
//            return httpClient.execute(request);
//        }
//
//        /**
//         * Post String
//         *
//         * @param host
//         * @param path
//         * @param method
//         * @param headers
//         * @param querys
//         * @param body
//         * @return
//         * @throws Exception
//         */
//        public static HttpResponse doPost(String host, String path, String method,
//                                          Map<String, String> headers,
//                                          Map<String, String> querys,
//                                          String body)
//                throws Exception {
//            HttpClient httpClient = wrapClient(host);
//
//            HttpPost request = new HttpPost(buildUrl(host, path, querys));
//            for (Map.Entry<String, String> e : headers.entrySet()) {
//                request.addHeader(e.getKey(), e.getValue());
//            }
//
//            if (StringUtils.isNotBlank(body)) {
//                request.setEntity(new StringEntity(body, "utf-8"));
//            }
//
//            return httpClient.execute(request);
//        }
//
//        /**
//         * Post stream
//         *
//         * @param host
//         * @param path
//         * @param method
//         * @param headers
//         * @param querys
//         * @param body
//         * @return
//         * @throws Exception
//         */
//        public static HttpResponse doPost(String host, String path, String method,
//                                          Map<String, String> headers,
//                                          Map<String, String> querys,
//                                          byte[] body)
//                throws Exception {
//            HttpClient httpClient = wrapClient(host);
//
//            HttpPost request = new HttpPost(buildUrl(host, path, querys));
//            for (Map.Entry<String, String> e : headers.entrySet()) {
//                request.addHeader(e.getKey(), e.getValue());
//            }
//
//            if (body != null) {
//                request.setEntity(new ByteArrayEntity(body));
//            }
//
//            return httpClient.execute(request);
//        }
//
//        /**
//         * Put String
//         * @param host
//         * @param path
//         * @param method
//         * @param headers
//         * @param querys
//         * @param body
//         * @return
//         * @throws Exception
//         */
//        public static HttpResponse doPut(String host, String path, String method,
//                                         Map<String, String> headers,
//                                         Map<String, String> querys,
//                                         String body)
//                throws Exception {
//            HttpClient httpClient = wrapClient(host);
//
//            HttpPut request = new HttpPut(buildUrl(host, path, querys));
//            for (Map.Entry<String, String> e : headers.entrySet()) {
//                request.addHeader(e.getKey(), e.getValue());
//            }
//
//            if (StringUtils.isNotBlank(body)) {
//                request.setEntity(new StringEntity(body, "utf-8"));
//            }
//
//            return httpClient.execute(request);
//        }
//
//        /**
//         * Put stream
//         * @param host
//         * @param path
//         * @param method
//         * @param headers
//         * @param querys
//         * @param body
//         * @return
//         * @throws Exception
//         */
//        public static HttpResponse doPut(String host, String path, String method,
//                                         Map<String, String> headers,
//                                         Map<String, String> querys,
//                                         byte[] body)
//                throws Exception {
//            HttpClient httpClient = wrapClient(host);
//
//            HttpPut request = new HttpPut(buildUrl(host, path, querys));
//            for (Map.Entry<String, String> e : headers.entrySet()) {
//                request.addHeader(e.getKey(), e.getValue());
//            }
//
//            if (body != null) {
//                request.setEntity(new ByteArrayEntity(body));
//            }
//
//            return httpClient.execute(request);
//        }
//
//        /**
//         * Delete
//         *
//         * @param host
//         * @param path
//         * @param method
//         * @param headers
//         * @param querys
//         * @return
//         * @throws Exception
//         */
//        public static HttpResponse doDelete(String host, String path, String method,
//                                            Map<String, String> headers,
//                                            Map<String, String> querys)
//                throws Exception {
//            HttpClient httpClient = wrapClient(host);
//
//            HttpDelete request = new HttpDelete(buildUrl(host, path, querys));
//            for (Map.Entry<String, String> e : headers.entrySet()) {
//                request.addHeader(e.getKey(), e.getValue());
//            }
//
//            return httpClient.execute(request);
//        }
//
//        private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
//            StringBuilder sbUrl = new StringBuilder();
//            sbUrl.append(host);
//            if (!StringUtils.isBlank(path)) {
//                sbUrl.append(path);
//            }
//            if (null != querys) {
//                StringBuilder sbQuery = new StringBuilder();
//                for (Map.Entry<String, String> query : querys.entrySet()) {
//                    if (0 < sbQuery.length()) {
//                        sbQuery.append("&");
//                    }
//                    if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
//                        sbQuery.append(query.getValue());
//                    }
//                    if (!StringUtils.isBlank(query.getKey())) {
//                        sbQuery.append(query.getKey());
//                        if (!StringUtils.isBlank(query.getValue())) {
//                            sbQuery.append("=");
//                            sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
//                        }
//                    }
//                }
//                if (0 < sbQuery.length()) {
//                    sbUrl.append("?").append(sbQuery);
//                }
//            }
//
//            return sbUrl.toString();
//        }
//
//        private static HttpClient wrapClient(String host) {
//            HttpClient httpClient = new DefaultHttpClient();
//            if (host.startsWith("https://")) {
//                sslClient(httpClient);
//            }
//
//            return httpClient;
//        }
//
//        private static void sslClient(HttpClient httpClient) {
//            try {
//                SSLContext ctx = SSLContext.getInstance("TLS");
//                X509TrustManager tm = new X509TrustManager() {
//                    public X509Certificate[] getAcceptedIssuers() {
//                        return null;
//                    }
//                    public void checkClientTrusted(X509Certificate[] xcs, String str) {
//
//                    }
//                    public void checkServerTrusted(X509Certificate[] xcs, String str) {
//
//                    }
//                };
//                ctx.init(null, new TrustManager[] { tm }, null);
//                SSLSocketFactory ssf = new SSLSocketFactory(ctx);
//                ssf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//                ClientConnectionManager ccm = httpClient.getConnectionManager();
//                SchemeRegistry registry = ccm.getSchemeRegistry();
//                registry.register(new Scheme("https", 443, ssf));
//            } catch (KeyManagementException ex) {
//                throw new RuntimeException(ex);
//            } catch (NoSuchAlgorithmException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//
//        public static void main(String[] args) {
//            String host = "https://zbanck.market.alicloudapi.com";
//            String path = "/creditop/BankCardQuery/BankCardVerification";
//            String method = "POST";
//            //String appcode = "你自己的AppCode";
//            Map<String, String> headers = new HashMap<String, String>();
//            //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//            //headers.put("Authorization", "APPCODE " + appcode);
//            Map<String, String> querys = new HashMap<String, String>();
//            querys.put("merchantCode", "10002701");
//		/*querys.put("bankPreMobile", "18600174444");
//		querys.put("idCardCode", "130321198804010180");
//		querys.put("name", "张强");*/
//
//
//            try {
//                /**
//                 * 重要提示如下:
//                 * HttpUtils请从
//                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
//                 * 下载
//                 *
//                 * 相应的依赖请参照
//                 * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
//                 */
//                HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//                System.out.println(response.toString());
//                //获取response的body
//                System.out.println(EntityUtils.toString(response.getEntity()));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//}
