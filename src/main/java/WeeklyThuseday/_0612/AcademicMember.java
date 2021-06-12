package WeeklyThuseday._0612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AcademicMember {

    private static Map<String, ArrayList<String>> map;
    private static Set<String> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new LinkedHashMap<>();
        visited = new LinkedHashSet<>();
        while (true)
        {
            int n=Integer.parseInt(br.readLine());
            map.clear();
            visited.clear();
            if(n==0)
                break;
            String target="";
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), ":|,|.");
                String key=st.nextToken();

                if(i==0)
                    target=key;
                if(!map.containsKey(key))
                {
                    map.put(key,new ArrayList<>());
                }

                while (st.hasMoreTokens())
                {
                    map.get(key).add(st.nextToken());
                }
            }
                visited.add(target);
                System.out.println(recur(target,0));
        }
    }
    static int recur(String key,int cnt)
    {
        if(map.containsKey(key))
        {
            for (String s : map.get(key)) {
                if(!visited.contains(s))
                {
                    visited.add(s);
                    cnt+=recur(s,map.get(s)==null ? 1:0);
                }
            }
        }
        return cnt;
    }

}
