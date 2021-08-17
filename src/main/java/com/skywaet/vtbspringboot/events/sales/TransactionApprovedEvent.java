package com.skywaet.vtbspringboot.events.sales;

import com.skywaet.vtbspringboot.events.BaseEvent;

public class TransactionApprovedEvent extends BaseEvent {

    public TransactionApprovedEvent(Object source, String message) {
        super(source, message);
    }
}
