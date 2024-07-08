package com.fewbug.erodebytes.sb3.dal.mapper;

import com.fewbug.erodebytes.sb3.dal.dataobject.TestDO;
import com.fewbug.erodebytes.sb3.dal.dataobject.TestDOExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestMapper {
    long countByExample(TestDOExample example);

    int deleteByExample(TestDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TestDO row);

    int insertSelective(TestDO row);

    List<TestDO> selectByExample(TestDOExample example);

    TestDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TestDO row, @Param("example") TestDOExample example);

    int updateByExample(@Param("row") TestDO row, @Param("example") TestDOExample example);

    int updateByPrimaryKeySelective(TestDO row);

    int updateByPrimaryKey(TestDO row);
}