package BaekJoon.SolvedAC4.BOJ9935_ExplosionString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935_ExplosionString {
    private static final String DEFAULT="FRULA";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        int n = original.length();
        char result[] = new char[n];

        char boomb[] = br.readLine().toCharArray();

        int boombLength = boomb.length;

        StringBuilder answer = new StringBuilder();

        int curIdx = 0;
        for (int i = 0; i < n; i++) {
            result[curIdx++] = original.charAt(i);
            if(result[curIdx-1]==boomb[boombLength-1]){
                if(curIdx-boombLength<0){
                    continue;
                }

                boolean isDiscoveryBoombString=true;
                for(int j=0; j<boombLength; j++){
                    if(result[curIdx-1-j]!=boomb[boombLength-1-j]){
                        isDiscoveryBoombString=false;
                        break;
                    }
                }
                if(isDiscoveryBoombString){
                    curIdx-=boombLength;
                }
            }
        }

        if(curIdx==0){
            System.out.println(DEFAULT);
        }else{
            for(int i=0; i<curIdx; i++){
                answer.append(result[i]);
            }
            System.out.println(answer);
        }

    }
}
