package tues_thurs_sat._20210715;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HowToLineUp {
    public static void main(String[] args) {
        System.out.println("solution(3,5) = " + solution(3,5));
    }
    static int arr[];
    static int N;
    static int temp[];
    static boolean v[];
    static List<int []> result =new LinkedList<>();
    public static int[] solution(int n, long k) {
        int[] answer = {};
        N=n;
        arr=new int[n];
        v=new boolean[n];
        temp=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=i+1;
        }
        pick(0);
        System.out.println("result = " + result.toString());
        for (int[] array : result) {
            System.out.println("Arrays.toString(array) = " + Arrays.toString(array));
        }
        return result.get((int) (k-1));
    }
    static  void pick(int cnt)
    {
        if(cnt==N)
        {
            result.add(temp.clone());
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!v[i]) {
                v[i]=true;
                temp[cnt]=arr[i];
                pick(cnt + 1);
                v[i]=false;
            }
        }
    }
}
