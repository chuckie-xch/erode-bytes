package com.fewbug.erodebytes.taskengine.domain;

import com.fewbug.erodebytes.taskengine.enums.CommandType;
import lombok.Data;

/**
 * @author chunhang.xch
 * @Description
 * @date 2024/7/7 16:52
 **/
@Data
public class TaskCommand {

    private CommandType commandType;

    private String commandParam;

    private boolean isParallel;
}
