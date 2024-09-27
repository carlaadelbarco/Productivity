package com.hexagonal.tasks.domain.ports.inputs;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {

    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);


}
