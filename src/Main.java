import ro.ase.cts.exceptions.IdentifierValueException;
import ro.ase.cts.exceptions.InvalidPriceException;
import ro.ase.cts.exceptions.PercentageValueException;
import ro.ase.cts.exceptions.StringMinLength;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws StringMinLength, InvalidPriceException, PercentageValueException, IdentifierValueException {
        // write your code here
        OnlineShop onlineShop = new OnlineShop("Emag", "logo.jpg", new ArrayList<Product>());

        Product p1 = new Product("Laptop", 3200.5, 1, "1");
        Product p2 = new Product("Frigider", 207.95, 1, "2");

        Product p3 = new Product(p1);

        onlineShop.addProductToList(p1);
        onlineShop.removeProductList(p1);
        System.out.println(p1.equals(p2));
    }
}

class OnlineShop {
    private String name;
    private String image;
    private ArrayList<Product> products = new ArrayList<>();

    public OnlineShop(String name, String image, ArrayList<Product> products) {
        this.name = name;
        this.image = image;
        this.products = products;
    }

    public void addProductToList(Product product) {
        this.products.add(product);
    }

    public void removeProductList(Product product) {
        this.products.remove(product);
    }
}

class Product {
    private int id;
    private String name;
    private double price;
    private String description;

    public Product(String name, double price, int id, String description) throws StringMinLength, InvalidPriceException {
        if (name.length() >= 5) {
            this.name = name;
        } else {
            throw new StringMinLength();
        }

        if (price > 0) {
            this.price = price;
        } else {
            throw new InvalidPriceException();
        }

        this.id = id;
        this.description = description;
    }

    public Product(Product product) {
    }

    public boolean equals(Product product) {
        if ((product.id != this.id) && (!product.name.equals(this.name)) && (product.price != this.price)) {
            return false;
        }
        return true;
    }

    public void applyPercentageDiscount(float percentageDiscount) throws PercentageValueException {
        if (percentageDiscount > 0 && percentageDiscount <= 1) {
            this.price -= this.price * percentageDiscount;
        } else {
            throw new PercentageValueException();
        }

    }

    public void applyAmountDiscount(double discountAmount) throws PercentageValueException {
        if (discountAmount > 0) {
            this.price -= discountAmount;
        } else {
            throw new PercentageValueException();
        }

    }

    public void increasePricePercentage(float percentageIncrease) throws PercentageValueException {
        if (percentageIncrease > 0 && percentageIncrease <= 1) {
            this.price += this.price * percentageIncrease;
        } else {
            throw new PercentageValueException();
        }

    }

    public void increasePriceAmount(double increaseAmount) throws PercentageValueException {
        if (increaseAmount > 0) {
            this.price += increaseAmount;
        } else {
            throw new PercentageValueException();
        }

    }

}

class Cart {
    private ArrayList<Product> products;

    public Cart(ArrayList<Product> products) {
        this.products = products;
    }

    public void add(Product product) {
        products.add(product);
    }
}

class User {

    private String username;
    private int id;
    private String name;
    private ArrayList<Order> orderHistory;
    private Cart shoppingCart;

    public User(String username, int id, String name) throws StringMinLength, IdentifierValueException {
        if (username.length() >= 5) {
            this.username = username;
        } else {
            throw new StringMinLength();
        }
        if (id > 1) {
            this.id = id;
        } else {
            throw new IdentifierValueException();
        }
        if (name.length() > 10) {
            this.name = name;
        } else {
            throw new StringMinLength();
        }
    }

    public void addOrderToHistory(Order order) {
        this.orderHistory.add(order);
    }

    public void addProductToCart(Product product) {
        this.shoppingCart.add(product);
    }
}

class Order {
    private ArrayList<Product> products;
    private String address;

    public Order() {
        products = new ArrayList<Product>();
    }

    public void add(Product product) {
        if (products.size() > 99)
            return;

        products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }
}

class InventoryProduct {
    private Product product;
    private int quantity;

    public InventoryProduct(Product product, int quantity) throws StringMinLength, InvalidPriceException {
        this.product = new Product(product);
        this.quantity = quantity;
    }
}


