package interraction;

import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);

    public String inputCurrencyName() {
        try {
            System.out.println("Wpisz kod waluty( 3 litery) którą chcesz przeliczyć na złotówki (PLN):");
            return input.nextLine();

        } catch (Exception e) {
        }
        return "Wprowadziłeś niepoprawne dane";
    }

    public double inputCashAmount() {
        try {
            System.out.println("Podaj ilość gotówki jaką chcesz przeliczyć:");
            return input.nextDouble();

        } catch (Exception e) {
        }
        return 0;
    }
}
