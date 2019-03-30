package name.ihorko.problems.problem_017__Number_letter_counts;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are
 * 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
 * (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 *
 * Answer: 21124
 */

public class Problem_017 {
    static final String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                                       "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                                            "eighteen", "nineteen"};
    static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static final String HUNDRED = " hundred";
    static final String THOUSAND = " thousand";
    static final String AND = " and ";


    public static void main(String[] args) {
        long sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum+=countLetters(numbersToString(i));
        }
        System.out.println(sum);
    }
    static int countLetters(String string) {
        return string.replace(" ", "").replace("-", "").length();
    }
    static String numbersToString(int number) {
        String tens = "";
        int iTens = number % 100;
        if (iTens > 0) {
            if (iTens < 20) {
                tens = UNITS[iTens];
            } else {
                tens = TENS[iTens/10] + (iTens%10==0 ? "" : "-" + UNITS[iTens%10]);
            }
        }

        String hundreds = "";
        int iHundreds = (number % 1_000) / 100;
        if (iHundreds > 0) {
            hundreds = UNITS[iHundreds] + HUNDRED;
        }

        String thousands = "";
        int iThousands = (number % 1_000_000) / 1_000;
        if (iThousands > 0) {
            thousands = numbersToString(iThousands) + THOUSAND;
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (!thousands.equals("")) {
            stringBuilder.append(thousands);
            if (!hundreds.equals("") || !tens.equals("")) {
                stringBuilder.append(AND);
            }
        }
        if (!hundreds.equals("")) {
            stringBuilder.append(hundreds);
            if (!tens.equals("")) {
                stringBuilder.append(AND);
            }
        }
        if (!tens.equals("")) {
            stringBuilder.append(tens);
        }

        return stringBuilder.toString();
    }
}
