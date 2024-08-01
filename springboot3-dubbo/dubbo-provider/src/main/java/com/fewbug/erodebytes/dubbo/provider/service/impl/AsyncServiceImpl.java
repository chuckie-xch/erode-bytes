package com.fewbug.erodebytes.dubbo.provider.service.impl;

import com.fewbug.erodebytes.dubbo.service.api.AsyncService;
import org.apache.dubbo.rpc.AsyncContext;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/1 22:41
 **/
public class AsyncServiceImpl implements AsyncService {
    @Override
    public String invoke(String param) {
        try {
            long time = ThreadLocalRandom.current().nextLong();
            Thread.sleep(time);
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncService invoke param: ").append(param).append(",sleep:").append(time);
            return sb.toString();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

    @Override
    public CompletableFuture<String> asyncInvoke(String param) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                long time = ThreadLocalRandom.current().nextLong();
                Thread.sleep(time);
                StringBuilder sb = new StringBuilder();
                sb.append("AsyncService invoke param: ").append(param).append(",sleep:").append(time);
                return sb.toString();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
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
