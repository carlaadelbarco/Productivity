package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.inputs.RetrieveTaskUseCase;
import com.hexagonal.tasks.domain.ports.outputs.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepository;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Optional<Task> retrieveTask(Long taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public List<Task> retrieveAllTasks() {
        return taskRepository.findAll();
    }
}
