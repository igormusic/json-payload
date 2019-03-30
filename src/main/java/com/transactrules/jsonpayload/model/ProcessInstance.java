package com.transactrules.jsonpayload.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import javax.persistence.*;
import java.util.Map;

@Data
@Entity
public class ProcessInstance {
    @Id
    @GeneratedValue
    protected Long id;
    protected String businessKey;
    @ElementCollection
    @MapKeyColumn(name="key")
    @Column(name="value")
    //@CollectionTable(name="example_attributes", joinColumns=@JoinColumn(name="example_id"))
    protected Map<String,String> variables;
    @Lob
    protected String data;
}
