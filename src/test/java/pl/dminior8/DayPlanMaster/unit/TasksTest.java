package pl.dminior8.DayPlanMaster.unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import pl.dminior8.DayPlanMaster.Model.Subtasks;
import pl.dminior8.DayPlanMaster.Model.Tasks;
import pl.dminior8.DayPlanMaster.Repository.TasksRepository;
import pl.dminior8.DayPlanMaster.Service.TasksService;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static pl.dminior8.DayPlanMaster.Model.Tasks.Category.WORK;
import static pl.dminior8.DayPlanMaster.Model.Tasks.Priority.HIGH;

@SpringBootTest
class TasksTest {

    @Mock
    private TasksRepository tasksRepository;

    @InjectMocks
    private TasksService tasksService;

    @Test
    void testAllTasks() {
        Tasks.Category category = WORK;
        // Arrange
        List<Tasks> mockTasksList = Arrays.asList(
                new Tasks(1, 1, "Create POST mapping", null, WORK,
                        Timestamp.valueOf(LocalDateTime.now()), Date.valueOf("2024-02-20"),
                        false,HIGH,null,null),
                new Tasks(1, 1, "Create rest CRUD mappings", "Really important things",
                        WORK, Timestamp.valueOf(LocalDateTime.now()), Date.valueOf("2024-02-24"),
                        false, HIGH, null,
                        Arrays.asList(
                        new Subtasks(1, "PUT", false),
                        new Subtasks(2, "DELETE", false),
                        new Subtasks(2, "DELETE", false)
                        )
        ));

        when(tasksRepository.findAll()).thenReturn(mockTasksList);

        // Act
        List<Tasks> result = tasksService.allTasks();

        // Assert
        assertEquals(2, result.size());
        assertEquals("Create POST mapping", result.getFirst().getTitle());
        assertEquals(category, result.get(0).getCategory());
        assertEquals(3, result.get(1).getSubtasks().size());
        assertEquals(category, result.get(1).getCategory());

        // Verify
        verify(tasksRepository, times(1)).findAll();
    }

    @Test
    void testAllTasksByCategory() {
        Tasks.Category category = WORK;
        // Arrange
        Tasks mockTask = new Tasks(1, 1, "Create POST mapping", null, category,
                Timestamp.valueOf(LocalDateTime.now()), Date.valueOf("2024-02-20"),
                false,HIGH,null,null);

        when(tasksRepository.findTasksByCategory(category)).thenReturn(Optional.of(mockTask));

        // Act
        Optional<Tasks> result = tasksService.allByCategory(category.toString());

        // Assert
        Assertions.assertTrue(result.isPresent());
        assertEquals(category, result.get().getCategory());

        // Verify
        verify(tasksRepository, times(1)).findTasksByCategory(category);
    }
}
