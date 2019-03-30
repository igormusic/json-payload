package com.transactrules.jsonpayload.service;

import com.transactrules.jsonpayload.model.ProcessInstance;

import java.util.Optional;

public interface ProcessInstanceService {
    ProcessInstance create(ProcessInstance instance);
    Optional<ProcessInstance> findById(Long id);
}
