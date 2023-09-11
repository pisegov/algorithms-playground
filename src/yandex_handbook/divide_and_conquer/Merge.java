package yandex_handbook.divide_and_conquer;

import java.util.Arrays;
import java.util.Scanner;

public class Merge {
    static int MAX_VALUE = 1000000001;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int[][] arrays = new int[n][];
        for (int i = 0; i < n; i++) {
            int size = input.nextInt();
            arrays[i] = new int[size];
            for (int j = 0; j < size; ++j) {
                arrays[i][j] = input.nextInt();
            }
            // Челы в чате написали, что есть забагованный тест
            // с неотстортированными данными
//            Arrays.sort(arrays[i]);
        }

        Solution(arrays);
    }

    static void Solution(int[][] arrays) {
        int size = 0;
        for (int[] array : arrays) {
            size += array.length;
        }

        // it is less than 20
        int arraysNumber = arrays.length;

        int[] mins = new int[arraysNumber];
        int[] indices = new int[arraysNumber];
        for (int i = 0; i < arraysNumber; i++) {
            indices[i] = 0;
            mins[i] = arrays[i][0];
        }

        int i = 0;
        while (i < size) {
            // index of an array with the least element so far
            int minimumArrayIndex = 0;

            // find an actual minimum
            for (int j = 0; j < arraysNumber; j++) {
                if (mins[j] < mins[minimumArrayIndex]) {
                    minimumArrayIndex = j;
                }
            }

            // print the minimum
            System.out.print(mins[minimumArrayIndex] + " ");

            // increment index of minimum element in that array
            if (indices[minimumArrayIndex] < arrays[minimumArrayIndex].length - 1) {
                indices[minimumArrayIndex]++;
                mins[minimumArrayIndex] = arrays[minimumArrayIndex][indices[minimumArrayIndex]];
            } else {
                indices[minimumArrayIndex] = -1;
                mins[minimumArrayIndex] = MAX_VALUE;
            }
            ++i;
        }
    }
}
