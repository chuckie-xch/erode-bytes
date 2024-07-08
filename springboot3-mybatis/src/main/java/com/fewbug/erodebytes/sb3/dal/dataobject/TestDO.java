package com.fewbug.erodebytes.sb3.dal.dataobject;

import lombok.Data;

import java.util.Date;

@Data
public class TestDO {
    private Long id;

    private String name;

    private Date testTime;

    private Boolean isDeleted;

    private Date gmtCreate;

    private String creatorId;

    private Date gmtModified;

    private String modifierId;


}