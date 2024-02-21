package pl.dminior8.DayPlanMaster.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dminior8.DayPlanMaster.model.User;
import pl.dminior8.DayPlanMaster.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllTasks(){
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Access-Control-Allow-Origin", "*");
        List<User> users = userService.allTasks();
        log.info("Returning {} tasks.", users.size());

        return new ResponseEntity<List<User>>(
                users,headers, HttpStatus.OK);
    }
//    public ResponseEntity<User> createTutorial(@RequestBody User user) {
//        try {
//            User user = userRepository
//                    .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
//            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}