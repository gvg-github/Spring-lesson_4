package ru.gvg.spring.database.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gvg.spring.database.entity.Task;
import ru.gvg.spring.database.repository.TaskRepository;

import java.util.List;

/**
 * @author Denis Volnenko
 */

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public Task createTask(@NotNull final String name) {
        final Task task = new Task();
        task.setName(name);
        taskRepository.save(task);
        return task;
    }

    public List<Task> getListTask() {
        return taskRepository.findAll();
    }

    @Transactional
    public Task removeTaskById(@Nullable final String taskId) {
        if (taskId == null || taskId.isEmpty()) return null;
        final Task task = taskRepository.getOne(taskId);
        taskRepository.delete(task);
        return task;
    }

}
