package oneDay_twoSol.RealTimeSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 세수 {
    static int n=3;
    static int m=2;
    static int arr[];
    static int temp[];
    static boolean visited[];
   static ArrayList<Integer> box=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        arr=new int[str.length]; // 0 0 0
        temp=new int[arr.length];
        visited=new boolean[arr.length];
        for (int i = 0; i <str.length ; i++) {
            temp[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(temp); //{ 3,5,8}
        comb(0);
        System.out.println(box);


    }
    static void comb(int depth) {
        if (depth == m) {
            int x=0;
            for (int k : arr) {
                if (k != 0) {
                    box.add(k); // box //2
                    System.out.print(k + " ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = temp[i];  // 3,5,0  temp={3,5,8} visite={T,f,f}
                if(depth==0)
                    comb(depth+1);
                if(depth>0 && arr[depth]>arr[depth-1]) // 뽑은 숫자중에 먼저 뽑안던 숫자보다는 커야한다!.
                    comb(depth + 1);
                visited[i] = false;
            }
        }
    }
}
