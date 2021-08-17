package com.skywaet.vtbspringboot.events.employees;

import com.skywaet.vtbspringboot.events.BaseEvent;

public class EmployeeHiredEvent extends BaseEvent {
    public EmployeeHiredEvent(Object source, String msg) {
        super(source, msg);
    }
}
