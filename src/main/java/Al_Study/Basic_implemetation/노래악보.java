package Al_Study.Basic_implemetation;

import java.util.Scanner;

public class 노래악보 {
    static int arr_N[];
    static int arr_Q[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int Q=sc.nextInt();
        arr_N=new int [101];
        arr_Q=new int [1001];
        for (int i = 0; i <N ; i++) {
            arr_N[i]=sc.nextInt();
        }
        for (int i = 0; i <Q ; i++) {
            arr_Q[i]=sc.nextInt();
        }
        for (int j = 0; j < Q; j++)
        {
            int sum = -1;
            int temp = arr_Q[j];
            for (int i = 0; i < N; i++)
            {
                sum = sum + arr_N[i];
                if (sum >= temp)
                {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
