package com.example.todoapplication;

import com.example.todoapplication.dao.ITaskDAO;
import com.example.todoapplication.dto.Task;
import com.example.todoapplication.service.ITaskService;
import com.example.todoapplication.service.TaskServiceStub;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ToDoApplicationTests {

   // @Autowired //Basically importing the service so that we use it in our tests
    private ITaskService taskService;
    private Task task = new Task();

    @MockBean
    private ITaskDAO taskDAO;

    @Test
    void contextLoads() {
    }
    
    // The names are very detailed. That's how they are in unit tests. Easy to Identify an error.
    
    @Test
    void fetchTaskById_returnsTaskForID83() throws Exception{
        givenTaskDataIsAvailable();
        whenTask83IsLaundry();
        whenSearchTaskWithID83();
        thenReturnTaskForID83();
    }

    private void whenTask83IsLaundry() {
        Task laundry = new Task();
        laundry.setTaskId(83);
        laundry.setTaskText("Do the laundry");
        Mockito.when(taskDAO.fetch(83)).thenReturn(laundry);
    }

    private void givenTaskDataIsAvailable() throws Exception{
        Mockito.when(taskDAO.save(task)).thenReturn(task);
        taskService = new TaskServiceStub(taskDAO);
    }

    private void whenSearchTaskWithID83() {
       task = taskService.fetchById(83);    // This tells us we will need a service with "fetchById" method, and it will return a task.
    }

    private void thenReturnTaskForID83() {
        String taskText =  task.getTaskText();
        assertEquals("Do the laundry", taskText);
    }

    @Test
    void saveTask_validateReturnTaskWithIdAndText() throws Exception{
        givenTaskDataIsAvailable();
        whenUserCreatesANewTaskAndSaves();
        thenCreateNewTaskRecordAndReturnIt();
    }
    private void whenUserCreatesANewTaskAndSaves() {
        task.setTaskId(52);
        task.setTaskText("Clean your room");
    }

    private void thenCreateNewTaskRecordAndReturnIt() throws Exception {
        Task createdTask = taskService.save(task);
        assertEquals(task, createdTask);
        verify(taskDAO, atLeastOnce()).save(task); //Makes sure it was called at least once.
    }


}
