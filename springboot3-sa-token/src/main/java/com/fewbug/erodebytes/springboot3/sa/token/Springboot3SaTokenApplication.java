package com.fewbug.erodebytes.springboot3.sa.token;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Springboot3SaTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot3SaTokenApplication.class, args);
        log.info("启动成功，Sa-Token 配置如下：{}", SaManager.getConfig());
    }

}
