package src.service;

import java.util.HashMap;
import java.util.Map;

import src.model.Bill;
import src.model.Person;

public class SplitService {

    private final BillService billService = new BillService();

    public Map<String, Double> splitEqually(Bill bill) {

        Map<String, Double> result = new HashMap<>();

        double total = billService.calculateGrandTotal(bill);

        double amountPerPerson = total / bill.getPeople().size();

        for (Person person : bill.getPeople()) {
            result.put(person.getName(), amountPerPerson);
        }

        return result;
    }

    public Map<String, Double> splitByConsumption(Bill bill) {

        Map<String, Double> result = new HashMap<>();

        double subtotal = billService.calculateSubtotal(bill);
        double grandTotal = billService.calculateGrandTotal(bill);

        for (Person person : bill.getPeople()) {

            double percentage = person.getTotalConsumption() / subtotal;
            double amount = grandTotal * percentage;

            result.put(person.getName(), amount);
        }

        return result;
    }
}