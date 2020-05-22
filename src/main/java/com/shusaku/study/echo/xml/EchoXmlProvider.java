package com.shusaku.study.echo.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @program: study-dubbo
 * @description:
 * @author: Shusaku
 * @create: 2020-05-22 11:42
 */
public class EchoXmlProvider {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/echo-provider.xml"});
        applicationContext.start();
        System.in.read();
    }

}
