package events.products;

import events.BaseEvent;

public class ProductAddedEvent extends BaseEvent {

    public ProductAddedEvent(Object source, String msg) {
        super(source, msg);
    }
}
