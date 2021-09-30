package tues_thurs_sat._202109._20210928;
import java.util.*;
// 구현력 , 재귀함수
public class PGM67257_OperationMaximum {
    public static void main(String[] args) {
        PGM67257_OperationMaximum p = new PGM67257_OperationMaximum();
        long solution = p.solution("50*6-3*2");
        System.out.println(solution);
    }
    char ops[]=new char[]{'+','-','*'};
    char orders[]=new char[3];
    boolean v[]=new boolean[3];
    ArrayList<Long> numbers=new ArrayList<>();
    ArrayList<Character> operations=new ArrayList<>();
    long answer = 0;
    public long solution(String expression) {
        StringBuffer number=new StringBuffer();
        for(int i=0; i<expression.length();i++){
            char ch=expression.charAt(i);
            if(ch =='+' || ch=='-' || ch=='*'){
                operations.add(ch);
                numbers.add(Long.parseLong(number.toString()));
                number=new StringBuffer();
            }else{
                number.append(ch);
            }
        }
        numbers.add(Long.parseLong(number.toString()));
        pick(0);
        return answer;
    }

    private void pick(int cnt){
        if(cnt==3){
            answer=Math.max(answer,calc());
            return;
        }
        for(int i=0; i<3; i++){
            if(!v[i]){
                orders[cnt]=ops[i];
                v[i]=true;
                pick(cnt+1);
                v[i]=false;
            }
        }
    }
    private long calc(){
        ArrayList<Long> copyNumbers=new ArrayList<>(numbers);
        ArrayList<Character> copyOperations=new ArrayList<>(operations);
        long ret=0;
        for(int i=0; i<3; i++){
            for(int j=0; j<copyOperations.size();j++){
                char operation=copyOperations.get(j);
                if(orders[i]==operation){
                    if(orders[i]=='+'){
                        ret=copyNumbers.remove(j)+copyNumbers.remove(j);
                    }else if(orders[i]=='-'){
                        ret=copyNumbers.remove(j)-copyNumbers.remove(j);
                    }else if(orders[i]=='*'){
                        ret=copyNumbers.remove(j)*copyNumbers.remove(j);
                    }
                    copyNumbers.add(j,ret);
                    copyOperations.remove(j);
                    j--;
                }
            }
        }
        return Math.abs(copyNumbers.get(0));
    }
}
