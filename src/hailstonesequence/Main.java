package hailstonesequence;

import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give a number:");
        int input = scanner.nextInt();

        Hailstone hailstone = new Hailstone(input);
        hailstone.calculate();

        System.out.println("The input number: " + hailstone.getInputNumber());
        System.out.println("The number of steps to number 1: " + hailstone.getSteps());
        System.out.println("The second largest number is: " + hailstone.getSecondLargest());
    }
}
