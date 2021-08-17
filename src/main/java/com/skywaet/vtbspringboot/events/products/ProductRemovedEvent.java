package com.skywaet.vtbspringboot.events.products;

import com.skywaet.vtbspringboot.events.BaseEvent;

public class ProductRemovedEvent extends BaseEvent {

    public ProductRemovedEvent(Object source, String msg) {
        super(source, msg);
    }
}
