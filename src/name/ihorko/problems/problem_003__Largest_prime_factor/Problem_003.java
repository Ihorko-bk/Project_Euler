package name.ihorko.problems.problem_003__Largest_prime_factor;

import java.util.ArrayList;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Answer: 6857
 */

public class Problem_003 {
    public static void main(String[] args) {
        long number = 600_851_475_143L;
        System.out.println(getSimpleNumbers(number));

    }

    static ArrayList<Long> getSimpleNumbers(long number) {
        ArrayList<Long> simpleNumbers = new ArrayList<>();
        simpleNumbers.add(2L);
        System.out.print("Prime factors:");
        MainLoop:
        for (long i = 3; i < number; i++) {
            for (int j = 0; j < simpleNumbers.size(); j++) {
                if (i%simpleNumbers.get(j) == 0) continue MainLoop;
            }
            if (number%i==0) {
                System.out.print(" " + i);
            }
            simpleNumbers.add(i);
        }
        System.out.println();
        return simpleNumbers;
    }
}
