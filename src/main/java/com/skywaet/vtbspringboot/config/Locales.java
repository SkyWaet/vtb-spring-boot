package com.skywaet.vtbspringboot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Getter
@Component
public class Locales {
    private final Locale locale;

    public Locales(@Value("${language}") String lang, @Value("${country}") String country) {
        locale = new Locale(lang, country);
    }
}
