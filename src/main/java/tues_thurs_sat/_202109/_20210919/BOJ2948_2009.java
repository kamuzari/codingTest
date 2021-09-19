package tues_thurs_sat._202109._20210919;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class BOJ2948_2009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        LocalDate localDate = LocalDate.of(2009, m, d);
        String dayOfTheWeek = localDate.getDayOfWeek().toString().toLowerCase();
        StringBuffer sb=new StringBuffer().append(dayOfTheWeek);
        String front = dayOfTheWeek.substring(0,1);
        sb.deleteCharAt(0).insert(0,front.toUpperCase());
        System.out.println(sb);
    }
}
