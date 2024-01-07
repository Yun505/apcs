import java.util.Arrays;

public class Day2_MergeSort {
    public static int[] mergeSort(String indent, int[] list){
        System.out.println(indent + "IN: " + Arrays.toString(list));
        int n = list.length;

        if (n==1){
            return list;
        }

        int[] halfA = Arrays.copyOfRange(list, 0, n/2);
        int[] halfB = Arrays.copyOfRange(list, n/2, n);

        halfA = mergeSort(indent + " ", halfA);
        halfB = mergeSort(indent + " ", halfB);

        list = mergeLists(halfA, halfB);

        System.out.println(indent + "IN: " + Arrays.toString(list));
        return list; 
    }

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
        int[] list = new int[6];

        for (int i= 0; i < list.length; i++){
            list[i] = (int) (Math.random() * 6);
        }

        System.out.println(Arrays.toString(list)); 

        list = mergeSort("",list); 

        System.out.println(Arrays.toString(list));

    }
}