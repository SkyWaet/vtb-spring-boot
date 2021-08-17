package events.sales;

import events.BaseEvent;
import lombok.Getter;

@Getter
public class TransactionRejectedEvent extends BaseEvent {

    public TransactionRejectedEvent(Object source, String message) {
        super(source, message);
    }
}
