package com.fewbug.erodebytes.dubbo.provider.service.impl;

import com.fewbug.erodebytes.dubbo.service.api.AsyncService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/1 22:41
 **/
@DubboService(version = "1.0")
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Override
    public String invoke(String param) {
        String spanId = MDC.get("spanId");
        String traceId = MDC.get("traceId");
        try {
            logger.info("do dubbo service invoke, method : invoke, param:{}", param);
            long time = ThreadLocalRandom.current().nextLong(1000);
            Thread.sleep(time);
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncService invoke param: ").append(param).append(",sleep:").append(time);
            return sb.toString();
        } catch (InterruptedException e) {
            logger.error("error process dubbo service invoke, param:{}", param, e);
            Thread.currentThread().interrupt();
        }
        return null;
    }

    @Override
    public CompletableFuture<String> asyncInvoke(String param) {
        logger.info("first do dubbo service invoke, method : asyncInvoke, param:{}", param);
        String spanId = MDC.get("spanId");
        return CompletableFuture.supplyAsync(() -> {
            try {
                String traceId = MDC.get("traceId") == null ? UUID.randomUUID().toString() : MDC.get("traceId");
                MDC.put("traceId", traceId);
                logger.info("do dubbo service invoke, method : asyncInvoke, param:{}", param);
                long time = ThreadLocalRandom.current().nextLong(1000);
                Thread.sleep(time);
                StringBuilder sb = new StringBuilder();
                sb.append("AsyncService invoke param: ").append(param).append(",sleep:").append(time);
                return sb.toString();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("error process dubbo service asyncInvoke, param:{}", param, e);
            }
            return null;
        });
    }

    @Override
    public String sayHello(String name) {
        final AsyncContext asyncContext = RpcContext.startAsync();
        new Thread(() -> {
            asyncContext.signalContextSwitch();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            asyncContext.write("hello" + name + ", response from provider");
        }).start();
        return null;
    }
}
