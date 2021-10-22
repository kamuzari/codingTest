package Basic.SolvedAC3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1541_LostBracket {
    /*
    가장 작은 수가 되려면 가장 큰수를 빼준다.
    1.  덧셈먼저
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split("-");
        int answer=0;
        for (int i = 0; i < str.length; i++) {
            int temp=0;
            String[] add = str[i].split("\\+");
            temp+= Arrays.stream(add).map(Integer::parseInt).reduce(0, Integer::sum);
           if(i!=0)
                temp*=-1;
            answer+=temp;
        }
        System.out.println(answer);
    }
}
