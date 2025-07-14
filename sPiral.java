import java.util.*;

public class sPiral{

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];

        // Input
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
            System.out.println();
        }

        int rowBegin = 0;
        int rowEnd = rows - 1;
        int colBegin = 0;
        int colEnd = cols - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse right
            for (int j = colBegin; j <= colEnd; j++)
                System.out.print(matrix[rowBegin][j] + " ");

            // Traverse down
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++)
                System.out.print(matrix[i][colEnd] + " ");

            colEnd--;

            // Traverse left
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--)
                    System.out.print(matrix[rowEnd][j] + " ");
                rowEnd--;
            }

            // Traverse up
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--)
                    System.out.print(matrix[i][colBegin] + " ");
                colBegin++;
            }
        }
    }
}
