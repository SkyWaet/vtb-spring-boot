package events.sales;

import events.BaseEvent;

public class TransactionApprovedEvent extends BaseEvent {

    public TransactionApprovedEvent(Object source, String message) {
        super(source, message);
    }
}
