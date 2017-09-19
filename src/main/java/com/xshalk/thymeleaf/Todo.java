package com.xshalk.thymeleaf;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer Id;
    
    private String name;
    
    private String description;
    
    private Date endTime;
    
    private Date startTime;


    public Todo() {
        super();
    }


    public Todo(Integer id, String name, String description, Date endTime, Date startTime) {
        super();
        Id = id;
        this.name = name;
        this.description = description;
        this.endTime = endTime;
        this.startTime = startTime;
    }


    public Integer getId() {
        return Id;
    }


    public void setId(Integer id) {
        Id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public Date getEndTime() {
        return endTime;
    }


    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public Date getStartTime() {
        return startTime;
    }


    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    
}
