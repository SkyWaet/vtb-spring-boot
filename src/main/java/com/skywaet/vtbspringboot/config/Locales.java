package com.skywaet.vtbspringboot.config;

import lombok.Getter;

import java.util.Locale;

@Getter
public class Locales {
    private final Locale locale;

    public Locales(String lang, String country) {
        System.out.println(lang + " " + country);
        locale = new Locale(lang, country);
    }
}
