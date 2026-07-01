package src.app;

import java.util.Map;

import src.model.Bill;
import src.model.Item;
import src.model.Person;
import src.service.BillService;
import src.service.SplitService;

public class Main {

    public static void main(String[] args) {

        Person john = new Person("John");
        john.addItem(new Item("Burger", 35.0));
        john.addItem(new Item("Soda", 10.0));

        Person mary = new Person("Mary");
        mary.addItem(new Item("Pizza", 60.0));

        Bill bill = new Bill();

        bill.addPerson(john);
        bill.addPerson(mary);

        // Agora a taxa de serviço é uma porcentagem
        bill.setServiceFeePercentage(10.0);
        bill.setDeliveryFee(20.0);

        BillService billService = new BillService();

        System.out.printf("Subtotal: R$ %.2f%n",
                billService.calculateSubtotal(bill));

        System.out.printf("Grand Total: R$ %.2f%n",
                billService.calculateGrandTotal(bill));

        SplitService splitService = new SplitService();

        Map<String, Double> result = splitService.splitByConsumption(bill);

        System.out.println();

        for (Map.Entry<String, Double> entry : result.entrySet()) {
            System.out.printf("%s pays: R$ %.2f%n",
                    entry.getKey(),
                    entry.getValue());
        }
    }
}