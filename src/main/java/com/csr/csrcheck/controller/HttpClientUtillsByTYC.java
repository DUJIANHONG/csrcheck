package com.csr.csrcheck.controller;

/**
 * @author Karry
 * @create 2019-10-27 15:42
 */

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("TYCapi")
public class HttpClientUtillsByTYC {
    private static Logger logger = LoggerFactory
            .getLogger(HttpClientUtillsByTYC.class); // 日志记录


    /**
     * 发送get请求
     *
     * @param
     * @return
     */
    @RequestMapping("api")
    public JSONObject httpGet() {
        String url=("http://open.api.tianyancha.com/services/open/ic/baseinfo/2.0?name=江苏恒瑞医药股份有限公司");
        // get请求返回结果
        JSONObject jsonResult = null;
        CloseableHttpClient client = HttpClients.createDefault();
        // 发送get请求
        HttpGet request = new HttpGet(url);
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(6000).setConnectTimeout(6000).build();
        request.setConfig(requestConfig);
        request.setHeader("Authorization", "a988098b-37fb-4b3a-8340-a2c570d7d080");//token值
        try {
            CloseableHttpResponse response = client.execute(request);

            //请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                //读取服务器返回过来的json字符串数据
                HttpEntity entity = response.getEntity();
                String strResult = EntityUtils.toString(entity, "utf-8");
                //把json字符串转换成json对象
                jsonResult = JSONObject.parseObject(strResult);
            } else {
                logger.error("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            logger.error("get请求提交失败:" + url, e);
        } finally {
            request.releaseConnection();
        }
        return jsonResult;
    }
    /*@RequestMapping("api")
    public String api() throws IOException {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            //拼接参数，转义参数
            String connUrl = "http://open.api.tianyancha.com/services/open/ic/baseinfo/2.0?id=open18394818619&name=平安银行股份有限公司";

            //创建连接
            URL url = new URL(connUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setInstanceFollowRedirects(false);
            conn.connect();


            //获取并解析数据
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuffer sb = new StringBuffer();
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }*/
}

