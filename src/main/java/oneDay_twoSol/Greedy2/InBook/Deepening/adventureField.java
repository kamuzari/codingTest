package oneDay_twoSol.Greedy2.InBook.Deepening;

import java.util.Arrays;
import java.util.Scanner;
// 최대한 그룹을 많이 나눠야 한다.
public class adventureField {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr);
        int ans=0;
        int cnt=0;
        for (int i = 0; i < n; i++) {
            cnt++;
            if(cnt >=arr[i])
            {
                ans++;
                cnt=0;
            }
        }
        System.out.println(ans);

    }
}
