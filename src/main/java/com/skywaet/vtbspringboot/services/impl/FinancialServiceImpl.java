package com.skywaet.vtbspringboot.services.impl;

import com.skywaet.vtbspringboot.config.Locales;
import com.skywaet.vtbspringboot.events.BaseEvent;
import com.skywaet.vtbspringboot.events.sales.TransactionApprovedEvent;
import com.skywaet.vtbspringboot.events.sales.TransactionRejectedEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import com.skywaet.vtbspringboot.services.FinancialService;

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
