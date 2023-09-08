package yandex_handbook.recursive_algorithms.hanoi_towers_2;

import java.util.Scanner;

import static java.lang.Math.pow;

public class HanoiTowers2 {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int n = inputScanner.nextInt();


        System.out.println(solution(n));
//        for (int i = 1; i <= n; ++i) {
//            System.out.println(i + " " + solution(i));
//        }
    }

    static int solution(int n) {
        if (n == 1) {
            return 1;
        }

        // log_2(n-1)
        int log = (int) (Math.log(n - 1) / Math.log(2)) + 1;

        // addition
        int plus = (int) pow(2, log) - 1;

        return 2 * solution(n - log) + plus;
    }
}

