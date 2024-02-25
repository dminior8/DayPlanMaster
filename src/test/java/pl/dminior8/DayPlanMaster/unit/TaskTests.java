package pl.dminior8.DayPlanMaster.unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import pl.dminior8.DayPlanMaster.model.Subtask;
import pl.dminior8.DayPlanMaster.model.Task;
import pl.dminior8.DayPlanMaster.repository.TasksRepository;
import pl.dminior8.DayPlanMaster.service.TasksService;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pl.dminior8.DayPlanMaster.model.Task.Category.WORK;
import static pl.dminior8.DayPlanMaster.model.Task.Priority.HIGH;

@SpringBootTest
class TaskTests {

    @Mock
    private TasksRepository tasksRepository;

    @InjectMocks
    private TasksService tasksService;

    @Test
    public void shouldWriteAllTasks() {

        //given
        List<Task> taskList = prepareDataToTests();
        when(tasksRepository.findAll()).thenReturn(taskList);

        //when
        List<Task> result = tasksService.writeAllTasks();

        //then
        assertEquals(result, taskList);
        verify(tasksRepository, times(1)).findAll();
    }

    @Test
    public void shouldWriteAllTasksByCategory() {
        //given
        Task.Category category = WORK;
        Optional<Task> task = Optional.ofNullable(prepareDataToTests().getFirst());
        when(tasksRepository.findTasksByCategory(category)).thenReturn(task);

        //when
        Optional<Task> result = tasksService.writeAllTasksByCategory(category.toString());

        //then
        Assertions.assertNotNull(result);
        assertEquals(category, result.get().getCategory());
        verify(tasksRepository, times(1)).findTasksByCategory(category);
    }

    @Test
    public void shouldCreateSingleTask() {
        //given
        Task task = prepareDataToTests().getFirst();
        when(tasksRepository.save(task)).thenReturn(task);

        //When
        Task result = tasksService.createSingleTask(task);

        //Then
        assertEquals(result, task);
        verify(tasksRepository, times(1)).save(task);
    }

    @Test
    public void shouldWriteSingleTaskById() {
        //given
        int taskId = 1;
        Optional<Task> tasks = Optional.ofNullable(prepareDataToTests().getFirst());
        when(tasksRepository.findTaskById(taskId)).thenReturn(tasks);

        //when
        Optional<Task> result = tasksService.writeSingleTaskById(taskId);

        //then
        assertEquals(result, tasks);
        verify(tasksRepository, times(1)).findTaskById(taskId);
    }
    @Test
    public void shouldUpdateSingleTaskById() {
        //given
        Task existingTask = prepareDataToTests().getFirst();
        Task updatedTask = prepareDataToTests().get(1);
        int existingId = 0;
        when(tasksRepository.findTaskById(existingId)).thenReturn(Optional.of(existingTask));
        when(tasksRepository.save(updatedTask)).thenReturn(updatedTask);

        //when
        Task result = tasksService.updateSingleTaskById(existingId, updatedTask);

        //then
        Assertions.assertNotNull(result);
        assertEquals(updatedTask.getId(), result.getId());

        verify(tasksRepository, times(1)).findTaskById(existingId);
        verify(tasksRepository, times(1)).deleteById(existingId);
        verify(tasksRepository, times(1)).save(updatedTask);
    }
    @Test
    public void shouldUpdateByCreateSingleTaskById() {
        //given
        int notExistingId = 3;
        Task updatedTask = prepareDataToTests().get(1);
        when(tasksRepository.findTaskById(notExistingId)).thenReturn(null);

        //when
        Task result = tasksService.updateSingleTaskById(notExistingId, updatedTask);

        //then
        Assertions.assertNull(result);
        verify(tasksRepository, times(1)).findTaskById(notExistingId);
        verify(tasksRepository, never()).deleteById(anyInt());
    }
    private List<Task> prepareDataToTests(){
        return Arrays.asList(
                new Task(0, 1, "Create POST mapping", null, WORK,
                        Timestamp.valueOf(LocalDateTime.now()), Date.valueOf("2024-02-20"),
                        false,HIGH,null,null),

                new Task(1, 1, "Create rest CRUD mappings", "Really important things",
                        WORK, Timestamp.valueOf(LocalDateTime.now()), Date.valueOf("2024-02-24"),
                        false, HIGH, null,
                        Arrays.asList(
                                new Subtask(1, "PUT", false),
                                new Subtask(2, "DELETE", false),
                                new Subtask(2, "DELETE", false)
                        )
                ));
    }
}
