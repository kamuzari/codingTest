package AL_CS_STUDY.RealTimeSolving.Weekly24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class TitleAttach {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        Map<Character, Boolean> map=new LinkedHashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char)(65+i),false);
        }
        for (int i = 0; i < testCase; i++) {
            int n=Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                String str=br.readLine() ;
                char key = str.charAt(0);
                map.put(key,true);
            }
            int cnt=0;
            for (Character ch : map.keySet()) {
                if(map.get(ch))
                    cnt++;
                else
                    break;
            }
            for (Character character : map.keySet()) {
                map.put(character,false);
            }

            sb.append("#").append(i+1).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
