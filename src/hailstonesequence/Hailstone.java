package hailstonesequence;

public class Hailstone {

    private int input;
    private int number;
    private int highest;
    private int secondLargest;
    private int stepsCount;

    public Hailstone() {
        input = 1;
        number = 1;
        highest = 0;
        secondLargest = 0;
        stepsCount = 0;
    }

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

    public int getSteps() {
        return stepsCount;
    }

    public int getInputNumber() {
        return number;
    }

    public int getSecondLargest() {
        return secondLargest;
    }

    /**
     * Checks if the rightmost bit is 1 as it is for all odd numbers in binary
     * presentation
     *
     * @param number - s
     * @return true if number is odd, else false
     */
    public static boolean checkOdd(int number) {
        return ((number & 0x1) == 1);
    }
}
