package com.fewbug.erodebytes.springboot3.mybatisplus.dal.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@TableName("test")
@ToString(callSuper = true)
public class TestDO extends BaseEntity{
    private Long id;

    private String name;

    private Date testTime;


}