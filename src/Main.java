import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NumberFormat currency = NumberFormat.getCurrencyInstance();

        byte MONTHS_IN_YEAR = 12;
        byte PERCENT = 100;

        int principal;
        while(true) {
            System.out.print("Principal (1k - 1M): ");
            principal = scanner.nextInt();
            if (!(1000 <= principal) || !(principal <= 1_000_000))
                System.out.println("Enter a number between 1000 and 1000000");
            else
                break;
        }

        float interestRate;
        while(true) {
            System.out.print("Annual Interest Rate(%): ");
            interestRate = scanner.nextFloat();
            if (!(0 <= interestRate) || !(interestRate <= 30))
                System.out.println("Enter a number between 0 and 30");
            else
                break;
        }
        float monthlyInterestRate = (interestRate / PERCENT) / MONTHS_IN_YEAR;

        byte period;
        while(true) {
            System.out.print("Period(Years): ");
            period = scanner.nextByte();
            if (!(0 < period) || !(period <= 30))
                System.out.println("Enter a value between 1 and 30");
            else
                break;
        }
        int numberOfPayments = period * MONTHS_IN_YEAR;

        double mortgage = principal
                                * monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))
                                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        String formattedMortgage = currency.format(mortgage);

        System.out.println("Mortgage: " + formattedMortgage);
    }
}
