package com.example.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实现Sentinel配置持久化：
 *          结合nacos配置文件使用(下面是流控规则的示例)
 *         [
 *     {
 *         "resource": "/orderSentinel/flow",
 *         "controlBehavior": 0,
 *         "count": 2,
 *         "grade": 1,
 *         "limitApp": "default",
 *         "strategy": 0
 *     }
 * ]
 * resource：资源名，即限流规则的作用对象
 * count: 限流阈值
 * grade: 限流阈值类型，QPS 模式（1）或并发线程数模式（0）
 * limitApp: 流控针对的调用来源，若为 default 则不区分调用来源
 * strategy: 调用关系限流策略：直接（0）、链路（1）、关联（2）
 * controlBehavior: 流量控制效果：直接拒绝（0）、Warm Up（1）、匀速排队（2）
 */
@RestController
@RequestMapping("/orderSentinel")
public class OrderSentinelController {
    @GetMapping("/flow")
//    @SentinelResource(value = "flow",blockHandler = "flowBlockHandler")
    public String flow(){
        return "正常访问";
    }

    public String flowBlockHandler(BlockException blockException){
        return "流控";
    }

    @GetMapping("/flowThread")
//    @SentinelResource(value = "flowThread",blockHandler = "flowBlockHandler")
    public String flowThread() throws InterruptedException {
        Thread.sleep(2000);
        return "线程正常访问";
    }

    @GetMapping("/add")
    public String add(){
        return "生成订单" ;
    }
    @GetMapping("/get")
    public String get(){
        return "查询订单" ;
    }

    @Autowired
    IOrderService service;
    @GetMapping("/test1")
    public String test1(){
        return service.getUser();
    }
    @GetMapping("/test2")
    public String test2(){
        return service.getUser();
    }


    /**
     *热点流控，必须使用@SentinelResource
     */
    @GetMapping("/get/{id}")
    @SentinelResource(value = "getByID",blockHandler = "HotBlockHandler")
    public String getByID(@PathVariable int id){
        System.out.println("正常访问");
        return "正常访问";
    }
    public String HotBlockHandler(@PathVariable int id, BlockException e){
        return "热点异常处理";
    }
}
