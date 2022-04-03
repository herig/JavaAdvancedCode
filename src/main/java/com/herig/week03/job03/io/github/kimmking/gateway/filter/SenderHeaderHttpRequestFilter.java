package com.herig.week03.job03.io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import com.herig.week03.job01.io.github.kimmking.gateway.filter.HttpRequestFilter;

import java.util.List;
import java.util.Map;

/**
 * @author herig
 * @date 2022/3/20 - 22:50
 */
public class SenderHeaderHttpRequestFilter implements  HttpRequestFilter {


    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
        HttpHeaders header = fullRequest.headers();
        List<Map.Entry<String, String>> list = header.entries();
        Boolean flag = false;
        for(Map.Entry<String, String> headerInfo:list){
            if(headerInfo.getKey().equals("sender") && headerInfo.getValue().equals("herig")){
                flag = true;
            }
        }

        if(flag){
            // 放行
            System.out.println("请求头包含sender:herig，放行！");
        }else{
            throw new RuntimeException("请求头不包含sender:herig！");
        }



    }
}
