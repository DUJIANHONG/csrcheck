package com.csr.csrcheck;

import com.csr.csrcheck.util.HttpUtil;
import org.junit.Test;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2019/10/30 17:29
 * @version:
 * @modified By:
 */
public class Wx {

     @Test
     public void wxtoke() throws Exception {
         /**
          * 应用如何创建URL http://ai.baidu.com/docs#/Begin/top 这里是图文教程的哦。
          */
         //在控制台复制自己应用的  API Key
/*         String APIKEY = "";
         //在控制台复制自己应用的 Secret Key
         String SECRETKEY = "";
         String url = "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=APIKEY&client_secret=SECRETKEY";*/

          String APPID = "wxd7e12428abb2f56f";
          String APPSECRET = "9527fce4b95b010a68ceec218a95aec4";
          String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
         String requsetURL = ACCESS_TOKEN_URL.replaceAll("APPID",APPID).replaceAll("APPSECRET",APPSECRET);
         System.out.println(requsetURL);
         String jsonObject = HttpUtil.postToken(requsetURL,"");
         System.err.println(jsonObject);
     }
}
