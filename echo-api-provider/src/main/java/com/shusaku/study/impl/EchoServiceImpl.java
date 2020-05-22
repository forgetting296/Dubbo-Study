package com.shusaku.study.impl;


import com.alibaba.dubbo.rpc.RpcContext;
import com.shusaku.study.api.EchoService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @program: study-dubbo
 * @description:
 * @author: Shusaku
 * @create: 2020-05-22 16:36
 */
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String message) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant instant = new Date().toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        String dateStr = df.format(localDateTime);
        System.out.println(String.format("%s Hello %s, request from consumer: %s", dateStr, message, RpcContext.getContext().getRemoteAddress()));
        //Server端不作任何处理　直接将message返回
        return message;
    }
}
