package com.example.todoapplication.dao;

import com.example.todoapplication.dto.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskDAOStub implements ITaskDAO{

    Map<Integer, Task> allTasks = new HashMap<>();

    @Override
    public Task save(Task task) throws Exception {
        Integer taskId = task.getTaskId();
        allTasks.put(taskId, task);
        return task;
    }

    @Override
    public List<Task> fetchAll() {
        List<Task> returnTasks = new ArrayList(allTasks.values());
        return returnTasks;
    }

    @Override
    public Task fetch(int id) {
        return allTasks.get(id);
    }

    @Override
    public void delete(int id) {
        allTasks.remove(id);
    }
}
