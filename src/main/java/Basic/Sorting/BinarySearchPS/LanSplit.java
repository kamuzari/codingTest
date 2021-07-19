package Basic.Sorting.BinarySearchPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/1654
public class LanSplit {

    private static int[] arr;
    private static int makingNumber;
    private static int YoungSickHave;
    private static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        YoungSickHave = Integer.parseInt(st.nextToken());
        arr = new int[YoungSickHave];

        makingNumber = Integer.parseInt(st.nextToken());
        max = -1;
        for (int i = 0; i < YoungSickHave; i++) {
            arr[i]=Integer.parseInt(br.readLine());
            max =Math.max(max,arr[i]);
        }
            Bsearch();
    }

    private static void Bsearch() {
        long l=1;
        long r=max;
        long answer=-1;
        while (l<=r)
        {
            long mid=(l+r)/2;
            boolean splitCheck=splitCheck(mid);
             if(splitCheck)
            {
                answer=Math.max(answer,mid);
                l=mid+1;
            }
            else if(!splitCheck)
            {
                r=mid-1;
            }
        }
        System.out.println(answer);
    }

    private static boolean splitCheck(long number) {
        int splitNumber=0;
        for (int i = 0; i < YoungSickHave; i++) {
            splitNumber+=(arr[i]/number);
        }
        return splitNumber>=makingNumber;
    }

}
