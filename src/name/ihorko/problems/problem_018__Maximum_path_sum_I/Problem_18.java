package name.ihorko.problems.problem_018__Maximum_path_sum_I;

import java.util.*;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 *                             75
 *                           95 64
 *                         17 47 82
 *                       18 35 87 10
 *                     20 04 82 47 65
 *                   19 01 23 75 03 34
 *                 88 02 77 73 07 63 67
 *               99 65 04 28 06 16 70 92
 *             41 41 26 56 83 40 80 70 33
 *           41 48 72 33 47 32 37 16 94 29
 *         53 71 44 65 25 43 91 52 97 51 14
 *       70 11 33 28 77 73 17 78 39 68 17 57
 *     91 71 52 38 17 14 91 43 58 50 27 29 48
 *   63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows;
 * it cannot be solved by brute force, and requires a clever method! ;o)
 *
 * Answer: 1074
 */

public class Problem_18 {
        static final String string =    "75\n" +
                                      "95 64\n" +
                                    "17 47 82\n" +
                                  "18 35 87 10\n" +
                                "20 04 82 47 65\n" +
                              "19 01 23 75 03 34\n" +
                            "88 02 77 73 07 63 67\n" +
                          "99 65 04 28 06 16 70 92\n" +
                        "41 41 26 56 83 40 80 70 33\n" +
                      "41 48 72 33 47 32 37 16 94 29\n" +
                    "53 71 44 65 25 43 91 52 97 51 14\n" +
                  "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
              "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
            "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
        static int[][] pyramid = getPyramid();
        static ArrayList<Branch> branches = new ArrayList<>();

    public static void main(String[] args) {

        showPyramid();
        System.out.println(getFirstNotZeroElementIndex(pyramid[0]));

        Branch firstBranch = new Branch(pyramid.length);
        int j = getFirstNotZeroElementIndex(pyramid[0]);
        firstBranch.addElement(pyramid[0][j]);
        m(firstBranch, 1, j);
        for (Branch b : branches) {
            System.out.println(b);
        }
        System.out.println(branches.size());
        Collections.sort(branches);
        System.out.println(branches.get(0));
        System.out.println(branches.get(branches.size()-1));


    }
    static int getFirstNotZeroElementIndex(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) return i;
        }
        return -1;
    }
    static void m(Branch branch, int i, int j) {
        if (i < pyramid.length) {
            Branch anotherBranch = new Branch(branch);
            branch.addElement(pyramid[i][j-1]);
            m(branch, i+1, j-1);
            anotherBranch.addElement(pyramid[i][j+1]);
            m(anotherBranch, i+1, j+1);
        } else {
            branch.calcSum();
            branches.add(branch);
        }
    }
//    static List<Branch> getBranches(int[][] pyramid) {
//        ArrayList<Branch> branches = new ArrayList<>();
//        int elementsQuantity = pyramid.length;
//        int branchesQuantity = (int) Math.pow(2, pyramid.length-1);
//        for (int i = 0; i <; i++) {
//
//        }
//
//        return branches;
//    }
    static int[][] getArrayFromString(String string) {
        String[] lines = string.split("\n");
        String[] strNumbers;
        int[][] array = new int[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            strNumbers = lines[i].split(" ");
            int[] nums = new int[strNumbers.length];
            for (int j = 0; j < strNumbers.length; j++) {
                nums[j] = Integer.valueOf(strNumbers[j]);
            }
            array[i] = nums;
        }
        return array;
    }
    static void showArray() {
        int[][] array = getArrayFromString(string);
        for (int[] ii :array) {
            for (int i : ii) {
                System.out.printf("%02d  " , i);
            }
            System.out.println();
        }
    }

    static int[][] getPyramidFromArray(int[][] array) {
        int pyramidLineSize = 2 * array[array.length-1].length -1;
        int[][] pyramid = new int[array.length][pyramidLineSize];
        int centerCounter = 0;
        for (int i = array.length-1; i >= 0; i--) {
            for (int jArr = 0, jPyr = centerCounter++; jArr < array[i].length; jArr++, jPyr+=2) {
                pyramid[i][jPyr] = array[i][jArr];
            }
        }
        return pyramid;
    }
    static int[][] getPyramid() {
        return getPyramidFromArray(getArrayFromString(string));
    }
    static void showPyramid() {
        for (int[] ii :pyramid) {
            for (int i : ii) {
                System.out.printf("%02d  " , i);
            }
            System.out.println();
        }
    }
}
class Branch implements Comparable {
    int[] elements;
    int sum;
    int elementCounter;

    public Branch(Branch branch) {
        this(branch.elements);
        this.elementCounter = branch.elementCounter;
    }
    public Branch(int elementsQuantity) {
        elements = new int[elementsQuantity];
    }
    public Branch(int[] elements) {
        this.elements = elements;
    }
    public void addElement(int element) {
        if (elementCounter <= elements.length) elements[elementCounter++] = element;
    }
    public void calcSum() {
        for (int i : elements) {
            sum += i;
        }
    }
    @Override
    public String toString() {
        return "Branch{" +
                "elements=" + Arrays.toString(elements) +
                ", sum=" + sum +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.sum, ((Branch)o).sum);
    }
}