package yandex_handbook.greedy_algorithms;

import java.lang.*;
import java.util.*;
class Solution {

    public static int count(Interval[] intervals) {
        int length = intervals.length;
        int result = 0;

        int i = 0;
        while(i < length) {
            Interval champ = intervals[i];
            int j = i;

            System.out.println(champ.left + " " + champ.right);
            while (j < length && intervals[j].left <= intervals[i].right)
                ++j;

            i += j - i;
            result++;
        }

        return result;
    }
    public static void main( String args[] ) {
        Scanner inputScanner = new Scanner( System.in );

        // int n = inputScanner.nextInt();
        // Interval[] intervals = new ArrayList(n);

        // for (int i = 0; i < n; i++) {
        //     interval[i] = new Interval(inputScanner.nextInt(), inputScanner.nextInt())
        // }

        Interval[] intervals = {
                new Interval(5, 6),
                new Interval(1, 2),
                new Interval(4, 5),
                new Interval(2, 3),
                new Interval(4, 5),
                // new Interval(4, 5)
        };

        Arrays.sort(intervals, new SortByRight());
        int result = count(intervals);
        System.out.println(result);
    }
}

class Interval {
    int left, right;
    public Interval( int left, int right ) {
        this.left = left;
        this.right = right;
    }
}

class SortByRight implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.right - b.right;
    }
}