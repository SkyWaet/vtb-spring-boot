package com.skywaet.vtbspringboot.services.impl;

import com.skywaet.vtbspringboot.config.Locales;
import com.skywaet.vtbspringboot.events.BaseEvent;
import com.skywaet.vtbspringboot.events.products.ProductAddedEvent;
import com.skywaet.vtbspringboot.events.products.ProductLimitReachedEvent;
import com.skywaet.vtbspringboot. events.products.ProductRemovedEvent;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import com.skywaet.vtbspringboot.products.Product;
import com.skywaet.vtbspringboot.services.Storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
public class SetStorage implements Storage, ApplicationEventPublisherAware, ApplicationContextAware {

    private final Set<Product> storage = new HashSet<>();
    private int limit;
    private ApplicationEventPublisher publisher;
    private ApplicationContext ctx;
    private Locales locale;

    @Override
    public List<Product> get() {
        return new ArrayList<>(storage);
    }

    @Override
    public boolean add(Product product) {
        if (storage.size() < limit) {
            BaseEvent event = new ProductAddedEvent(this, ctx.getMessage("addProduct", new String[]{product.getName()}, locale.getLocale()));
            publisher.publishEvent(event);
            return storage.add(product);
        }
        BaseEvent event = new ProductLimitReachedEvent(this, ctx.getMessage("limit", new Object[0], locale.getLocale()));
        publisher.publishEvent(event);
        return false;
    }

    @Override
    public void remove(Product product) {
        storage.remove(product);
        BaseEvent event = new ProductRemovedEvent(this, ctx.getMessage("removeProduct", new String[]{product.getName()}, locale.getLocale()));
        publisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
