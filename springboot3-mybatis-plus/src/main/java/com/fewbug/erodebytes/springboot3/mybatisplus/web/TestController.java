package com.fewbug.erodebytes.springboot3.mybatisplus.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fewbug.erodebytes.springboot3.mybatisplus.dal.dataobject.TestDO;
import com.fewbug.erodebytes.springboot3.mybatisplus.dal.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/21 00:40
 **/
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/test/{id}")
    public TestDO findById(@PathVariable("id") Long id) {
        return testMapper.selectById(id);
    }

    @GetMapping("/test/findByName")
    public List<TestDO> findByName(@RequestParam("name") String name) {
        LambdaQueryWrapper<TestDO> query = new LambdaQueryWrapper<>();
        query.eq(TestDO::getName, name);
        return testMapper.selectList(query);
    }
}
