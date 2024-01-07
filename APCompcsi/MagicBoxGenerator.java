import java.util.ArrayList;
import java.util.Scanner;

public class MagicBoxGenerator {
    public static int solutionCount = 0;

    public static ArrayList<int[][]> generateMagicBox_v3(int rows, int cols) {
        int n = rows * cols; 
        int totalSum = n * (n+1) / 2;
        int targetRowSum = totalSum / rows;

        ArrayList<int[][]> sols = new ArrayList<>();
        generateMagicBox_v3(sols, new int[rows][cols], 0, new boolean[rows*cols+1], 0, targetRowSum);
        return sols;
    }

    private static void generateMagicBox_v3(ArrayList<int[][]> solutions, int[][]box, 
                                            int pos, boolean[] used,
                                            int currentRowSum, int targetRowSum){
        int rows = box.length;
        int cols = box[0].length;

        // base case -- runs when box is full
        if (pos == rows*cols) {
            if (MagicBoxChecker.isSolution(box)) {
                solutions.add(MultiDimArrayFundamentals.deepCopy(box));
            }
            solutionCount++;
            if (solutionCount % 100000 == 0) {
                System.out.println("Tried solution: " + solutionCount);
            }
            return;
        }

        // recursive case
        int row = pos / cols;
        int col = pos % cols;

        boolean endOfRow = (col + 1 == cols);
        for (int num=1; num<=rows*cols; num++) {
            if (used[num]) {
                continue;
            }

            if (currentRowSum + num > targetRowSum) {
                break;
            }

            if (endOfRow && currentRowSum + num != targetRowSum) {
                continue;
            }

            used[num] = true;
            box[row][col] = num;
            
            generateMagicBox_v3(solutions, box, pos+1, used, endOfRow ? 0 : currentRowSum+num, targetRowSum);

            box[row][col] = 0;
            used[num] = false;
        }
    }



    public static ArrayList<int[][]> generateMagicBox_v2(int rows, int cols) {
        ArrayList<int[][]> sols = new ArrayList<>();
        generateMagicBox_v2(sols, new int[rows][cols], 0, new boolean[rows*cols+1]);
        return sols;
    }

    private static void generateMagicBox_v2(ArrayList<int[][]> solutions, int[][]box, 
                                            int pos, boolean[] used){
        int rows = box.length;
        int cols = box[0].length;

        // base case -- runs when box is full
        if (pos == rows*cols) {
            if (MagicBoxChecker.isSolution(box)) {
                solutions.add(MultiDimArrayFundamentals.deepCopy(box));
            }
            solutionCount++;
            if (solutionCount % 100000 == 0) {
                System.out.println("Tried solution: " + solutionCount);
            }
            return;
        }

        // recursive case
        int row = pos / cols;
        int col = pos % cols;

        for (int num=1; num<=rows*cols; num++) {
            if (used[num]) {
                continue;
            }
            used[num] = true;
            box[row][col] = num;
            
            generateMagicBox_v2(solutions, box, pos+1, used);

            box[row][col] = 0;
            used[num] = false;
        }
    }



    public static ArrayList<int[][]> generateMagicBox_v1(int rows, int cols) {
        ArrayList<int[][]> sols = new ArrayList<>();
        generateMagicBox_v1(sols, new int[rows][cols], 0);
        return sols;
    }

    private static void generateMagicBox_v1(ArrayList<int[][]> solutions, int[][]box, int pos){
        int rows = box.length;
        int cols = box[0].length;

        // base case -- runs when box is full
        if (pos == rows*cols) {
            if (MagicBoxChecker.isSolution(box)) {
                solutions.add(MultiDimArrayFundamentals.deepCopy(box));
            }
            solutionCount++;
            if (solutionCount % 100000 == 0) {
                System.out.println("Tried solution: " + solutionCount);
            }
            return;
        }

        // recursive case
        int row = pos / cols;
        int col = pos % cols;

        for (int num=1; num<=rows*cols; num++) {
            box[row][col] = num;
            generateMagicBox_v1(solutions, box, pos+1);
            box[row][col] = 0;
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        System.out.println("#rows?");
        int rows = input.nextInt();
    
        System.out.println("#columns?");
        int cols = input.nextInt();
    
        ArrayList<int[][]>solutions = generateMagicBox_v3(rows, cols);
    
        System.out.println (solutions.size() + " solutions found.");
    
        System.out.println();
        for (int[][] solution: solutions) {
          System.out.println();
          MultiDimArrayFundamentals.printArray(solution);
        }
        
        System.out.println("Tried solutions: " + solutionCount);
    // added because added annoying problem
      input.close();
      }
}
