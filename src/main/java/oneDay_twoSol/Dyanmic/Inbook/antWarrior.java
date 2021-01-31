package oneDay_twoSol.Dyanmic;

public class antWarrior {
    static int dp[];
    public static void main(String[] args) {
        int a[]={3,1,1,5};
        int n=4;
        manyStealing(a,n);
    }
    static void manyStealing(int arr[],int n)
    {
        dp=new int[n];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for (int i = 2; i <n; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        System.out.println(dp[n-1]);
    }

}
