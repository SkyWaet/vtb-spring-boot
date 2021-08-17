package com.skywaet.vtbspringboot.events.products;

import com.skywaet.vtbspringboot.events.BaseEvent;

public class ProductAddedEvent extends BaseEvent {

    public ProductAddedEvent(Object source, String msg) {
        super(source, msg);
    }
}
