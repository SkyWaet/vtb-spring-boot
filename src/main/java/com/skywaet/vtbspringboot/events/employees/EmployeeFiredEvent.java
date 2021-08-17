package events.employees;

import events.BaseEvent;

public class EmployeeFiredEvent extends BaseEvent {
    public EmployeeFiredEvent(Object source, String msg) {
        super(source, msg);
    }
}
