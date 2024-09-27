package com.hexagonal.tasks.domain.ports.inputs;

import com.hexagonal.tasks.domain.models.Task;

public interface CreateTaskUseCase {

    Task createTask(Task task);

}
