package com.skywaet.vtbspringboot.events.employees;

import com.skywaet.vtbspringboot.events.BaseEvent;

public class EmployeeSalaryRaisedEvent extends BaseEvent {
    public EmployeeSalaryRaisedEvent(Object source, String msg) {
        super(source, msg);
    }
}
