package com.manohar.taskproject.service;

import com.manohar.taskproject.payload.TaskDto;

import java.util.List;

public interface TaskService {

    public TaskDto saveTask(long userid , TaskDto taskDto);


    public List<TaskDto> getAllTasks(long userid);

    public TaskDto getTask(long userid, long todoid);

    public void deleteTask(long userid, long todoid);
}
