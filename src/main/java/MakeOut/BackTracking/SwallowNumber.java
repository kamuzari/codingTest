package MakeOut.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class SwallowNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        LinkedList<Long> list=new LinkedList<>();
        LinkedList<Long> results=new LinkedList<>();

        for (long i = 0; i <=9; i++) {
            results.add(i);
            list.offer(i);
        }

        while (!list.isEmpty())
        {
            long cur = list.poll();
            for (int i = 0; i < cur%10; i++) {
                long sum= 10 * cur + i;
                list.add(sum);results.add(sum);
            }
        }
        long answer=n>=1024 ? -1 : results.get(n-1);
        System.out.println(answer);
    }
    public static int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        else return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}
