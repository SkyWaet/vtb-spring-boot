package services.impl;

import config.Locales;
import events.BaseEvent;
import events.sales.TransactionApprovedEvent;
import events.sales.TransactionRejectedEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import services.FinancialService;

public class FinancialServiceImpl implements FinancialService, ApplicationEventPublisherAware, ApplicationContextAware {
    private ApplicationEventPublisher publisher;
    private ApplicationContext ctx;
    private Locales locale;

    @Override
    public boolean manageTransaction(double sum) {
        boolean success = sum < 100.0;
        BaseEvent event;
        if (success) {
            event = new TransactionApprovedEvent(this, ctx.getMessage("successful", new String[]{Double.valueOf(sum).toString()}, locale.getLocale()));
        } else {
            event = new TransactionRejectedEvent(this, ctx.getMessage("rejected", new Double[]{sum}, locale.getLocale()));

        }
        publisher.publishEvent(event);
        return success;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public void setLocale(Locales locale) {
        this.locale = locale;
    }
}
