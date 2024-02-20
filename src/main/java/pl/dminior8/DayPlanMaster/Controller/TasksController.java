package pl.dminior8.DayPlanMaster.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import pl.dminior8.DayPlanMaster.Model.Tasks;
import pl.dminior8.DayPlanMaster.Service.TasksService;

import java.util.List;
import java.util.Map;
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
    public ResponseEntity<List<Tasks>> getAllTasks(){
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Access-Control-Allow-Origin", "*");
        List<Tasks> tasks = tasksService.allTasks();
        log.info("Returning {} tasks.", tasks.size());

        return new ResponseEntity<List<Tasks>>(
                tasks,headers, HttpStatus.OK);
    }
    @GetMapping("/{category}")
    public ResponseEntity<Optional<Tasks>> getAllByCategory(@PathVariable("category") String category) { //adnotacja mówiąca, że chcemy zmienną w adresie
        HttpHeaders headers = new HttpHeaders();
        Optional<Tasks> tasks = tasksService.allByCategory(category);
        log.info("Returning {} tasks.", tasks.isPresent());

        return new ResponseEntity<Optional<Tasks>>(
                tasks,headers, HttpStatus.OK);
    }
}

//    @PostMapping("/add/")
//    public ResponseEntity<Tasks>createTask(
//            @RequestBody Map<String, String> payload){
//        return new ResponseEntity<Task>(
//                tasksService.createReview(payload.get("reviewBody"),
//                        payload.get("imdbId")), HttpStatus.OK);
//    }
//}