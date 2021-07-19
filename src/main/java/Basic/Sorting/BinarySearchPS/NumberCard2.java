package Basic.Sorting.BinarySearchPS;

import java.io.*;
import java.util.*;

public class NumberCard2 {
    static int arr[],n,len;
    static StringBuilder sb=new StringBuilder();
    static Map<Integer,Integer> map=new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BinarySearch();
        Hash();

    }

    private static void BinarySearch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number=Integer.parseInt(st.nextToken());
            map.put(number,map.getOrDefault(number,0)+1);
        }
        len=map.size();
        arr=new int[len];

        int idx=0;
        for (Integer key : map.keySet()) {
            arr[idx++]=key;
        }
        Arrays.sort(arr);

        int m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i <m; i++) {
            int searchValue = Integer.parseInt(st.nextToken());
            binarySearch(searchValue);
        }
        System.out.println(sb);
    }

    private static void binarySearch(int searchValue) {
        int l=0;
        int r=len-1;
        while (l<=r)
        {
            int mid=(l+r)/2;
            if(arr[mid]==searchValue)
            {
                sb.append(map.get(searchValue)).append(" ");
                return;
            }
            else if(arr[mid]>searchValue)
                r=mid-1;
            else
                l=mid+1;
        }
        sb.append(0).append(" ");
    }

    private static void Hash() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number=Integer.parseInt(st.nextToken());
            map.put(number,map.getOrDefault(number,0)+1);
        }

        int m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i <m; i++) {
            int searchValue = Integer.parseInt(st.nextToken());
            if(!map.containsKey(searchValue))
                sb.append("0 ");
            else
                sb.append(map.get(searchValue)).append(" ");
        }
        System.out.println(sb);
    }
}
