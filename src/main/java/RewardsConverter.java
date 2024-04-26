import java.util.Scanner;

public class RewardsConverter {
    public static void main(String[] args) {
        System.out.println("Welcome to the Credit Card Rewards Converter!");
        System.out.println("Press 1 to convert cash to miles.");
        System.out.println("Press 2 to convert miles to cash.");
        var scanner = new Scanner(System.in);
        var option = scanner.nextLine();
        if (option.toString().equals("1")) {
            System.out.println("Please enter a cash value to convert to airline miles: ");
            var input = scanner.nextLine();
            double cashValue;
            try {
                cashValue = Double.parseDouble(input);
            } catch (NumberFormatException exception) {
                System.out.println("Could not parse input value as a double, exiting");
                scanner.close();
                return;
            }
            System.out.println("converting $" + input + " to miles");
            var rewardsValue = new RewardValue(cashValue);
            System.out.println("$" + input + " is worth " + rewardsValue.getMilesValue() + " miles");
        } else if (option.toString().equals("2")) {
            System.out.println("Please enter an airline miles to convert to cash value: ");
            var input = scanner.nextLine();
            int milesValue;
            try {
                milesValue = Integer.parseInt(input);
            } catch (NumberFormatException exception) {
                System.out.println("Could not parse input value as an integer, exiting");
                scanner.close();
                return;
            }
            System.out.println("converting " + input + " miles to $");
            var rewardsValue = new RewardValue(milesValue);
            System.out.println(input + " miles is worth $" + String.format("%.2f",rewardsValue.getCashValue()));
        } else {
            System.out.println("Invalid input. Exiting");
            return;
        }
        scanner.close();
    }

}