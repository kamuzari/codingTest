package BaekJoon.SolvedAC4;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1629_Multiple {

    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(pow(a,b));

    }
//    base := 밑, exponenet := 지수
    public static long pow(long a,int exponenet){
        if(exponenet==1){
            return a%c;
        }
        long tmp=pow(a,exponenet/2);
        if(exponenet%2==1){
            return (tmp*tmp%c)*a%c;
        }
        return tmp*tmp%c;
    }
}
