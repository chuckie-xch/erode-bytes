package com.fewbug.erodebytes.taskengine.mapper;

import com.fewbug.erodebytes.taskengine.dataobject.TaskInstance;
import com.fewbug.erodebytes.taskengine.domain.TaskCommand;

/**
 * @author chunhang.xch
 */
public interface TaskInstanceMapper {

   TaskInstance newTaskInstance(TaskCommand taskCommand);

   void updateTaskInstance(TaskInstance taskInstance);

}
