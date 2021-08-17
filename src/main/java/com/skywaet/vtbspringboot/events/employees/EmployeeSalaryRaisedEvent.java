package events.employees;

import employees.AbstractEmployee;
import events.BaseEvent;

public class EmployeeSalaryRaisedEvent extends BaseEvent {
    public EmployeeSalaryRaisedEvent(Object source, String msg) {
        super(source, msg);
    }
}
