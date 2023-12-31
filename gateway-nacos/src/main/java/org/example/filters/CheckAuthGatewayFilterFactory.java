package org.example.filters;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义网关过滤器
 */
@Component
public class CheckAuthGatewayFilterFactory extends AbstractGatewayFilterFactory<CheckAuthGatewayFilterFactory.Config> {

    private static final String VALUE = "value"; //和内部类的属性一致
    public CheckAuthGatewayFilterFactory() {
        super(CheckAuthGatewayFilterFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(VALUE);
    }

    @Override
    public GatewayFilter apply(CheckAuthGatewayFilterFactory.Config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                //1、获取name参数
                //2、如果!=value就失败
                //3、否则正常访问
                String name_value = exchange.getRequest().getQueryParams().getFirst("name");
                System.out.println("获取的name参数为：" + name_value);

                if (StringUtils.isNotBlank(name_value)){
                    if (config.getValue().equals(name_value)){
                        System.out.println("获取的自定义过滤器value值为：" + config.getValue());
                        return chain.filter(exchange);
                    }
                }
                //返回404并结束
                exchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
                return exchange.getResponse().setComplete();
            }
        };
    }

    //用于接收配置文件中 过滤器的信息
    public static class Config {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
