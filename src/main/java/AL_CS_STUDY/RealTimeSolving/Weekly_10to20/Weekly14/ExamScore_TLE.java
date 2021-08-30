package AL_CS_STUDY.RealTimeSolving.Weekly_10to20.Weekly14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ExamScore_TLE {
    static int n;
    static int arr[];
    static StringBuilder sb=new StringBuilder();
    static TreeMap<Integer,Integer> treeMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr=new int[n];
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j]=Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(arr));
            treeMap=new TreeMap<>();
            for (int j = 0; j <n; j++) {
                pickNumber=j+1;
                pick(0,0,0);
            }
            sb.append("#"+i).append(" "+count+"\n");
            count=1;
            treeMap.clear();
        }
        System.out.println(sb);
    }
    static int pickNumber=0;
    static int count=1;
    static void pick(int cnt,int idx,int sum)
    {

        if(cnt==pickNumber && !treeMap.containsKey(sum))
        {
            treeMap.put(sum,1);
            count++;
            return;
        }
        for (int i = idx; i <n ; i++) {
            pick(cnt+1,i+1,sum+arr[i]);
        }
    }
}
