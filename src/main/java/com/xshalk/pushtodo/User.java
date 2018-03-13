package com.xshalk.pushtodo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Calendar;


@Data
@AllArgsConstructor
public class User {
    
    private String name;
    
    private String email;
    
    private Calendar date;



}
