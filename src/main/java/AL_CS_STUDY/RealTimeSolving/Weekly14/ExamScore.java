package AL_CS_STUDY.RealTimeSolving.Weekly14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ExamScore {
    static int n;
    static int arr[];
    static  Set<Integer> set=new HashSet<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr=new int[n];
            st=new StringTokenizer(br.readLine());
            set.add(0); // 0점.
            for (int j = 0; j < n; j++) {
                arr[j]=Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < n; j++) {
                scoreCopy(arr[j]);
            }
            sb.append("#"+i).append(" "+set.size()+"\n");
            set.clear();
        }
        System.out.println(sb);
    }
    static void scoreCopy(int number)
    {
       Set<Integer> tmpSet=new HashSet<>();
       tmpSet.addAll(set);
        for (Integer temp : tmpSet) {
            set.add(temp+number);
        }

    }

}
