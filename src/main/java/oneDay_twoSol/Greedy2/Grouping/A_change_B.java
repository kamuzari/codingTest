package oneDay_twoSol.Greedy2.Grouping;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A_change_B {
    static int target;
    static long posit[];
    static boolean flag = false;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        target = sc.nextInt();
        posit = new long[target + 1];
//        bfs(n);
//        if(!flag)
//        {
//            System.out.println(-1);
//        }
        int k = 0;
        while(true) {
            if(target == n) {
                k += 1;
                break;
            }
            if(target < n) {
                k = -1;
                break;
            }
            if(target % 10 == 1)
                target /= 10;
            else if(target % 2 == 0)
                target /= 2;
            else {
                k = -1;
                break;
            }
            k++;
        }
        System.out.println(k);

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        posit[start] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < 2; i++) {
                int next = 0;
                if (i == 0) {
                    next =cur* 2;
                } else {
                    next = cur*10 + 1;
                }
                if (next == target) {
                    System.out.println(posit[cur]+1);
                    flag=true;
                    return;
                }
                if (next <= target && posit[next] == 0) {
                    q.add(next);
                    posit[next] = posit[cur] + 1;
                }
            }
        }
    }

}
