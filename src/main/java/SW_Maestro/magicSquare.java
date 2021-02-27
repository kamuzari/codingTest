package SW_Maestro;

import java.util.Scanner;

public class magicSquare {
    public static void main(String[] args) {
        int arr[]=new int[10];
        Scanner sc=new Scanner(System.in);
        for (int i = 1; i < 10; i++) {
            arr[i]=sc.nextInt();
        }
        recur(0,15,arr);
        System.out.println(answer);

    }
    static int answer=Integer.MAX_VALUE;
    static int input[]=new int[10];
    static void recur(int idx, int check, int arr[]){
        if(idx!=0 && idx%3==0){
            if(arr[idx]+arr[idx-1]+arr[idx-2]!=check) return;
            // 백트래킹.
        }
        if(idx==9){
            if(arr[idx]+arr[idx-3]+arr[idx-6]!=check) return;
            if(arr[idx-1]+arr[idx-4]+arr[idx-7]!=check) return;
            if(arr[idx-2]+arr[idx-5]+arr[idx-8]!=check) return;
            if(arr[idx]+arr[idx-4]+arr[idx-8]!=check) return;
            if(arr[idx-2]+arr[idx-4]+arr[idx-6]!=check) return;
            boolean te[] = new boolean[10];
            for(int i=1; i<=9; i++){
                if(te[arr[i]]) return;
                te[arr[i]] = true;
            }
            int temp = 0;
            for(int i=1; i<=9; i++) temp += Math.abs(input[i]-arr[i]);
            answer = Math.min(answer,temp); return;
        }
        for(int i=1; i<=9; i++) {
            arr[idx+1] = i;
            recur(idx+1,check,arr);
        }
    }

}
