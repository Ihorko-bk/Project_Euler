package name.ihorko.problems.problem_016__Power_digit_sum;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * Answer: 1366
 * 2^1000 =
 *      1071508607186267320948425049060001810561404811705533607443750388370351051124936122493198378815695858127594672917
 *      5531468251871452856923140435984577574698574803934567774824230985421074605062371141877954182153046474983581941267
 *      398767559165543946077062914571196477686542167660429831652624386837205668069376
 */

import java.math.BigInteger;

public class Problem_016 {
    public static void main(String[] args) {
        BigInteger bigInteger = BigInteger.valueOf(2).pow(1000);
        char[] bigIntegerInCharArray = bigInteger.toString().toCharArray();
        long sum = 0;
        for (int i = 0; i < bigIntegerInCharArray.length; i++) {
            sum += Long.valueOf(bigIntegerInCharArray[i]+"");
        }
        System.out.println(bigInteger);
        System.out.println(sum);
    }
}
