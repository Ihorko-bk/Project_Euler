package name.ihorko.problems.problem_005__Smallest_multiple;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * Answer: 232792560
 */

public class Problem_005 {
    public static void main(String[] args) {
        System.out.println(smallerDivNumber(2, 20));
    }
    static int smallerDivNumber(int from, int to) {
        int number = 0;
        Main:
        while (true) {
            number++;
            for (int i = from; i <= to; i++) {
                if (number%i != 0) continue Main;
            }
            return number;
        }
    }
}
