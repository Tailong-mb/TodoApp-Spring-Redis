package com.tailong.javatodolist.controllers;

import com.tailong.javatodolist.documents.Task;
import com.tailong.javatodolist.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;


@RestController
public class TaskController {

    @Autowired
    TaskRepository repository;

    @GetMapping("tasks")
    Iterable<Task> all(){
        return repository.findAll();
    }

    @PostMapping("tasks")
    Task create(@RequestBody()Map<String, String> body){
        Task task = new Task();
        task.name = body.get("name");

        return repository.save(task);
    }

    @PutMapping("tasks/{id}")
    Task update(@PathVariable String id,@RequestBody() Map<String, Boolean> body){
        var result = repository.findById(id);

        if(result.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Unable to find task");
        }

        var task = result.get();
        task.complete = body.get("complete");

        return repository.save(task);
    }

    @DeleteMapping("tasks/id")
    void delete(@PathVariable String id){
        var result = repository.findById(id);

        result.ifPresent(task -> repository.delete(task));
    }
}
