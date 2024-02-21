package pl.dminior8.DayPlanMaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dminior8.DayPlanMaster.model.User;
import pl.dminior8.DayPlanMaster.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> allTasks() {
        return userRepository.findAll();
    }
}
