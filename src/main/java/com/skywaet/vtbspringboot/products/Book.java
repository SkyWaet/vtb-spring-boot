package products;

import lombok.Getter;
import lombok.ToString;

@Getter

public class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return String.format("Book name = %s, price = %f", name, price);
    }
}
