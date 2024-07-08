package com.fewbug.erodebytes.taskengine.domain;

import lombok.Data;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/7 02:13
 **/
@Data
public class Task {

    private Long id;

    private String name;

    private String description;

    private String owner;

    private Long parentId;

    private String result;

    private String inputParam;

    private String outputParam;

    private Integer status;

}
