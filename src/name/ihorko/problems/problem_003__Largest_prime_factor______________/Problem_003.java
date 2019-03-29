package name.ihorko.problems.problem_003__Largest_prime_factor______________;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Answer:
 */

public class Problem_003 {
    public static void main(String[] args) {
        long number = 600_851_475_143L;
        long[][] bigNumberArray = new long[280][];
//        ArrayList<Long> numberDivs = new ArrayList<>();
//        ArrayList<Long> simpleNumbers = new ArrayList<>();
//
//        for (long i = 2; i < number; i++) {
//            if (number%i==0) numberDivs.add(i);
//        }
//        System.out.println(number + "has " + numberDivs.size() + " dividers");
//        System.out.println(numberDivs);

//        System.out.println(getSimple(300));
//        System.out.println(Arrays.toString(getAll(10)));
//        System.out.println(getDiviers(20));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(number/Integer.MAX_VALUE);
        System.out.println((double)number / (double) Integer.MAX_VALUE);
        System.out.println((int)Math.ceil((double)number / (double) Integer.MAX_VALUE));

        long remainder = number-(279L * (long)Integer.MAX_VALUE);
        System.out.println(remainder);

    }

    static ArrayList<Long> getSimpleNumbers(long to) {
        ArrayList<Long> simpleNumbers = new ArrayList<>();
        for (long i = 2; i < to; i++) {
            simpleNumbers.add(i);
        }
        Iterator<Long> iterator = simpleNumbers.iterator();
        while (iterator.hasNext()) {

        }
        return simpleNumbers;
    }

    static ArrayList<Integer> getDiviers(int number) {
        ArrayList<Integer> diviers = new ArrayList<>();
        int[] all = getAll(number);
        for (int i = 0; i < all.length; i++) {
            if (number%all[i]==0) diviers.add(all[i]);
        }
        return diviers;
    }


    static ArrayList<Integer> getSimple(int to) {
        int[] all = getAll(to);
        for (int i = 0; i < all.length; i++) {
            if (all[i] == -1 || i+1 >= all.length) continue;
            for (int j = i+1; j < all.length; j++) {
                if (all[j]==-1) continue;
                if (all[j]%all[i]==0) all[j] = -1;
            }
        }
        ArrayList<Integer> simple = new ArrayList<>();
        for (int i = 0; i < all.length; i++) {
            if (all[i] != -1) simple.add(all[i]);
        }
        return simple;
    }

    static int[] getAll(int to) {
        int[] all = new int[to-2];
        for (int i = 2, j = 0; j < all.length; i++, j++) {
            all[j] = i;
        }
        return all;
    }
    static long[][] getAllBig(long number) {
        int max = Integer.MAX_VALUE;
        long element = 2;
        long[][] bigAll = new long[(int)Math.ceil((double)number / (double) max)][];
        for (int i = 0; i < 279; i++) {
            long[] iall = new long[max];
            for (int j = 0; j < max; j++) {
                iall[j] = element++;
            }
            bigAll[i] = iall;
        }
        int remainder = (int)(number-(279L * (long)Integer.MAX_VALUE));
        long[] lAll = new long[remainder];
        for (int i = 0; i < lAll.length; i++) {
            lAll[i] = element++;
        }
        bigAll[280] = lAll;
        return bigAll;
    }
}
