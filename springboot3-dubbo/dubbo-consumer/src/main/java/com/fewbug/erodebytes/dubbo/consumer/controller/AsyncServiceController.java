package com.fewbug.erodebytes.dubbo.consumer.controller;

import com.fewbug.erodebytes.dubbo.service.api.AsyncService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/1 23:50
 **/
@RestController
public class AsyncServiceController {

    @DubboReference(version = "1.0")
    private AsyncService asyncService;

    @GetMapping("/async")
    public ResponseEntity<String> async(@RequestParam("param") String param) throws Exception {
        CompletableFuture<String> future = asyncService.asyncInvoke(param);
        return ResponseEntity.ok(future.get());
    }

    @GetMapping("/asyncByAsyncContext")
    public ResponseEntity<String> asyncByAsyncContext(@RequestParam("param") String param) throws Exception {
        String res = asyncService.sayHello(param);
        return ResponseEntity.ok(res);
    }
}
