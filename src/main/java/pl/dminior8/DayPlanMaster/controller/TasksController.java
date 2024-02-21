package pl.dminior8.DayPlanMaster.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dminior8.DayPlanMaster.model.Task;
import pl.dminior8.DayPlanMaster.service.TasksService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
@Slf4j
public class TasksController {

    @Autowired
    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService taskService) {
        this.tasksService = taskService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(){
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Access-Control-Allow-Origin", "*");
        List<Task> tasks = tasksService.writeAllTasks();
        log.info("Returning {} tasks.", tasks.size());

        return new ResponseEntity<List<Task>>(
                tasks,headers, HttpStatus.OK);
    }
    @GetMapping("/{category}")
    public ResponseEntity<Optional<Task>> getAllByCategory(@PathVariable("category") String category) { //adnotacja mówiąca, że chcemy zmienną w adresie
        HttpHeaders headers = new HttpHeaders();
        Optional<Task> tasks = tasksService.writeAllTasksByCategory(category);
        log.info("Returning {} tasks.", tasks.isPresent());

        return new ResponseEntity<Optional<Task>>(
                tasks,headers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Task>createSingleTask(
            @RequestBody Task task){
        return new ResponseEntity<>(
                tasksService.createSingleTask(task), HttpStatus.OK);
    }

    @GetMapping("/id={id}")
    public ResponseEntity<Optional<Task>> getSingleTaskById(
            @PathVariable  int id){
        return new ResponseEntity<>(tasksService.writeSingleTaskById(id),HttpStatus.OK);
    }
 //TODO: PatchMethod
//    @PatchMapping("/id={id}")
//    public ResponseEntity<Optional<Task>> updateSingleTaskById(
//            @PathVariable  int id, @RequestBody Task task){
//        Optional<Task> existingTask = tasksService.writeSingleTaskById(id);
//
//        if(existingTask.isPresent()){
//
//        }
//        return new ResponseEntity<>(tasksService.updateSingleTaskById(id),HttpStatus.OK);
//    }
}