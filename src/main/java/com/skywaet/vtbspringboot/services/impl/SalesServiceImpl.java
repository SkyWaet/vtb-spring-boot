package services.impl;

import lombok.AllArgsConstructor;
import products.Product;
import services.FinancialService;
import services.SalesService;
import services.Storage;

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
