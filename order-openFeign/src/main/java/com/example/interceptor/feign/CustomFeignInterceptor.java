package com.example.interceptor.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义Feign拦截器
 */
public class CustomFeignInterceptor implements RequestInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("name","张杰"); //修改请求头
        requestTemplate.query("id","111"); //修改请求参数
        requestTemplate.uri("/9"); //修改请求地址

        logger.info("Feign拦截器");
    }
}
