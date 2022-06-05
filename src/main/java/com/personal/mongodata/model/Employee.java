package com.personal.mongodata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Employee {

    @Id
    private String id;
    private String name;
    private Integer age;
    private BigDecimal salary;
    @DBRef
    private Employee boss;
}
