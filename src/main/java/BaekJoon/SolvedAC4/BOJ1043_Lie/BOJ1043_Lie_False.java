package BaekJoon.SolvedAC4.BOJ1043_Lie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 3% 틀림..

public class BOJ1043_Lie_False {
    // 서로서 집합 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        Map<Integer,List<Integer>> parties=new HashMap<>();
        int n=Integer.parseInt(st.nextToken());
        boolean truthPersons[]=new boolean[n+1];
        int m=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        int person=Integer.parseInt(st.nextToken());
        for (int i = 0; i < person; i++) {
            truthPersons[Integer.parseInt(st.nextToken())]=true;
        }

        List<Integer> list[]=new List[m];
        for (int i = 0; i < m; i++) {
            list[i]=new ArrayList<>();
            st=new StringTokenizer(br.readLine());
            st.nextToken();

            boolean isExistTruthPerson=false;
            while (st.hasMoreTokens()){
                int people = Integer.parseInt(st.nextToken());
                if(truthPersons[people]) isExistTruthPerson=true; // 진실 사람 있다
                list[i].add(people);
            }
            if(isExistTruthPerson){ // 있으면 영향력 전파되어 진실이 사람이 됨.
                for(Integer people : list[i]){
                    truthPersons[people]=true;
                }
            }
            parties.put(i,list[i]); // 파티에 집어넣음
        }
        for (int i = m-1; i >=0 ; i--) { // 다시 뽑아서 영향력을 전파하기 반대로 검사
            List<Integer> peoples = list[i];
            boolean isExistTruthPerson=false;
            for (Integer people : peoples) {
                if(truthPersons[people]) isExistTruthPerson=true;
            }
            if(isExistTruthPerson){ // 영향력 전파
                for(Integer people : list[i]){
                    truthPersons[people]=true;
                }
            }
        }
        int answer=0;
        for(List<Integer> peoples :parties.values()){
            boolean flag=true;
            for(Integer people : peoples){
                if(truthPersons[people]) {
                    flag=false;
                    break;
                }
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }
}
/*
5 5
1 3
1 1
2 1 2
2 1 3
2 1 4
2 1 5
ans : 0

6 5
1 6
2 1 2
2 2 3
2 3 4
2 4 5
2 5 6


6 5
1 6
2 1 2
2 2 3
2 5 6
2 3 4
2 3 5
ans : 0

4 4
1 4
0
0
3 1 2 3
2 1 4
ans : 2
 */
