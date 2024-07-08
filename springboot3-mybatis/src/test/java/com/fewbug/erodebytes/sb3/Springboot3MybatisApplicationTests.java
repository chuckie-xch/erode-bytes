package com.fewbug.erodebytes.sb3;

import com.fewbug.erodebytes.sb3.dal.dataobject.TestDO;
import com.fewbug.erodebytes.sb3.dal.dataobject.TestDOExample;
import com.fewbug.erodebytes.sb3.dal.mapper.TestExtMapper;
import com.fewbug.erodebytes.sb3.dal.mapper.TestMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@MapperScan("com.fewbug.erodebytes.sb3.dal.mapper")
class Springboot3MybatisApplicationTests {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TestMapper testMapper;

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private TestExtMapper testExtMapper;

    @Test
    public void test() {
        TestDO testDO = new TestDO();
        testDO.setTestTime(new Date());
        testDO.setName("测试springboot3-mybatis-insert");
        testMapper.insertSelective(testDO);
        Assertions.assertNotNull(testMapper.selectByPrimaryKey(testDO.getId()));
    }

    @Test
    public void testFindByName() {
        List<TestDO> testList = testExtMapper.findByName("测试项2");
        Assertions.assertNotNull(testList);
        Assertions.assertEquals(testList.size(), 1);

        TestDO testDO = testList.get(0);
        System.out.println(testDO);
    }

    @Test
    public void testFindParam() {
        TestDOExample queryParam = new TestDOExample();
        queryParam.createCriteria().andNameEqualTo("测试项2");
        List<TestDO> testList = testMapper.selectByExample(queryParam);
        Assertions.assertNotNull(testList);
        Assertions.assertEquals(testList.size(), 1);

        TestDO testDO = testList.get(0);
        System.out.println(testDO);
    }


}
