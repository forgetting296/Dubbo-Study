package com.shusaku.study.refer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.shusaku.study.api.EchoService;
import org.springframework.stereotype.Component;

/**
 * @program: study-dubbo
 * @description:
 * @author: Shusaku
 * @create: 2020-05-22 14:39
 */
@Component
public class EchoConsumer {

    @Reference
    private EchoService echoService;

    public String echo(String message) {
        return echoService.echo(message);
    }
}
