package com.hexagonal.tasks.infrastructure.repository;


import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.outputs.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.entities.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaTaskRepositoryAddapter implements TaskRepositoryPort {

    private final JpaTaskRepository jpaTaskRepository;

    public JpaTaskRepositoryAddapter(JpaTaskRepository jpaTaskRepository) {
        this.jpaTaskRepository = jpaTaskRepository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
        TaskEntity savedTaskEntity = jpaTaskRepository.save(taskEntity);

        return savedTaskEntity.toDomainModel();
    }

    @Override
    public Optional<Task> findById(Long taskId) {
        return jpaTaskRepository.findById(taskId).map(TaskEntity::toDomainModel);
    }

    @Override
    public List<Task> findAll() {
        return jpaTaskRepository.findAll().stream()
                .map(TaskEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> update(Task task) {
        if (jpaTaskRepository.existsById(task.getId())) {
            TaskEntity taskEntity = TaskEntity.fromDomainModel(task);
            TaskEntity updatedTaskEntity = jpaTaskRepository.save(taskEntity);
            return Optional.of(updatedTaskEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long taskId) {
        if (jpaTaskRepository.existsById(taskId)) {
            jpaTaskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }
}
