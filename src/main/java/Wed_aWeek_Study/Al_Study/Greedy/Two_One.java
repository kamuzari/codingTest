package Wed_aWeek_Study.Al_Study.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Two_One {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int sum=0;
        Arrays.parallelSort(arr);
//        System.out.println(Arrays.toString(arr));
        int cnt=0;
        for (int i = n-1; i >=0 ; i--) {
            if(cnt==2) {
                cnt=0;
                continue;
            }
            else {
                sum += arr[i];
                cnt++;
            }
        }
        System.out.println(sum);
    }

}
