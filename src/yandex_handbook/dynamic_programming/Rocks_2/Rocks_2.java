package yandex_handbook.dynamic_programming.Rocks_2;

import java.util.Scanner;

public class Rocks_2 {
    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);

        int n = inputScanner.nextInt();
        int m = inputScanner.nextInt();

        System.out.println(SimpleSolution(n, m));
    }

    static String SimpleSolution(int n, int m) {
        if ((n - m) % 3 == 0) {
            return "Loose";
        }
        return "Win";
    }

    static void printMatrix(int n, int m) {
        boolean[][] matrix = new boolean[n + 1][m + 1];

        matrix[0][0] = false;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {

                if ((i - j) % 3 == 0) {
                    matrix[i][j] = false;
                    continue;
                }
                matrix[i][j] = true;
            }
        }

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
