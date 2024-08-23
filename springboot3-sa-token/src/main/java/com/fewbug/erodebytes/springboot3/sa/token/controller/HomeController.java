package com.fewbug.erodebytes.springboot3.sa.token.controller;

import com.fewbug.erodebytes.common.dto.SingleResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/22 14:06
 **/
@RestController
public class HomeController {


    @RequestMapping("/home")
    public SingleResponse home() {
        return SingleResponse.buildSuccess("Welcome");
    }
}
