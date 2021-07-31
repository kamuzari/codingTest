package Basic.SW_TP.SlidingWindow;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11003
// https://code0xff.tistory.com/168 ref
public class SectionMinValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        LinkedList<Integer> dq=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst()<=i-L)
                dq.pollFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()]>arr[i])
                dq.pollLast();

            dq.offer(i);
            sb.append(arr[dq.peekFirst() != null ? dq.peekFirst(): 0]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
