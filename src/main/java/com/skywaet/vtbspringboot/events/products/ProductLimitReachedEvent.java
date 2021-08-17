package events.products;

import events.BaseEvent;

public class ProductLimitReachedEvent extends BaseEvent {
    public ProductLimitReachedEvent(Object source, String msg) {
        super(source, msg);
    }
}
