package hailstonesequence;

public class Hailstone {

    private int input;
    private int number;
    private int highest;
    private int secondLargest;
    private int stepsCount;

    /**
     * Constructor without parameters. Initializes private variables.
     */
    public Hailstone() {
        input = 1;
        number = 1;
        highest = 0;
        secondLargest = 0;
        stepsCount = 0;
    }

    /**
     * Calculates Hailstone sequence for given number.
     * @param input - number for which hailstone sequence will be calculated.
     */
    public void calculate(int input) {
        if (input < 1000000) {
            number = input;
            highest = input;

            while (number > 1) {

                if (checkOdd(number)) {    // if number is odd
                    number = 3 * number + 1;

                } else {                // if number is even  
                    number /= 2;
                }

                if (number > highest) {
                    secondLargest = highest;
                    highest = number;
                } else if (number < highest && number > secondLargest) {
                    secondLargest = number;
                }

                stepsCount++;
            }
        }
    }

    /**
     *
     * @return the number of steps it took to reach 1
     */
    public int getSteps() {
        return stepsCount;
    }

    /**
     *
     * @return the input number
     */
    public int getInputNumber() {
        return number;
    }

    /**
     *
     * @return second largest number in the sequence
     */
    public int getSecondLargest() {
        return secondLargest;
    }

    /**
     * Checks if the rightmost bit is 1 as it is for all odd numbers in binary
     * presentation
     *
     * @param number - 
     * @return true if number is odd, else false
     */
    public static boolean checkOdd(int number) {
        return ((number & 0x1) == 1);
    }
}
