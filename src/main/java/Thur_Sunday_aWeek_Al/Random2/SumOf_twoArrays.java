package Thur_Sunday_aWeek_Al.Random2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SumOf_twoArrays {
    static ArrayList<Long> a, b;
    static int A[], B[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextInt();

        int n = sc.nextInt();
        A = new int[n];
        a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        b = new ArrayList<>();
        B = new int[m];
        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        long sum = 0;
        for (int k = 0; k < n; k++) {
            sum=0;
            for (int i = k; i < n; i++) {
                sum += A[i];
                a.add(sum);
            }
        }
        for (int k = 0; k < m; k++) {
            sum = 0;
            for (int i = k; i < m; i++) {
                sum += B[i];
                b.add(sum);
            }
        }

        Collections.sort(a);
        Collections.sort(b);
        long cnt = 0;
        for (int i = 0; i < a.size(); i++) {
            long target = T - a.get(i);
            cnt += upperBound(0, b.size(), target) - lowerBound(0, b.size(), target);
        }
        System.out.println(cnt);


    }

    static int lowerBound(int l, int r, long t) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (b.get(mid) < t)
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }

    static int upperBound(int l, int r, long t) {
        while (l < r) {
            int mid = (l + r) / 2;
            if ( b.get(mid) <= t)
                l = mid + 1;
            else
                r = mid;
        }
        return r;
    }
}
