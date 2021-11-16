package Basic.SolvedAC3;
import java.io.*;
import java.util.*;
public class BOJ18870_CoordinateCompression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int arr[]=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for (int idx = 0; idx < clone.length; idx++) {
            if(map.containsKey(clone[idx])) continue;
            map.put(clone[idx],count++);
        }
        StringBuilder answers=new StringBuilder();
        for (int i = 0; i < n; i++) {
            answers.append(map.get(arr[i])+" ");
        }
        System.out.println(answers);
    }
}
