package com.herig.week03.job01;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientHelper {
    public static void main(String[] args) {
        String url = "http://localhost:8888";
        doGet(url);
    }

    //Get请求调用
    public static void doGet(String url){
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpGet httpGet = new HttpGet(url);
            try(CloseableHttpResponse response = httpClient.execute(httpGet)){
                HttpEntity httpEntity = response.getEntity();
                System.out.println("----------------------------------开始--------------------------------------");
                System.out.println(EntityUtils.toString(httpEntity));
                System.out.println("----------------------------------结束--------------------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
