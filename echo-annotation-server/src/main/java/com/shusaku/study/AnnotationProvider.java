package com.shusaku.study;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @program: study-dubbo
 * @description:
 * @author: Shusaku
 * @create: 2020-05-22 14:26
 */
public class AnnotationProvider {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();

        System.in.read();
    }

    @Configuration
    //指定扫描服务的位置
    @EnableDubbo(scanBasePackages = "com.shusaku.study")
    static class ProviderConfiguration {
        @Bean
        public ProviderConfig providerConfig(){return new ProviderConfig();}

        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig config = new ApplicationConfig();
            config.setName("echo-annotation-provider");
            return config;
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig config = new RegistryConfig();
            config.setAddress("127.0.0.1");
            config.setProtocol("zookeeper");
            config.setPort(2181);
            return config;
        }

        @Bean
        public ProtocolConfig protocolConfig() {
            ProtocolConfig config = new ProtocolConfig();
            config.setName("dubbo");
            config.setPort(20800);
            return config;
        }
    }

}
