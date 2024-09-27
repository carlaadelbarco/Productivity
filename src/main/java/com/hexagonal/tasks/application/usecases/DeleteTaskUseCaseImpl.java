package com.hexagonal.tasks.application.usecases;

import com.hexagonal.tasks.domain.ports.inputs.DeleteTaskUseCase;
import com.hexagonal.tasks.domain.ports.outputs.TaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }


    @Override
    public boolean deleteTask(Long taskId) {
        return taskRepositoryPort.deleteById(taskId);
    }
}
