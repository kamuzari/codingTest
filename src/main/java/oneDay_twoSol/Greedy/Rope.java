package oneDay_twoSol.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Rope {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        // 오름 차순으로 정렬 후 가장 높은 무게서부터 하나씩 병렬로 들어보면서 비교..

        Arrays.sort(arr);
        int len=arr.length-1;
        int cnt=1;
        int max=arr[len];
        // 가장 무거운 무게를 들 수 있는 로프에서 점점 작은 무게를 버티는 로프와 비교를 했을때 가장 작은 무게를 기준으로 분산하여 들 수 있다.
        for (int i =len-1 ; i >-1 ; i--) {
          cnt++;
          int parallel=arr[i]*cnt;
          if(parallel>max)
          {
              max=parallel;
          }
        }
        System.out.println(max);
    }
}
