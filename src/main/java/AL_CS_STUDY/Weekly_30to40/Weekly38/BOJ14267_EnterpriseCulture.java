package AL_CS_STUDY.Weekly_30to40.Weekly38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14267_EnterpriseCulture {

    static List<Integer> list[];
    static int compilment[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        compilment=new int[n+1];
        list=new List[n+1];

        for (int i = 0; i < n+1; i++) {
            list[i]=new ArrayList<>();
        }
        st=new StringTokenizer(br.readLine());
        for (int i = 1; i <=n ; i++) {
            int parent=Integer.parseInt(st.nextToken());
            if(parent!=-1){
                list[parent].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st=new StringTokenizer(br.readLine());
            int employee=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            compilment[employee]+=weight;
        }
        chainCompliment(1);
        for (int i = 1; i <= n; i++) {
            System.out.print(compilment[i]+" ");
        }

    }

    private static void chainCompliment(int start) {
        for (Integer nextEmployee : list[start]) {
            compilment[nextEmployee]+=compilment[start];
            chainCompliment(nextEmployee);
        }
    }
}
