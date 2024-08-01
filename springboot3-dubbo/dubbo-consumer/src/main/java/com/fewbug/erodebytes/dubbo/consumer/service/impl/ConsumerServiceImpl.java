package com.fewbug.erodebytes.dubbo.consumer.service.impl;

import com.fewbug.erodebytes.dubbo.service.api.DevelopService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/30 01:37
 **/
@Service
public class ConsumerServiceImpl implements CommandLineRunner {

    @DubboReference(version = "1.0")
    private DevelopService developService;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Dubbo Remote Service Return: " + developService.invoke("test invoke"));
    }


}
