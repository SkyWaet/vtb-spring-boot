package events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public abstract class BaseEvent extends ApplicationEvent {
    protected String message;

    public BaseEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

}
