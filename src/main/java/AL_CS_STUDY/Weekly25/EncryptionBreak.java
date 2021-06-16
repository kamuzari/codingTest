package AL_CS_STUDY.Weekly25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class EncryptionBreak {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String str[] = new String[n];
            for (int i = 0; i < n; i++) {
                str[i] = br.readLine();
            }

            String decodeSentence = br.readLine();
            String x = br.readLine();
            boolean strFlag[] = new boolean[n];
            Map<Character, Character> arr[] = new Map[n];
            for (int i = 0; i < n; i++) {
                String s = str[i];
                boolean flag = true;
                arr[i] = new LinkedHashMap<>();
                for (int j = 0; j < s.length(); j++) {
                    char key = s.charAt(j);
                    if (!arr[i].containsKey(key)) {
                        arr[i].put(key, decodeSentence.charAt(j));
                    } else {
                        if (arr[i].get(key) != decodeSentence.charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    strFlag[i] = true;
                }
            }

            System.out.println(Arrays.toString(arr));

        }
    }
}
