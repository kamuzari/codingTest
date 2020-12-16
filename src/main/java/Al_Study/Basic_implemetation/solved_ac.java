package Al_Study.Basic_implemetation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class solved_ac {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=(sc.nextInt());
        }
        Arrays.sort(arr);
        int d = solvedAc(n, arr);
        bw.write(d+" ");
        bw.flush();
        bw.close();sc.close();
    }

    static int solvedAc(int n, int[] arr) {
        float jeulsaAvg = (float) 0.15;
        int first=0;
        int last=arr.length-1;
        int operand = Math.round(n * jeulsaAvg);
        int operand1=operand;
        int operand2=operand;
        while (operand1!=0) {
            first++;
            operand1--;
        }
        while (operand2!=0) {
            last--;
            operand2--;
        }
        n=n-(operand*2);
        int sum=0;
        for (int i = first; i <=last ; i++) {
            sum+=arr[i];
        }
        if(sum==0)
            return 0;
        float avg=(float)sum/n;
        return Math.round(avg);
    }
}
