package com.shusaku.study;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.shusaku.study.api.EchoService;
import com.shusaku.study.impl.EchoServiceImpl;

import java.io.IOException;

/**
 * @program: study-dubbo
 * @description:
 * @author: Shusaku
 * @create: 2020-05-22 16:47
 */
public class EchoApiProvider {

    public static void main(String[] args) throws IOException {

        ServiceConfig<EchoService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(new ApplicationConfig("java-echo-provider"));
        serviceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        serviceConfig.setInterface(EchoService.class);
        serviceConfig.setRef(new EchoServiceImpl());
        serviceConfig.export();
        System.out.println("java-echo-provider is running...");
        System.in.read();

    }

}
