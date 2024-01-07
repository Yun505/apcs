import java.util.Arrays;

public class Day1_MergingLists {

    public static int[] mergeLists(int[] listA, int[]listB) {

        // create a new merged array
        int[] merged = new int[listA.length + listB.length];

        // create 3 indices a, b, i
        int a = 0;
        int b = 0;
        int i = 0;

        // write a loop to merge
        while (a < listA.length && b < listB.length) {
            if (listA[a] < listB[b]) {
                merged[i++] = listA[a++];
            }
            else {
                merged[i++] = listB[b++];
            }
        }

        while (a < listA.length) {
            merged[i++] = listA[a++];
        }

        while (b < listB.length) {
            merged[i++] = listB[b++];
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] a = {5, 19, 20, 25, 30};
        int[] b = {9, 12, 14, 26, 50, 62, 70};

        int[] m = mergeLists(a, b);

        System.out.println(Arrays.toString(m));

    }
}