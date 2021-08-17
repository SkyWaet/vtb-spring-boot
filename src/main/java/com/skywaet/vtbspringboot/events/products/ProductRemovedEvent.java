package events.products;

import events.BaseEvent;

public class ProductRemovedEvent extends BaseEvent {

    public ProductRemovedEvent(Object source, String msg) {
        super(source, msg);
    }
}
