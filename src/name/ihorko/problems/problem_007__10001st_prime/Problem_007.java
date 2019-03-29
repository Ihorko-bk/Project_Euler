package name.ihorko.problems.problem_007__10001st_prime;

import java.util.ArrayList;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 *
 * What is the 10 001st prime number?
 *
 * Answer: 104743
 */

public class Problem_007 {
    public static void main(String[] args) {
        System.out.println(getNsimpleNumbers(10_001));
    }
    static ArrayList<Long> getNsimpleNumbers(int n) {
        ArrayList<Long> simpleNumbers = new ArrayList<>();
        simpleNumbers.add(2L);
        long naturalNumbers = 3;
        MainLoop:
        while (simpleNumbers.size() < n) {
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
