package com.fewbug.erodebytes.springboot3.mybatisplus.dal.dataobject;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/8/20 22:39
 **/
@Data
public class BaseEntity {

    @TableLogic(value = "0", delval = "1")
    @TableField(fill = FieldFill.INSERT)
    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT)
    private String creatorId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifierId;
}
