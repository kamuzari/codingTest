package Al_Study.기초수학3;

import java.util.ArrayList;
import java.util.Scanner;

public class 소수의연속합 {
    static boolean prime[];
    static ArrayList<Integer> arr;
    static int cnt;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //target.

        arr = new ArrayList<>();
        prime = new boolean[n + 1];
        prime();
        cnt=0;
        for (int i = 0; i < arr.size(); i++) {
            backtracking(arr.get(i),i);
        }
        System.out.println(cnt);
    }
    public static void backtracking(int sum,int depth)
    {
        if(sum>n)
            return;
        if(depth<arr.size()&&sum==n)
        {
            ++cnt;
        }
        if(depth!=arr.size()-1)
        {
                backtracking(sum+arr.get(depth+1),depth+1);
        }
    }
    public static void prime() {
        for (int i = 2; i < prime.length; i++) {
            prime[i] = true;
        }

        for (int i = 2; i < prime.length; i++) {
            for (int j = i + i; j < prime.length; j += i) {
                prime[j] = false;
            }
        }

        for (int i = 0; i < prime.length; i++) {
            if (prime[i]) {
                arr.add(i);
//                System.out.print(i + " ");  출력체크
            }
        }

    }
}


