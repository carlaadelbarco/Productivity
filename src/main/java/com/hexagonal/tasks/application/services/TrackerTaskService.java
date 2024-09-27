package com.hexagonal.tasks.application.services;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.inputs.*;

import java.util.List;
import java.util.Optional;

public class TrackerTaskService implements CreateTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    public TrackerTaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase,
                              UpdateTaskUseCase updateTaskUseCase, DeleteTaskUseCase deleteTaskUseCase,
                              GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public Optional<Task> retrieveTask(Long taskId) {
        return retrieveTaskUseCase.retrieveTask(taskId);
    }

    @Override
    public List<Task> retrieveAllTasks() {
        return retrieveTaskUseCase.retrieveAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return updateTaskUseCase.updateTask(id, updatedTask);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(taskId);
    }


}