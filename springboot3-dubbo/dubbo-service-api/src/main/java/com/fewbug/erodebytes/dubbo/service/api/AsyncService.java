package com.fewbug.erodebytes.dubbo.service.api;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {

    String invoke(String param);

    CompletableFuture<String> asyncInvoke(String param);

    String sayHello(String name);
}
