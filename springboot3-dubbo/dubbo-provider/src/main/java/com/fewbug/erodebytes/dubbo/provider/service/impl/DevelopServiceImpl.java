package com.fewbug.erodebytes.dubbo.provider.service.impl;

import com.fewbug.erodebytes.dubbo.service.api.DevelopService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/30 01:25
 **/
@DubboService(version = "1.0")
public class DevelopServiceImpl implements DevelopService {
    @Override
    public String invoke(String param) {
        StringBuilder sb = new StringBuilder();
        sb.append("Service1 param:").append(param);
        return sb.toString();
    }
}
