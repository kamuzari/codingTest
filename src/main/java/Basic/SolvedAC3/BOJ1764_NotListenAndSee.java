package Basic.SolvedAC3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764_NotListenAndSee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        Set<String> set=new HashSet<>();
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> answers=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            boolean isExist = set.add(input);
            if(!isExist){
                answers.add(input);
            }
        }
        Collections.sort(answers);
        System.out.println(answers.size());
        answers.forEach(val->System.out.println(val));
    }
}
