package com.hexagonal.tasks.domain.ports.inputs;

import com.hexagonal.tasks.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {

    Optional<Task> updateTask(Long taskId, Task updateTask);

}
