package com.hexagonal.tasks.infrastructure.config;

import com.hexagonal.tasks.application.services.TrackerTaskService;
import com.hexagonal.tasks.application.usecases.*;
import com.hexagonal.tasks.domain.ports.inputs.GetAdditionalTaskInfoUseCase;
import com.hexagonal.tasks.domain.ports.outputs.ExternalServicePort;
import com.hexagonal.tasks.domain.ports.outputs.TaskRepositoryPort;
import com.hexagonal.tasks.infrastructure.adapters.ExternalServiceAddapter;
import com.hexagonal.tasks.infrastructure.repository.JpaTaskRepositoryAddapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TrackerTaskService trackerTaskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TrackerTaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAddapter jpaTaskRepositoryAddapter) {
        return jpaTaskRepositoryAddapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAddapter();
    }
}