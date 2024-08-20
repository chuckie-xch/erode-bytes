package com.fewbug.erodebytes.springboot3.mybatisplus;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fewbug.erodebytes.springboot3.mybatisplus.config.MybatisConfig;
import com.fewbug.erodebytes.springboot3.mybatisplus.dal.dataobject.TestDO;
import com.fewbug.erodebytes.springboot3.mybatisplus.dal.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/20 22:43
 **/
@SpringBootTest
@ActiveProfiles("test")
@Import(MybatisConfig.class)
@Slf4j
public class MybatisPlusSampleTest {

    @Autowired
    private TestMapper testMapper;

    @Test
    public void test() {
        TestDO testDO = new TestDO();
        testDO.setName("test_" + RandomUtil.randomString(6));
        testDO.setTestTime(new Date());
        testMapper.insert(testDO);
        log.info("insert success, newTestInfo:{}", testDO);

        testDO.setTestTime(new Date(testDO.getTestTime().getTime() + 3600));
        testMapper.updateById(testDO);
        log.info("update success, update result:{}", testMapper.selectById(testDO.getId()));

        List<TestDO> testDOS = queryByName(testDO.getName());
        log.info("query by Name:{}, result:{}", testDO.getName(), testDOS);

        testMapper.deleteById(testDO);
        log.info("delete success, delete result:{}", testMapper.selectById(testDO.getId()));

    }

    private List<TestDO> queryByName(String name) {
        LambdaQueryWrapper<TestDO> queryWrapper = new LambdaQueryWrapper<TestDO>();
        queryWrapper.eq(TestDO::getName, name);
        List<TestDO> testDOS = testMapper.selectList(queryWrapper);
        return testDOS;
    }
}
