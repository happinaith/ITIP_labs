import java.util.*;

class Product implements Comparable<Product> {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (Цена: " + price + ", Кол-во: " + quantity + ")";
    }
}

public class SalesTracker {
    private TreeSet<Product> soldProducts = new TreeSet<>();
    private Map<String, Integer> productPopularity = new HashMap<>();

    public void addSale(String name, double price, int quantity) {
        Product product = new Product(name, price, quantity);
        soldProducts.add(product);
        productPopularity.put(name, productPopularity.getOrDefault(name, 0) + quantity);
    }

    public void listSales() {
        System.out.println("Список проданных товаров:");
        for (Product product : soldProducts) {
            System.out.println(product);
        }
    }

    public double getTotalSales() {
        double total = 0;
        for (Product product : soldProducts) {
            total += product.getTotalPrice();
        }
        return total;
    }

    public String getMostPopularProduct() {
        return productPopularity.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Нет продаж");
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        // Пример добавления продаж
        tracker.addSale("Яблоко", 10.0, 3);
        tracker.addSale("Банан", 15.0, 2);
        tracker.addSale("Яблоко", 10.0, 1); // Популярность учитывается отдельно

        tracker.listSales();

        System.out.println("Общая сумма продаж: " + tracker.getTotalSales()); // 70.0
        System.out.println("Самый популярный товар: " + tracker.getMostPopularProduct()); // Яблоко
    }
}
