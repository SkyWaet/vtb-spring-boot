package com.skywaet.vtbspringboot.services.impl;

import com.skywaet.vtbspringboot.config.Locales;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import com.skywaet.vtbspringboot.services.CustomerService;

public class CustomerServiceImpl implements CustomerService, ApplicationContextAware {
    private ApplicationContext ctx;
    private Locales locales;

    @Override
    public void help() {
        System.out.println(ctx.getMessage("help", new Object[0], locales.getLocale()));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

    public void setLocales(Locales locales) {
        this.locales = locales;
    }
}
