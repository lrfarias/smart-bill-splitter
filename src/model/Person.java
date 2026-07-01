package src.model;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    private final List<Item> items;

    public Person(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public double getTotalConsumption() {
        double total = 0.0;

        for (Item item : items) {
            total += item.getPrice();
        }

        return total;
    }
}