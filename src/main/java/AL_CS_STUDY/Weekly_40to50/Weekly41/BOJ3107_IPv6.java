package AL_CS_STUDY.Weekly_40to50.Weekly41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ3107_IPv6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String input[]=br.readLine().split(":");

        for (int i = 0; i < input.length; i++) {
            if(input[i].length()!=4){
                StringBuffer sb=new StringBuffer(input[i]);
                for (int j = 0; j < 4-input[i].length(); j++) {
                    sb.insert(0,'0');
                }
                input[i]=sb.toString();
            }
        }
        if (input.length < 8) {
             input = fillZero(input);
        }
        System.out.println(appendString(input));
    }
    private static String appendString(String[] split) {
        StringBuilder sb = new StringBuilder();

        for (String s : split)
            sb.append(s + ":");

        sb = sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private static String[] fillZero(String[] spilit) {
        String subAnswers[]=new String[8];
        int ansIdx=0;
        int spilitIdx=0;
        if(spilit.length==0){
            for (int i = 0; i < subAnswers.length; i++) {
                subAnswers[i]="0000";
            }
        }else{
            while (ansIdx<8){
                if(spilitIdx<spilit.length && !spilit[spilitIdx].equals("0000") ){
                    subAnswers[ansIdx++]=spilit[spilitIdx++];
                }
                else{
                    while (subAnswers.length-ansIdx!=spilit.length-spilitIdx){
                        subAnswers[ansIdx++]="0000";
                        if(spilitIdx<spilit.length && spilit[spilitIdx].equals("0000")){
                            spilitIdx++;
                        }
                    }
                }
            }
        }
        return subAnswers;
    }

}
