package com.skywaet.vtbspringboot.config;

import com.skywaet.vtbspringboot.services.*;
import com.skywaet.vtbspringboot.services.impl.*;
import com.skywaet.vtbspringboot.shop.Shop;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class Config {
    @Value("${language}")
    public String language;

    @Value("${country}")
    public String country;

    @Bean
    public Locales locale() {
        return new Locales(language, country);
    }

    @Bean
    public FinancialService financialService(Locales locale) {
        FinancialServiceImpl service = new FinancialServiceImpl();
        service.setLocale(locale);
        return service;
    }

    @Bean
    public Storage storage(Locales locales) {
        SetStorage storage = new SetStorage();
        storage.setLocale(locales);
        storage.setLimit(10);
        return storage;
    }

    @Bean
    public HRService hrService(Locales locales) {
        HRServiceImpl service = new HRServiceImpl();
        service.setLocales(locales);
        return service;
    }

    @Bean
    public CustomerService csService(Locales locales) {
        CustomerServiceImpl service = new CustomerServiceImpl();
        service.setLocales(locales);
        return service;
    }

    @Bean
    public SalesService salesService(Storage storage, FinancialService financialService) {
        return new SalesServiceImpl(storage, financialService);
    }

    @Bean
    public Logger logger(Locales locales) {
        ConsoleLogger logger = new ConsoleLogger();
        logger.setLocales(locales);
        return logger;
    }

    @Bean
    public Shop shop(CustomerService cs, HRService hrs, Storage storage, SalesService salesService) {
        return new Shop(storage, cs, hrs, salesService);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:l10n");
        return messageSource;
    }
}
