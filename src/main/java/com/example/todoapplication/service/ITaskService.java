package com.example.todoapplication.service;

import com.example.todoapplication.dto.Task;

import java.util.List;

public interface ITaskService {
    /**
     * Fetch a task with a given ID
     * @param id a unique identifier for a task
     * @return the matching task or null if no match is found.
     */
    Task fetchById(int id);

    void delete(int id) throws Exception;

    Task save(Task task) throws Exception;

    List<Task> fetchAll();


}
