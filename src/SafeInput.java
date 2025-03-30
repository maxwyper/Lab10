import java.util.Scanner;

public class SafeInput {


    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int input = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            if (console.hasNextInt()) {
                input = console.nextInt();
                if (input >= low && input <= high) {
                    valid = true;
                } else {
                    System.out.println("Input is out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                console.next();
            }
        }
        return input;
    }


    public static boolean getYNConfirm(Scanner console, String prompt) {
        System.out.print(prompt);
        String input = console.next().toLowerCase();
        return input.equals("y");
    }
}
