package com.manohar.taskproject.serviceimpl;

import com.manohar.taskproject.entity.Task;
import com.manohar.taskproject.entity.Users;
import com.manohar.taskproject.exception.APIException;
import com.manohar.taskproject.exception.TaskNotFound;
import com.manohar.taskproject.exception.UserNotFound;
import com.manohar.taskproject.payload.TaskDto;
import com.manohar.taskproject.repository.TaskRepository;
import com.manohar.taskproject.repository.UserRepository;
import com.manohar.taskproject.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskServiceImpl implements TaskService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private TaskRepository taskRepository;


    @Override
    public TaskDto saveTask(long userid, TaskDto taskDto) {
        Users user = userRepository.findById(userid).orElseThrow(
                ()->new UserNotFound(String.format("User Id %d not found",userid))
        );
        Task task = modelMapper.map(taskDto,Task.class);
        task.setUsers(user);

        //After setting the user , we are storing the data in DB
        Task savedTask = taskRepository.save(task);
        return modelMapper.map(savedTask,TaskDto.class);
    }

    @Override
    public List<TaskDto> getAllTasks(long userid) {


        Users user = userRepository.findById(userid).orElseThrow(
                ()->new UserNotFound(String.format("User Id %d not found",userid))
        );


        List<Task> tasks = taskRepository.findAllByUsersId(userid);
        return tasks.stream().map(
                task -> modelMapper.map(task,TaskDto.class)
        ).collect(Collectors.toList());
    }


    public TaskDto getTask(long userid , long taskid){

        Users users = userRepository.findById(userid).orElseThrow(
                ()->new UserNotFound(String.format("\"User Id %d not found\",userid"))
        );

        Task task = taskRepository.findById(taskid).orElseThrow(
                ()->new TaskNotFound(String.format("Task Id %d not found",taskid))

        );

        if(users.getId()!=task.getUsers().getId()){
            throw new APIException(String.format("Task Id %d is not belongs to User Id %d",taskid,userid));
        }
        return modelMapper.map(task,TaskDto.class);
    }

    @Override
    public void deleteTask(long userid, long taskid) {

        Users users = userRepository.findById(userid).orElseThrow(
                ()->new UserNotFound(String.format("\"User Id %d not found\",userid"))
        );

        Task task = taskRepository.findById(taskid).orElseThrow(
                ()->new TaskNotFound(String.format("Task Id %d not found",taskid))

        );

        if(users.getId()!=task.getUsers().getId()){
            throw new APIException(String.format("Task Id %d is not belongs to User Id %d",taskid,userid));
        }

        taskRepository.deleteById(taskid); // delete the task
    }

}
