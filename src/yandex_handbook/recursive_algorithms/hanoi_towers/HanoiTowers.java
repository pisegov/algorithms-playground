package yandex_handbook.recursive_algorithms.hanoi_towers;

import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.round;

public class HanoiTowers {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int n = inputScanner.nextInt();

        System.out.println(round((pow(2, n) - 1)));
        solution(n, 1, 3);
    }

    static void solution(int n, int fromPeg, int toPeg) {
        if (n == 1) {
            System.out.println(fromPeg + " " + toPeg);
            return;
        }

        int unusedPeg = 6 - fromPeg - toPeg;
        solution(n - 1, fromPeg, unusedPeg);
        System.out.println(fromPeg + " " + toPeg);
        solution(n - 1, unusedPeg, toPeg);
    }
}
