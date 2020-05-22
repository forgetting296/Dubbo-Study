package com.shusaku.study;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.shusaku.study.api.EchoService;

/**
 * @program: study-dubbo
 * @description:
 * @author: Shusaku
 * @create: 2020-05-22 17:10
 */
public class EchoApiConsumer {

    public static void main(String[] args) {
        ReferenceConfig<EchoService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(new ApplicationConfig("java-echo-consumer"));

        referenceConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        referenceConfig.setInterface(EchoService.class);
        EchoService echoService = referenceConfig.get();
        String echo = echoService.echo("HelloWorld!!!");
        System.out.println("result: " + echo);

    }

}
