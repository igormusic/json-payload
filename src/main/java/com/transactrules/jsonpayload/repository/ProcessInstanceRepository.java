package com.transactrules.jsonpayload.repository;

import com.transactrules.jsonpayload.model.ProcessInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessInstanceRepository extends JpaRepository<ProcessInstance,Long> {
}
