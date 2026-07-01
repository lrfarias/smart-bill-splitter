package src.service;

import src.model.Bill;
import src.model.Person;

public class BillService {

    public double calculateSubtotal(Bill bill) {

        double subtotal = 0;

        for (Person person : bill.getPeople()) {
            subtotal += person.getTotalConsumption();
        }

        return subtotal;
    }

    public double calculateServiceFee(Bill bill) {
        return calculateSubtotal(bill)
                * bill.getServiceFeePercentage() / 100;
    }

    public double calculateGrandTotal(Bill bill) {

        return calculateSubtotal(bill)
                + calculateServiceFee(bill)
                + bill.getDeliveryFee();
    }
}