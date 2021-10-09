package AL_CS_STUDY.Weekly_40to50.Weekly40;
import java.util.*;
import java.io.*;
public class BOJ1351_InfiniteSequenceNumber {

    private static Map<Long, Long> map;
    private static long p;
    private static long q;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long n=Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        map = new HashMap<>();
        long answer=0;
        map.put(0L,1L);
        for (long i = 1; i < n+1; i++) {
            if(i==n) {
                answer=map.get(i/p)+map.get(i/q);
                break;
            }
            map.put(i, map.get(i/ p)+ map.get(i/ q));
        }
        System.out.println(answer);
//        System.out.println(func(n));
    }
    static long func(long n){
        if(n==0) return 1;
        if(map.containsKey(n)) return map.get(n);
        map.put(n,func(n/p)+func(n/q));
        return map.get(n);
    }
}
