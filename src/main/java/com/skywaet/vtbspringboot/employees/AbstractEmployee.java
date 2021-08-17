package com.skywaet.vtbspringboot.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public abstract class AbstractEmployee {

    protected String name;
    protected String surname;
    protected double salary;

    public abstract void work();

    public abstract void help();
}
