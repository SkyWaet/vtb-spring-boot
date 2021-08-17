package com.skywaet.vtbspringboot.employees.impl;

import com.skywaet.vtbspringboot.employees.AbstractEmployee;

import lombok.ToString;

@ToString(callSuper = true)
public class RegularEmployee extends AbstractEmployee {


    public RegularEmployee(String name, String surname, double salary) {
        super(name, surname, salary);
    }

    @Override
    public void work() {
        System.out.println("Работаю");
    }

    @Override
    public void help() {
        System.out.println("Помогаю");
    }

    @Override
    public void setSalary(double sum) {
        salary = salary == 0 ? sum : salary + sum;
    }
}
