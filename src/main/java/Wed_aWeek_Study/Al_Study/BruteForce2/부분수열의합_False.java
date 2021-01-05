package Wed_aWeek_Study.Al_Study.BruteForce2;

import java.util.Scanner;

public class 부분수열의합_False {
    static long s;
    static int[] arr;
    static int[] temp;
    static boolean[] visited;
    static int n;
    static int cnt=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str[] = sc.nextLine().split(" ");
        n = parse(str[0]);
        s = Long.parseLong(str[1]); // target

        String str2[] = sc.nextLine().split(" ");
        arr = new int[str2.length];
        for (int i = 0; i < str2.length; i++) {
            arr[i] = parse(str2[i]);
        }
        visited = new boolean[n];
        for (int i = 1; i <= n; i++) {
            temp = new int[i];
            Combination(0, i);
        }
        System.out.println(cnt);
    }

    static void Combination(int depth, int select) {
        if (depth == select) {
            print();
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    temp[depth] = arr[i];
                    if(depth==0)
                        Combination(depth+1,select);
                    if(depth>0 && temp.length >1&& temp[depth]>temp[depth-1])
                        Combination(depth+1,select);
                    visited[i] = false;
                }
            }
        }

    }

    static void print( ){
        long sum=0;
        for (int i = 0; i < temp.length; i++) {
                sum+=temp[i];
            System.out.print(temp[i]+" ");
        }
        System.out.print("=> "+sum);
        if(sum==s) {
            System.out.print("  cnt 증가");
            ++cnt;
        }
        System.out.println();

    }

    static int parse(String str) {
        return Integer.parseInt(str);
    }
}
