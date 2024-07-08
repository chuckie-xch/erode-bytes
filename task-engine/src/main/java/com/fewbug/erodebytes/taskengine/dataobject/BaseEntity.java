package com.fewbug.erodebytes.taskengine.dataobject;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/7 12:09
 **/
@Getter
@Setter
public abstract class BaseEntity {

    protected Boolean isDeleted;

    protected Date gmtCreate;

    protected String creatorId;

    protected Date gmtModified;

    protected String modifierId;
}
