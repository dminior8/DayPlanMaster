package pl.dminior8.DayPlanMaster.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dminior8.DayPlanMaster.Model.Tasks;
import pl.dminior8.DayPlanMaster.Service.TasksService;

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
    public ResponseEntity<List<Tasks>> getAllTasks(){
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Access-Control-Allow-Origin", "*");
        List<Tasks> tasks = tasksService.allTasks();
        log.info("Returning {} tasks.", tasks.size());

        return new ResponseEntity<List<Tasks>>(
                tasks,headers, HttpStatus.OK);
    }
    @GetMapping("/{category}")
    public Optional<Tasks> getById(@PathVariable("category") String category) { //adnotacja mówiąca, że chcemy zmienną w adresie
        return tasksService.getAllByCategory(category);
    }


}