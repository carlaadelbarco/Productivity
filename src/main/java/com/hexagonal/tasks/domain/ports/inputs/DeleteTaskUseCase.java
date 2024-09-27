package com.hexagonal.tasks.domain.ports.inputs;

public interface DeleteTaskUseCase {

    boolean deleteTask(Long taskId);
}
