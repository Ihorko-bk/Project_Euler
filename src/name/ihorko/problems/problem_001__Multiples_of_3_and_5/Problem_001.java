package name.ihorko.problems.problem_001__Multiples_of_3_and_5;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * Answer: 233168
 */

public class Problem_001 {
    public static void main(String[] args) {
        int sum = 0;
        int to = 1_000;
        for (int i = 0; i < to; i++) {
            if (i%3==0 || i%5==0)
                sum+=i;
        }
        System.out.println("sum = " + sum);
    }
}
