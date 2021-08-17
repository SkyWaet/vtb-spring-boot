package com.skywaet.vtbspringboot;

import com.skywaet.vtbspringboot.config.Config;
import com.skywaet.vtbspringboot.employees.AbstractEmployee;
import com.skywaet.vtbspringboot.products.Book;
import com.skywaet.vtbspringboot.products.Product;
import com.skywaet.vtbspringboot.services.Logger;
import com.skywaet.vtbspringboot.services.impl.ConsoleLogger;
import com.skywaet.vtbspringboot.shop.Shop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.io.UnsupportedEncodingException;
import java.util.List;

@SpringBootApplication
@Import(Config.class)
public class VtbSpringBootApplication {

    public static void main(String[] args) {

        final ConfigurableApplicationContext ctx = SpringApplication.run(VtbSpringBootApplication.class, args);
        Shop shop = ctx.getBean(Shop.class);
        for (int i = 0; i < 6; i++) {
            Product book = new Book("name" + i, 1.0);
            shop.addProduct(book);
        }
        Product book1 = new Book("дешевая книга", 20);
        shop.addProduct(book1);
        Product book2 = new Book("дорогая книга", 1000);
        Logger log = ctx.getBean(ConsoleLogger.class);

        try {
            log.log(shop.getProducts());
            shop.sell(book1);
            shop.sell(book2);
            log.log(shop.getProducts());
            for (int i = 1; i < 5; i++) {
                AbstractEmployee e = shop.hire("John" + i, "Johnson" + i);
            }
            List<AbstractEmployee> staff = shop.getStaff();
            log.log(staff);
            shop.fire(staff.get(0));
            shop.raiseSalary(staff.get(0));
            shop.help();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
