package com.skywaet.vtbspringboot.services.impl;

import com.skywaet.vtbspringboot.config.Locales;
import com.skywaet.vtbspringboot.events.BaseEvent;
import com.skywaet.vtbspringboot.services.Logger;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor
@Component
public class ConsoleLogger implements Logger, ApplicationListener<BaseEvent>, ApplicationContextAware {

    private ApplicationContext ctx;

    private Locales locales;

    @Autowired
    public void setLocales(Locales locales) {
        this.locales = locales;
    }


    @Override
    public void log(Object o) {
        System.out.println("" + LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ofPattern("yyyy-mm-dd hh:MM:ss")) + " " + ctx.getMessage("log", new Object[0], locales.getLocale()) + ": " + o);
    }

    @Override
    public void onApplicationEvent(BaseEvent event) {
        log(event.getMessage());
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }
}
