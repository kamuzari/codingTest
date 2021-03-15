package Al_Study.Set1_B_정렬과이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 숫자카드 {
    static int arr[];
    static int arr2[];
    static int check[];

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        arr=new int[n];
        String str[]=br.readLine().split(" ");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        // 이분 탐색을 위해 정렬.



        int m=Integer.parseInt(br.readLine());
        String str2[]=br.readLine().split(" ");
        arr2=new int[m];
        check=new int [m];
        for (int i = 0; i <m ; i++) {
            arr2[i]=Integer.parseInt(str2[i]);
        }


        //java api 이용.
        for (int i = 0; i <check.length ; i++) {
            int x=Arrays.binarySearch(arr,arr2[i]);
            if(x>=0)
            {
                check[i]=1;
            }
        }

        for (int i = 0; i <check.length ; i++) {
            System.out.print(check[i]+" ");
        }
        br.close();
    }
}
