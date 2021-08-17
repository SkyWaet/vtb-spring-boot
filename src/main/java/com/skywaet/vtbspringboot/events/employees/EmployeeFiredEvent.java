package com.skywaet.vtbspringboot.events.employees;

import com.skywaet.vtbspringboot.events.BaseEvent;

public class EmployeeFiredEvent extends BaseEvent {
    public EmployeeFiredEvent(Object source, String msg) {
        super(source, msg);
    }
}
