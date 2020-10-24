package bruteForce;

import java.util.Scanner;

public class blackJack {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");

        int n=Integer.parseInt(str[0]); // 카드의 총 개수.
        int m=Integer.parseInt(str[1]); // 웨이터가 부르는 수
        int[] card=new int[n];
        String str2[]=sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            card[i]=Integer.parseInt(str2[i]);
        }
        System.out.println(Game(n,card,m));
    }
    public static int Game(int n,int arr[],int m)
    {
        // 3 (i,j,k) 장의 카드를 뽑는 모든 수를 순차적으로 다 찾아보는 형식으로 구현.
        int ans=0;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k <n ; k++) {
                    int sum=arr[i]+arr[j]+arr[k];
                    if(sum>m)
                        continue;
                    if(Math.abs(sum-m)<Math.abs(ans-m))
                        ans=sum;
                }
            }
        }
     return ans;
    }


}
