package com.example.order.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.example.order.pojo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sentinel统一异常处理类
 */
@Component
public class MyBlockExceptionHandler implements BlockExceptionHandler {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    //
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        //getRule() 资源，规则的详细信息
        logger.info("BlockExceptionHandler BlockException===========" + e.getRule());
        Result result = null;
        if (e instanceof FlowException){
            result = Result.error("接口限流了");
        }else if (e instanceof DegradeException){
            result = Result.error("服务降级了");
        } else if (e instanceof ParamFlowException) {
            result = Result.error("热点参数先溜了");
        } else if (e instanceof SystemBlockException) {
            result = Result.error("触发保护规则了");
        } else if (e instanceof AuthorityException) {
            result = Result.error("授权规则不通过");
        }

        //返回json数据
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(httpServletResponse.getWriter(),result);
    }
}
