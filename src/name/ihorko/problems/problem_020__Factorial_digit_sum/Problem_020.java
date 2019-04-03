package name.ihorko.problems.problem_020__Factorial_digit_sum;

import java.math.BigInteger;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 *
 * Find the sum of the digits in the number 100!
 *
 * Answer: 648
 *    100!:
 *      9332621544394415268169923885626670049071
 *      5968264381621468592963895217599993229915
 *      6089414639761565182862536979208272237582
 *      51185210916864000000000000000000000000
 */

public class Problem_020 {
    public static void main(String[] args) {
        BigInteger factorial = bigIntegerfactorial(100);
        System.out.println(factorial);
        System.out.println(getSumOfTheDigits(factorial.toString()));

    }
    static long getSumOfTheDigits(String number) {
        long sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Long.valueOf(number.substring(i, i+1));
        }
        return sum;
    }
    static long factorial(long number) {
        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }
    static BigInteger bigIntegerfactorial(int number) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
