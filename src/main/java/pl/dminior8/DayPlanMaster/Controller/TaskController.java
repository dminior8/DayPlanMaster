package pl.dminior8.DayPlanMaster.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dminior8.DayPlanMaster.Model.Subtask;
import pl.dminior8.DayPlanMaster.Model.Task;
import pl.dminior8.DayPlanMaster.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Slf4j
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Access-Control-Allow-Origin", "*");
        List<Task> tasks = taskService.allTasks();
        log.info("Returning {} tasks.", tasks.size());

        return new ResponseEntity<List<Task>>(
                tasks,headers, HttpStatus.OK);
    }

}