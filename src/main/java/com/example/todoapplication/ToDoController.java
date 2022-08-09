package com.example.todoapplication;

import com.example.todoapplication.dto.Task;
import com.example.todoapplication.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToDoController {
    @Autowired
    ITaskService taskService;

    /**
     * Handle the root endpoint and return a start page
     *
     * @return
     */

    @RequestMapping("/")
    public String index(Model model) {
        Task task = new Task();
        task.setTaskText("Just mocking haha");
        task.setTaskId(94);
        model.addAttribute(task);
        return "start";
    }


    @RequestMapping("/saveTask")
    public String saveTask(Task task) {
        try {
            taskService.save(task);
        } catch (Exception e) {
            e.printStackTrace();
            return"start";
        }
        return"start";
    }

    //Dummy Get Request to fetch all tasks
    @GetMapping("/tasks")
    @ResponseBody
    public List<Task> fetchAllTasks() {
        return taskService.fetchAll();
    }

    @GetMapping ("/search")
    public ResponseEntity searchTasks(@RequestParam(value="searchTerm", required=false, defaultValue="None") String searchTerm){
        return new ResponseEntity(HttpStatus.OK);
    }



    //Get Request to get a single task by id
    @GetMapping("/tasks/{id}/")
    public ResponseEntity fetchTasksById(@PathVariable("id") Integer id) {
        Task foundTask = taskService.fetchById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(foundTask, headers, HttpStatus.OK);
    }



    //Post Request
    @PostMapping(value = "/tasks", consumes = "application/json", produces = "application/json")
    public ResponseEntity createTask(@RequestBody Task task) {
        Task newTask = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            newTask = taskService.save(task);
        } catch (Exception e) {
            return new ResponseEntity(headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(newTask, headers, HttpStatus.OK);
    }

    //Delete Request
    @DeleteMapping("/tasks/{id}/")
    public ResponseEntity deleteTask(@PathVariable("id") Integer id) {
        try {
            taskService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
