package com.example.stream_api.model;

import java.time.LocalDate;
import java.time.Period;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private String email;
    private String job;
    private String gender;
    private String city;
    private int salary;
    private LocalDate birthdate;

    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
    
}