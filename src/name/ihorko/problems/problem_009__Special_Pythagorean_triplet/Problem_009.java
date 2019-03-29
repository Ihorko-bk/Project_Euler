package name.ihorko.problems.problem_009__Special_Pythagorean_triplet;

import java.util.ArrayList;
import java.util.List;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 * For example, 3*3 + 4*4 = 9 + 16 = 25 = 52.
 *
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * Answer: 31875000
 *  PythagoreanTriplet{a=200, b=375, c=425}
 */

public class Problem_009 {
    public static void main(String[] args) {
        PythagoreanTriplet pythagoreanTriplet = getPythagoreanTripletWhereAplusBplusCequalN(
                findPythagoreanTripletToN(1000), 1000
        );

        System.out.println(pythagoreanTriplet);
        System.out.println(pythagoreanTriplet.a * pythagoreanTriplet.b * pythagoreanTriplet.c);
    }
    static PythagoreanTriplet getPythagoreanTripletWhereAplusBplusCequalN(List<PythagoreanTriplet> pythagoreanTriplets, int n) {
        for (PythagoreanTriplet pt : pythagoreanTriplets) {
            if (pt.a + pt.b + pt.c == n) return pt;
        }
        return null;
    }

    static ArrayList<PythagoreanTriplet> findPythagoreanTripletToN(int n) {
        ArrayList<PythagoreanTriplet> pythagoreanTriplets = new ArrayList<>();
        for (int a = 1; a < n; a++) {
            for (int b = a+1; b < n; b++) {
                for (int c = b+1; c < n; c++) {
                    if (PythagoreanTriplet.isPythagoreanTriplet(a, b, c)) {
                        pythagoreanTriplets.add(new PythagoreanTriplet(a, b, c));
                    }
                }
            }
        }
        return pythagoreanTriplets;
    }
}
class PythagoreanTriplet {
    int a, b, c;
    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return "PythagoreanTriplet{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                "} --- " +
                a + "*" + a + " + " +
                b + "*" + b + " = " +
                c + "*" + c
        ;
    }

    static boolean isPythagoreanTriplet(int a, int b, int c) {
//        if (a>b || b>c) return false;
        if (a*a+b*b != c*c) return false;
        return true;
    }
}
