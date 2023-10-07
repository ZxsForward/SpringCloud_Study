package org.example.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义断言工厂类
 *  1、必须是spring组件，bean
 *  2、类必须加上 RoutePredicateFactory 作为结尾
 *  3、必须继承AbstractRoutePredicateFactory
 *  4、必须声明静态内部类，声明属性来接收配置文件中对应的断言信息
 *  5、需要结合shortcutFieldOrder()方法进行绑定
 *  6、通过apply()方法进行逻辑判断
 */
@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    private static final String VALUE = "value"; //和内部类的属性一致
    public CheckAuthRoutePredicateFactory() {
        super(Config.class);
    }


    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(VALUE);
    }

    @Override
    public Predicate<ServerWebExchange> apply(final CheckAuthRoutePredicateFactory.Config config) {
        return new GatewayPredicate() {
            @Override
            public boolean test(ServerWebExchange exchange) {
                return config.getValue().equals("myCheckAuthPredicate");
            }
        };
    }

    //用于接收配置文件中 断言的信息
    @Validated
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
