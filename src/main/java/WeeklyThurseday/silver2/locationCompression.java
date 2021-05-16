package WeeklyThurseday.silver2;

// 좌표압축 -> n개를 정렬 후 인덱스를 출력...

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class locationCompression {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<Integer,Integer> map =new HashMap<>(); // 순서 보장x  복잡도 : o(1)
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            int a=sc.nextInt();
            arr[i]=a;             //   0  1  2  3  4
        }                         //   2  4 -10  4  -9
         int sorted[]=arr.clone(); // -10, -9 ,2 ,4 ,4 -->
        Arrays.sort(sorted);
        int index=0;
        for (int i : sorted) {
            if(!map.containsKey(i))
                map.put(i,index++); // 배열의 값 : 인덱스 번호
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])+" ");
        }
        System.out.println(sb); // 일반 출력시 시간초과  전체 시간복잡도 nlog n(정렬)+n(nLoop)


    }
}
