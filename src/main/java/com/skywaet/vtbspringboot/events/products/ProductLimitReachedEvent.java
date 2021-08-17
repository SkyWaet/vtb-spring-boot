package com.skywaet.vtbspringboot.events.products;

import com.skywaet.vtbspringboot.events.BaseEvent;

public class ProductLimitReachedEvent extends BaseEvent {
    public ProductLimitReachedEvent(Object source, String msg) {
        super(source, msg);
    }
}
