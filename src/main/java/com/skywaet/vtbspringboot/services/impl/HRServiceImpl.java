package com.skywaet.vtbspringboot.services.impl;

import com.skywaet.vtbspringboot.config.Locales;
import com.skywaet.vtbspringboot.employees.AbstractEmployee;
import com.skywaet.vtbspringboot.events.BaseEvent;
import com.skywaet.vtbspringboot.events.employees.EmployeeFiredEvent;
import com.skywaet.vtbspringboot.events.employees.EmployeeHiredEvent;
import com.skywaet.vtbspringboot.events.employees.EmployeeSalaryRaisedEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import com.skywaet.vtbspringboot.services.HRService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class HRServiceImpl implements HRService, ApplicationEventPublisherAware, ApplicationContextAware {

    private final List<AbstractEmployee> staff = new ArrayList<>();
    private ApplicationEventPublisher publisher;
    private ApplicationContext ctx;
    private Locales locales;

    @Override
    public void hire(AbstractEmployee e) {
        staff.add(e);
        BaseEvent event = new EmployeeHiredEvent(this, ctx.getMessage("hiring", new String[]{
                e.getName() + " " + e.getSurname()
        }, locales.getLocale()));
        publisher.publishEvent(event);
    }

    @Override
    public void fire(AbstractEmployee e) {
        staff.remove(e);
        BaseEvent event = new EmployeeFiredEvent(this, ctx.getMessage("firing", new String[]{
                e.getName() + " " + e.getSurname()
        }, locales.getLocale()));
        publisher.publishEvent(event);
    }

    @Override
    public void raiseSalary(AbstractEmployee e, double sum) {
        staff.get(staff.indexOf(e)).setSalary(sum);
        BaseEvent event = new EmployeeSalaryRaisedEvent(this, ctx.getMessage("raising", new String[]{
                e.getName() + " " + e.getSurname(), Double.valueOf(sum).toString()
        }, locales.getLocale()));
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

    @Autowired
    public void setLocales(Locales locales) {
        this.locales = locales;
    }
}
