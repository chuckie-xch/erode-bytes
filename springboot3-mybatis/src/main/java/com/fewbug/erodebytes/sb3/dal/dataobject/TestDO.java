package com.fewbug.erodebytes.sb3.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/8 20:41
 **/
@Data
public class TestDO {

    private Long id;

    private String name;

    private Date testTime;

    protected Boolean isDeleted;

    protected Date gmtCreate;

    protected String creatorId;

    protected Date gmtModified;

    protected String modifierId;

}
