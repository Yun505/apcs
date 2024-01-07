import java.util.Arrays;

public class sortingandsearching {
    public static int[] getNewArray(int size) {
       int[] array = new int[size];
       for (int i = 0; i<size; i++){
           array[i] = i;
       }
       return array; 
    }

    public static void shuffle(int[] a ){
        for ( int i =0; i<a.length; i++){
            int j = (int)(Math.random()* (a.length-i))+i;
            int t= a[i];
            a[i] = a[j];
            a[j] = t;

        }
    }
    public static void selectionSort(int[] a){
        for (int i = 0; i<a.length-1; i++){
            int  smPos = i; 
            for ( int j= i+1; j<a.length; j++){
                if (a[j] <a[smPos]){
                    smPos = j; 
                }
            }
            int t= a[i]; 
            a[i] =  a[smPos];
            a[smPos] = t; 

            System.out.println( i +" : " + Arrays.toString(a));
        }
    }
    public static void insertionSort(int[] a){
        for (int i =1; i<a.length; i++){
                int num = a[i];
                int j = i-1;
                while (j>= 0 && a[j] > num){
                    a[j+1]= a[j];
                    j--;
                }
                a[j+1]=num;
                
                System.out.println( i +" : " + Arrays.toString(a));
        }
    }
    public static int linearSearch(int[] a, int num){
        for(int i = 0; i<a.length;i++ ){
            if (a[i] == num){
                return i; 
            }
        }
        return -1; 
    }
    public static int binarySearch(int[] a, int num){
        int low = 0;
            int high = a.length-1;
        while(low <= high){

            int pos = (low +high)/2; 
            if (num <a[pos]){
                high = pos-1;
            }
            else if (num >a[pos]){
                low = pos + 1;
            }
            else{
                return pos; 
            }
        }
        return -1; 
    }
    public static void main(String[] args){
        int [] array = getNewArray(10); 
        System.out.println("Start: " +Arrays.toString(array)); 
        
        shuffle(array);
        System.out.println("Shuffled: " + Arrays.toString(array));

        insertionSort(array);
        System.out.println("Sorted: " + Arrays.toString(array));

    }
}
