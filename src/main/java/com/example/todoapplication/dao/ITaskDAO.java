package com.example.todoapplication.dao;

import com.example.todoapplication.dto.Task;

import java.util.List;

public interface ITaskDAO {
    Task save(Task task) throws Exception;
    List<Task> fetchAll();

    Task fetch(int id);

    void delete(int id);
}

