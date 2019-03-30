package com.transactrules.jsonpayload.service;

import com.transactrules.jsonpayload.model.ProcessInstance;
import com.transactrules.jsonpayload.repository.ProcessInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcessInstanceServiceImpl implements ProcessInstanceService {
    private final ProcessInstanceRepository repository;

    @Autowired
    public ProcessInstanceServiceImpl(ProcessInstanceRepository repository){
        this.repository = repository;
    }

    @Override
    public ProcessInstance create(ProcessInstance instance) {
        return repository.save(instance);
    }

    @Override
    public Optional<ProcessInstance> findById(Long id) {
        return repository.findById(id);
    }
}
