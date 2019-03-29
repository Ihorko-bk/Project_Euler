package name.ihorko.problems.problem_010__Summation_of_primes;

import java.util.ArrayList;
import java.util.List;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 *
 * Find the sum of all the primes below two million.
 *
 * Answer: 142913828922
 * (calculated few minutes)
 */

public class Problem_010 {
    public static void main(String[] args) {
        System.out.println(
                getSumOfListNumbers(
                        getSimpleNumbersToN(2_000_000)
                )
        );
    }
    static long getSumOfListNumbers(List<Long> list) {
        long result = 0;
        for (long l : list) {
            result += l;
        }
        return result;
    }
    static ArrayList<Long> getSimpleNumbersToN(int n) {
        ArrayList<Long> simpleNumbers = new ArrayList<>();
        simpleNumbers.add(2L);
        long naturalNumbers = 3;
        MainLoop:
        while (naturalNumbers <= n) {
            for (int i = 0; i < simpleNumbers.size(); i++) {
                if (naturalNumbers%simpleNumbers.get(i) == 0) {
                    naturalNumbers++;
                    continue MainLoop;
                }
            }
            simpleNumbers.add(naturalNumbers++);
        }
        return simpleNumbers;
    }
}
