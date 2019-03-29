package name.ihorko.problems.problem_006__Sum_square_difference;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * Answer: 25164150
 */

public class Problem_006 {
    public static void main(String[] args) {
        System.out.println(squareOfSums(1, 100)-sumOfSquares(1, 100));
    }
    static int sumOfSquares(int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += i*i;
        }
        return sum;
    }
    static int squareOfSums(int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += i;
        }
        return sum*sum;
    }
}
