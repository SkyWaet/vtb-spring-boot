package events.employees;

import employees.AbstractEmployee;
import events.BaseEvent;

public class EmployeeHiredEvent extends BaseEvent {
    public EmployeeHiredEvent(Object source, String msg) {
        super(source, msg);
    }
}
