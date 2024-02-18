package pl.dminior8.DayPlanMaster.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dminior8.DayPlanMaster.Model.Subtask;
import pl.dminior8.DayPlanMaster.Model.Task;
import pl.dminior8.DayPlanMaster.Repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Task> allTasks(){
        return taskRepository.findAll();
    }
//    public void saveTaskWithSubtasks(List<Subtask> subtaskList) {
//        Task task = new Task();
//        task.setSubtasks(subtaskList);
//
//        //task.setPriority();
//        taskRepository.save(task);
//    }
}
