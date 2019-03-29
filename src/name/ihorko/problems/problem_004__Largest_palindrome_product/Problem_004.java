package name.ihorko.problems.problem_004__Largest_palindrome_product;

import java.util.TreeSet;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Answer: 906609
 */

public class Problem_004 {
    public static void main(String[] args) {
        TreeSet<Integer> allPalindrome = new TreeSet<>();
        for (int i = 100; i < 1_000; i++) {
            for (int j = 100; j < 1_000; j++) {
                if (isPalindrome(i*j)) allPalindrome.add(i*j);
            }
        }
        System.out.println(allPalindrome.last());
    }

    static boolean isPalindrome(int number) {
        char[] chNumber = (number + "").toCharArray();
        int quantity = Math.floorDiv(chNumber.length, 2);
        for (int i = 0; i < quantity; i++) {
            if (chNumber[i] != chNumber[chNumber.length-1-i]) return false;
        }
        return true;
    }
}
