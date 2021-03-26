package AL_CS_STUDY.RealTimeSolving.weekly13;

import java.util.Scanner;

public class theMostFrequent {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int idx=-1;
        int max=-1;
        int T=t;
        sc.nextLine();
        while (t-->0)
        {

            int n=sc.nextInt();
            sc.nextLine();
            String str[]=sc.nextLine().split(" ");
            int arr[]=new int[101];

            for (int i = 0; i < str.length; i++) {
                int a=Integer.parseInt(str[i]);

                arr[a]++;
                if(arr[a]>max)
                {
                    max=arr[a];
                    idx=a;
                }
                else if(arr[a]==max)
                {
                    idx=Math.max(idx,a);
                }
            }
            System.out.println("#"+n+" "+idx);
            max=-1;idx=-1;
        }
    }
}
