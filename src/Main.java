import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        byte MONTHS_IN_YEAR = 12;
        byte PERCENT = 100;

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate(%): ");
        float interestRate = scanner.nextFloat();
        float monthlyInterestRate = (interestRate / PERCENT) / MONTHS_IN_YEAR;

        System.out.print("Period(Years): ");
        byte period = scanner.nextByte();
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = principal
                                * monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))
                                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String formattedMortgage = currency.format(mortgage);

        System.out.println("Mortgage: " + formattedMortgage);
    }
}
