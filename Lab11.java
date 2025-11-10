//Lab Session:11 (Lambda Expressions and Functional Interfaces)
import java.util.*;

@FunctionalInterface
interface ProductSorter {
    void sort(List<Product> products);
}

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - ₹" + price;
    }
}

public class Lab11 {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
            new Product("Laptop", 60000),
            new Product("Headphones", 2000),
            new Product("Smartphone", 35000),
            new Product("Keyboard", 1500),
            new Product("Monitor", 12000)
        );

        System.out.println("Original List:");
        products.forEach(p -> System.out.println(p));

        ProductSorter sortByPrice = (list) -> {
            Collections.sort(list, (p1, p2) -> Double.compare(p1.price, p2.price));
        };

        ProductSorter sortByName = (list) -> {
            Collections.sort(list, (p1, p2) -> p1.name.compareToIgnoreCase(p2.name));
        };

        sortByPrice.sort(products);
        System.out.println("\nSorted by Price:");
        products.forEach(p -> System.out.println(p));

        sortByName.sort(products);
        System.out.println("\nSorted by Name:");
        products.forEach(p -> System.out.println(p));
    }
}
