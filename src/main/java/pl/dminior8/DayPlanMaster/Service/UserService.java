package pl.dminior8.DayPlanMaster.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dminior8.DayPlanMaster.Model.Task;
import pl.dminior8.DayPlanMaster.Model.User;
import pl.dminior8.DayPlanMaster.Repository.UserRepository;

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
