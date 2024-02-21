package pl.dminior8.DayPlanMaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dminior8.DayPlanMaster.model.Task;
import pl.dminior8.DayPlanMaster.repository.TasksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Task> writeAllTasks() {
        return tasksRepository.findAll();
    }

    public Optional<Task> writeAllTasksByCategory(String category) {
        return tasksRepository.findTasksByCategory(Task.Category.valueOf(category.toUpperCase()));
    }

    public Task createSingleTask(Task task) {
        return tasksRepository.save(task);
    }

    public Optional<Task> writeSingleTaskById(int id){
        return tasksRepository.findTaskById(id);
    }
//TODO
    //    public Optional<Task> updateSingleTaskById(int id){
//        if(movie != null){
//            movie.setName(updatedMovie.getName());
//            movie.setRating(updatedMovie.getRating());
//
//            movieRepository.update(movie);
//        return tasksRepository.findTaskById(id);
//    }
}

