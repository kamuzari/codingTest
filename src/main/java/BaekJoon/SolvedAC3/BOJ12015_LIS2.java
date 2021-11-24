package BaekJoon.SolvedAC3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12015_LIS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            int tailVal=list.get(list.size()-1);
            int val=arr[i];
            if(tailVal<val) list.add(val);
            else{
                int l=0,r=list.size()-1;
                while (l<r){
                    int mid=(l+r)>>1;
                    if(list.get(mid)>=val) r=mid;
                    else l=mid+1;
                }
                list.set(r,val);
            }
        }
        System.out.println(list.size()-1);
    }
}
