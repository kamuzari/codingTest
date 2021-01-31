package oneDay_twoSol.Dyanmic.groubBysolving;

import java.util.Scanner;

public class sequencSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sequence[]=new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i]=sc.nextInt();
        }
        int max=sequence[0];
        for (int i = 1; i < n; i++) {
            if (sequence[i-1] > 0 && sequence[i] + sequence[i-1] > 0) {
                sequence[i] += sequence[i-1];
            }

            if (max < sequence[i]) {
                max = sequence[i];
            }
        }
        System.out.println(max);
    }
}
