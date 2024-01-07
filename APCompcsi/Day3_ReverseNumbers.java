
import java.util.ArrayList;
import java.util.Scanner;

public class Day3_ReverseNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a list of numbers ending with 0.");

        ArrayList<Integer> list = new ArrayList<>();

        int n = in.nextInt();
        while (n != 0) {
            list.add(n);
            n = in.nextInt();
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + "  ");
        }
        in.close();
    }
}
