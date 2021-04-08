package thisCodingTest.Dynamic.PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntegerTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int trie[][]=new int[n+1][n+2];

        for (int i = 1; i < n+1; i++) {
            String str[]=br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                trie[i][j+1]=Integer.parseInt(str[j]);
            }
        }

        int len=n-1;
        for (int i = n-1; i >=1 ; i--) {
            for (int j = 1; j <=len ; j++) {
//                System.out.println(trie[i+1][j]+" "+trie[i+1][j+1]);
                trie[i][j]+=Math.max(trie[i+1][j],trie[i+1][j+1]);
            }
            len--;
        }
        System.out.println(trie[1][1]);
    }
}
