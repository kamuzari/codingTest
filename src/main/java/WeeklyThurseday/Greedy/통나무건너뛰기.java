package WeeklyThurseday.Greedy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
//https://www.acmicpc.net/problem/11497
public class 통나무건너뛰기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        while (T-->0)
        {
            Deque<Integer> dq=new LinkedList<>();
            // 데큐 사용이유 : 예제 문제에서 차이를 각 인접해 있는 원소들 사이를 최소로 되게 하면서
            // 이 부분에서 가장 큰수를 가운데로 두고 양쪽으로 넣고 뺄수 있는 덱이 생각남.
            int n=sc.nextInt();
            sc.nextLine();
            int[] arr=new int[n+1];
            String str[]=sc.nextLine().split(" ");
            for (int i = 0; i <n ; i++) {
                arr[i+1]=Integer.parseInt(str[i]);
            }
            Arrays.sort(arr);
//            System.out.println(Arrays.toString(arr));
            for (int i = arr.length-1; i >0 ; i--) {
                if(i%2==1)
                {
                    dq.addFirst(arr[i]);
                }
                else
                {
                    dq.addLast(arr[i]);
                }
            }
            int j=1;
            while (!dq.isEmpty())
            {
               arr[j]=dq.poll();
               j++;
            }
//            System.out.println(Arrays.toString(arr));
            int max=-1;
            for (int i = 1; i <arr.length-1; i++) {
                if(max<Math.abs(arr[i+1]-arr[i]))
                {
                    max=Math.abs(arr[i+1]-arr[i]);
                }
            }
            System.out.println(max);
        }
    }
}
