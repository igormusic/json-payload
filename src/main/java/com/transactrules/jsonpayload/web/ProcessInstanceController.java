package com.transactrules.jsonpayload.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.transactrules.jsonpayload.model.ProcessInstance;
import com.transactrules.jsonpayload.service.ProcessInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(path="/instances")
public class ProcessInstanceController {

    private final ProcessInstanceService service;

    @Autowired
    public ProcessInstanceController(ProcessInstanceService service){
        this.service = service;
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> findById( @PathVariable("id") Long id){
        Optional<ProcessInstance> instance = service.findById(id);

        if(!instance.isPresent()){
            return new ResponseEntity<>(null,  HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(getDto(instance.get()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody ProcessInstanceDto dto ) {

        if (dto == null)
        {
            return new ResponseEntity<>(null,  HttpStatus.EXPECTATION_FAILED);
        }

        ProcessInstance instance = getProcessInstance(dto);

        instance= service.create(instance);

        return new ResponseEntity<>(getDto(instance), HttpStatus.CREATED);
    }

    private ProcessInstance getProcessInstance(ProcessInstanceDto dto) {
        ProcessInstance instance = new ProcessInstance();

        instance.setBusinessKey(dto.businessKey);
        instance.setVariables(dto.variables);
        instance.setData(dto.data.toString());
        return instance;
    }

    private ProcessInstanceDto getDto(@RequestBody ProcessInstance instance) {
        ProcessInstanceDto dto = new ProcessInstanceDto();

        ObjectMapper mapper = new ObjectMapper();

        dto.setBusinessKey(instance.getBusinessKey());
        dto.setVariables(instance.getVariables());
        dto.setId(instance.getId());

        try {
            dto.setData(mapper.readTree(instance.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dto;
    }


}
