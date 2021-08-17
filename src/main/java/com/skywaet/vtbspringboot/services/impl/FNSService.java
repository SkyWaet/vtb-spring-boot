package com.skywaet.vtbspringboot.services.impl;

import com.skywaet.vtbspringboot.events.sales.TransactionApprovedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FNSService implements ApplicationListener<TransactionApprovedEvent> {

    @Override
    public void onApplicationEvent(TransactionApprovedEvent event) {
        System.out.println(LocalDateTime.now() + "FNS: " + event.getMessage());
    }
}
