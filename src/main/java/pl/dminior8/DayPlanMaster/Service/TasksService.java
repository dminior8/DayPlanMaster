package pl.dminior8.DayPlanMaster.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dminior8.DayPlanMaster.Model.Tasks;
import pl.dminior8.DayPlanMaster.Repository.TasksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }
    public List<Tasks> allTasks(){
        return tasksRepository.findAll();
    }

    public Optional<Tasks> allByCategory(String category){
        return tasksRepository.findTasksByCategory(Tasks.Category.valueOf(category.toUpperCase()));
    }


    //    public void saveTaskWithSubtasks(List<Subtask> subtaskList) {
//        Task task = new Task();
//        task.setSubtasks(subtaskList);
//
//        //task.setPriority();
//        taskRepository.save(task);
//    }
}
