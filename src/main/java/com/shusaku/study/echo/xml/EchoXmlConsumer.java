package com.shusaku.study.echo.xml;

import com.shusaku.study.echo.EchoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: study-dubbo
 * @description:
 * @author: Shusaku
 * @create: 2020-05-22 11:39
 */
public class EchoXmlConsumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/echo-consumer.xml"});
        applicationContext.start();

        EchoService echoService = (EchoService)applicationContext.getBean("echoService");

        String status = echoService.echo("Hello World!!!");
        System.out.println("echo result: " + status);
    }

}
