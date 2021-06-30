package AL_CS_STUDY.RealTimeSolving.Weekly27;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SalaryBox {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        Scanner sc=new Scanner(System.in);
        for (int testCase = 1; testCase <=T; testCase++) {
            int n=Integer.parseInt(br.readLine());
            double avg=0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st=new StringTokenizer(br.readLine());
                double p=Double.parseDouble(st.nextToken());
                System.out.println("p = " + p);
                double salary=Double.parseDouble(st.nextToken());

                System.out.println("salary = " + salary);
                avg+=(salary*p);
            }
            sb.append("#"+testCase+" "+String.format("%.6f",avg)+"\n");;
        }
        System.out.println(sb);
    }
}
