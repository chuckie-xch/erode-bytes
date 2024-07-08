package com.fewbug.erodebytes.sb3.dal.mapper;

import com.fewbug.erodebytes.sb3.dal.dataobject.TestDO;

import java.util.List;

/**
 * @author chunhang.xch
 */
public interface TestExtMapper extends TestMapper {

    List<TestDO> findByName(String name);
}
