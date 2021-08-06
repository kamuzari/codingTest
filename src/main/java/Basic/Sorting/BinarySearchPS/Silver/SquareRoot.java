package Basic.Sorting.BinarySearchPS.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareRoot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
//        System.out.println((long) Math.ceil(Math.sqrt(n)));
        long answer = binaySearch(n);
        System.out.println(answer);
    }

    private static long binaySearch(long N) {
        long s = 1;
        long e = N;
        long mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;

            long square = (long) Math.pow(mid, 2);

            if (square == N) {
                return mid;
            } else if (square < N) {
                s = mid + 1;
            } else if (square > N)
                e = mid - 1;
        }

        if (N > mid * mid) {
            mid++;
        }
        return mid;
    }

}
/*
8463618533724574313
1713684288253951914

*/