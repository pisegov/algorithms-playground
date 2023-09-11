package yandex_handbook.divide_and_conquer;


import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
//        int[] array = {5, 3, 5, 6, 2, 6};
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = input.nextInt();
        }

//        System.out.println(Arrays.toString(MergeSort(array)));
//        System.out.println(Arrays.toString(array));
        Solution(array, 0);
        System.out.print(array[0]);
        for (int i = 1; i < n; ++i) {
            System.out.print(" " + array[i]);
        }
//        System.out.print(Arrays.toString(array));
    }

    static void Solution(int[] array, int left) {
        if (left == array.length - 1) {
            return;
        }
        int minIndex = left;

        for (int i = left; i < array.length; ++i) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        int cell = array[left];
        array[left] = array[minIndex];
        array[minIndex] = cell;

        Solution(array, left + 1);
    }


}
