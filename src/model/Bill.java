package src.model;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private final List<Person> people;
    private double serviceFeePercentage;
    private double deliveryFee;

    public Bill() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("Person cannot be null.");
        }

        people.add(person);
    }

    public List<Person> getPeople() {
        return people;
    }

    public double getServiceFeePercentage() {
        return serviceFeePercentage;
    }

    public void setServiceFeePercentage(double serviceFeePercentage) {

        if (serviceFeePercentage < 0) {
            throw new IllegalArgumentException("Service fee percentage cannot be negative.");
        }

        this.serviceFeePercentage = serviceFeePercentage;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {

        if (deliveryFee < 0) {
            throw new IllegalArgumentException("Delivery fee cannot be negative.");
        }

        this.deliveryFee = deliveryFee;
    }
}