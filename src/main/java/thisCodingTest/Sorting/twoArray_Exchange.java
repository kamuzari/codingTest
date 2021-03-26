package thisCodingTest.Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class twoArray_Exchange {
    // 두 A,B의 배열을 가지고 A를 가장 최댓갑으로 만들어라.

    public static void main(String[] args) {
        Random r=new Random();
        int n=r.nextInt(10)+1;
        int A[]=new int[n];
        Integer B[]=new Integer[n];
        System.out.println("N : "+n);
        for (int i = 0; i < n; i++) {
            A[i]=r.nextInt(10)+1;
            B[i]=r.nextInt(10)+1;
        }
        System.out.println("A array :"+Arrays.toString(A));
        System.out.println("B array :"+Arrays.toString(B));

        Arrays.sort(A);
        Arrays.sort(B,Collections.reverseOrder());

        int org_sumA= Arrays.stream(A).sum();
        System.out.println("org_sumA = " + org_sumA);
        for (int i = 0; i < n; i++) {
            int criteria=i;
            for (int j = 0; j < n; j++) {
                if(A[criteria]<B[j])
                {
                    int tmp=A[criteria];
                    A[criteria]=B[j];
                    B[j]=tmp;
                }
                else {
                    break;
                }
            }
        }
        int trans_sumA=Arrays.stream(A).sum();
        System.out.println("trans_sumA = "+trans_sumA);
    }
}
