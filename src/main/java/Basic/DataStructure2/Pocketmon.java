package Basic.DataStructure2;

import java.util.*;
import java.io.*;

public class Pocketmon {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        Map<String ,Integer> map=new LinkedHashMap<>();
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()   );
        int m=Integer.parseInt(st.nextToken());
        String arr[]=new String[n];
        for (int i = 0; i < n; i++) {
            arr[i]=br.readLine();
            if(!map.containsKey(arr[i]))
                map.put(arr[i],i);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if(Character.isAlphabetic(s.charAt(0)))
            {
               sb.append(map.get(s)+1).append("\n");
            }
            else if(Character.isDigit(s.charAt(0)))
            {
                sb.append(arr[Integer.parseInt(s)-1]).append("\n");
            }
        }
        System.out.println(sb);
    }

}
