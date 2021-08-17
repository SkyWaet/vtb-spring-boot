package com.skywaet.vtbspringboot.services.impl;

import com.skywaet.vtbspringboot.events.sales.TransactionApprovedEvent;
import org.springframework.context.ApplicationListener;

import java.time.LocalDateTime;

public class FNSService implements ApplicationListener<TransactionApprovedEvent> {

    @Override
    public void onApplicationEvent(TransactionApprovedEvent event) {
        System.out.println(LocalDateTime.now() + "FNS: " + event.getMessage());
    }
}
