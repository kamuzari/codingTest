package WeeklyThuseday._0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Enrolment {
    static Set<String> set=new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < l; i++) {
            String s = br.readLine();
            set.remove(s);
            set.add(s);
        }

        for (String s : set) {
            if (k == 0)
                break;
            sb.append(s).append("\n");
            k--;
        }
        System.out.println(sb);
//        Iterator<String> iter=set.iterator();
//        while (k-->0 && iter.hasNext())
//            sb.append(iter.next()).append("\n");

//        System.out.println(sb);
    }
}
