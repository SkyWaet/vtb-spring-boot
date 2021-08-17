package com.skywaet.vtbspringboot.services.impl;

import lombok.AllArgsConstructor;
import com.skywaet.vtbspringboot.products.Product;
import com.skywaet.vtbspringboot.services.FinancialService;
import com.skywaet.vtbspringboot.services.SalesService;
import com.skywaet.vtbspringboot.services.Storage;

@AllArgsConstructor
public class SalesServiceImpl implements SalesService {
    private final Storage storage;
    private final FinancialService financialService;

    @Override
    public boolean sell(Product product) {
        boolean approved = financialService.manageTransaction(product.getPrice());
        if (approved) {
            storage.remove(product);
        }
        return approved;
    }
}
