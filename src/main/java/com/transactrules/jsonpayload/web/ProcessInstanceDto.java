package com.transactrules.jsonpayload.web;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.Map;

@Data
public class ProcessInstanceDto {
    protected Long id;
    protected String businessKey;
    protected Map<String,String> variables;
    protected JsonNode data;
}
