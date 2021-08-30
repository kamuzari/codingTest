package AL_CS_STUDY.RealTimeSolving.Weekly_20to30.Weekly23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MirrorString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        Map<Character,Character> map=new HashMap<>();
        map.put('b','d');
        map.put('d','b');
        map.put('p','q');
        map.put('q','p');

        for (int i = 1; i <= testCase; i++) {
            String str=br.readLine();
            String answer="";
            for (int j = str.length()-1; j >=0; j--) {
                answer += map.get(str.charAt(j));
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }


}
