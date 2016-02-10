package hailstonesequence;

public class Hailstone {

    private int input;
    private int number;
    private int largest;
    private int secondLargest;
    private int stepsCount;

    /**
     * Constructor which initializes private variables.
     *
     * @param input - number for which Hailstone sequence will be calculated.
     */
    public Hailstone(int input) {
        this.input = input;
        number = 1;
        largest = 0;
        secondLargest = 0;
        stepsCount = 0;
    }

    /**
     * Calculates Hailstone sequence. First checks that input number is less
     * than 1 000 000 and then sets variables number and largest both to be
     * input. In while-loop checks with isOdd-function if current number is even
     * or odd and calculates next number depending on it. After that calls
     * checkValue-function with calculated number to decide if number is largest
     * or second largest this far. Finally increases number of steps took this
     * far.
     *
     */
    public void calculate() {
        number = input;
        largest = input;

        while (number > 1) {

            if (isOdd(number)) {    // if number is odd
                number = 3 * number + 1;
            } else {               // if number is even  
                number /= 2;
            }

            checkValue(number);
            stepsCount++;
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
        return input;
    }

    /**
     *
     * @return second largest number in the sequence
     */
    public int getSecondLargest() {
        return secondLargest;
    }

    /**
     * Checks value of given number and changes largest- and/or second largest-
     * variables accordingly.
     *
     * @param number
     */
    private void checkValue(int number) {
        if (number > largest) {
            secondLargest = largest;
            largest = number;
        } else if (number < largest && number > secondLargest) {
            secondLargest = number;
        }
    }

    /**
     * Checks if given number is odd by checking if the rightmost bit is 1.
     *
     * @param number - given number to be checked
     * @return true if number is odd, else false
     */
    private static boolean isOdd(int number) {
        return ((number & 0x1) == 1);
    }
}
