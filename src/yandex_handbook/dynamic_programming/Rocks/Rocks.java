package yandex_handbook.dynamic_programming.Rocks;

import java.util.Scanner;

public class Rocks {
    public static void main (String[] args) {

        Scanner inputScanner = new Scanner( System.in );

        int n = inputScanner.nextInt();
        int m = inputScanner.nextInt();

        System.out.println(RocksSolution(n, m));
    }

    static String RocksSolution (int n, int m) {
        boolean[][] matrix = new boolean[n+1][m+1];

        matrix[0][0] = false;
        for (int i = 1; i <= n; ++i) {
            matrix[i][0] = !matrix[i - 1][0];
        }
        for (int i = 1; i <= m; ++i) {
            matrix[0][i] = !matrix[0][i - 1];
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (matrix[i - 1][j -1] && matrix[i][j-1] && matrix[i-1][j]) {
                    matrix[i][j] = false;
                    continue;
                }
                matrix[i][j] = true;
            }
        }
//        for (int i = 0; i <= n; ++i) {
//            for (int j = 0; j <= m; ++j) {
//                System.out.print(" " + matrix[i][j]);
//            }
//            System.out.println();
//        }
        if (matrix[n][m]) {
            return "Win";
        }
        return "Loose";
    }
}
