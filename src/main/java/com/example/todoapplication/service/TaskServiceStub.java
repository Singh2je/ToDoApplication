package com.example.todoapplication.service;

import com.example.todoapplication.dao.ITaskDAO;
import com.example.todoapplication.dto.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *  * This service "stub" is a hardcoded implementation for testing purposes.
 */

@Service
public class TaskServiceStub implements ITaskService {
    @Autowired
    private ITaskDAO taskDAO;

    //Constructor
    public TaskServiceStub(){
    }

    public TaskServiceStub(ITaskDAO TaskDAO){
        taskDAO = TaskDAO;
    }


    @Override
    public Task fetchById(int id) {
        Task foundTask = taskDAO.fetch(id);
        return foundTask;
    }

    @Override
    public void delete(int id) throws Exception{
        taskDAO.delete(id);

    }


    @Override //Pushing the operation down to the DAO
    public Task save(Task task)throws Exception {
        return taskDAO.save(task) ;
    }

    @Override
    public List<Task> fetchAll() {
        return taskDAO.fetchAll();
    }


}
