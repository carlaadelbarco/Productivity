package com.hexagonal.tasks.domain.ports.inputs;

import com.hexagonal.tasks.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {

    Optional<Task> retrieveTask(Long taskId);

    List<Task> retrieveAllTasks();

}
