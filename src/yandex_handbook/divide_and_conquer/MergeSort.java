package yandex_handbook.divide_and_conquer;

import java.util.Arrays;

public class MergeSort {
    static int[] sort(int[] array) {

        int length = array.length;
        if (length < 2) {
            return array;
        }
        int[] first = sort(Arrays.copyOfRange(array, 0, length / 2));
        int[] second = sort(Arrays.copyOfRange(array, length / 2, length));

        return merge(first, second);
    }

    static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];

        int i = 0;
        int j = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                result[i + j] = first[i];
                ++i;
            } else {
                result[i + j] = second[j];
                ++j;
            }
        }

        while (i < first.length) {
            result[i + j] = first[i];
            ++i;
        }
        while (j < second.length) {
            result[i + j] = second[j];
            ++j;
        }
        return result;
    }
}
