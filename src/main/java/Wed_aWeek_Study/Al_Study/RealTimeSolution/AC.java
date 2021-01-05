package Wed_aWeek_Study.Al_Study.RealTimeSolution;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class AC{
    public static String func;
    public static int n, dequeue[];
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int i, t = Integer.parseInt(in.readLine());
        StringBuilder res = new StringBuilder();
        String line[];
        while(t-->0){
            func = in.readLine();
            dequeue = new int[n = Integer.parseInt(in.readLine())];
            //[과 ]을 모두 제거하고 ,을 기준으로 쪼개서 배열 생성
            line = in.readLine().replaceAll("[\\[\\]]", "").split(",");
            for(i=0;i<n;i++)
                dequeue[i] = Integer.parseInt(line[i]);

            res.append(calc());
        }
        out.write(res.toString());
        out.close();
        in.close();
    }

    //R, D 연산
    private static String calc(){
        int i, funcLen = func.length(), front = 0, rear = n-1, ptr = front, numberOfR = 0;
        char cmd;
        for(i=0;i<funcLen;i++){
            cmd = func.charAt(i);
            //리버스
            if(cmd=='R'){
                numberOfR++;
                if(ptr==front) ptr = rear;
                else if(ptr==rear) ptr = front;
            }
            //포인터가 가리키는 값 삭제
            else{
                if(!del(ptr)) return "error\n"; //삭제 실패시 error
                else if(ptr==front) ptr = ++front;
                else if(ptr==rear) ptr = --rear;
            }
        }
        return print(numberOfR);
    }

    private static boolean del(int ptr){
        try{
            dequeue[ptr] = 0; //0이면 삭제된거
        }
        catch(Exception e){
            return false; //에러나면 false
        }
        return true;
    }

    private static String print(int numbser){
        int i;
        StringBuilder res = new StringBuilder();

        //R이 짝수개면 초기 방향
        if(numbser%2==0){
            for(i=0;i<n;i++)
                if(dequeue[i]!=0)
                    res.append(dequeue[i]+",");
        }
        //R이 홀수개면 역방향
        else{
            for(i=n-1;i>=0;i--)
                if(dequeue[i]!=0)
                    res.append(dequeue[i]+",");
        }

        String tmp = res.toString();
        //1,2,3, 처럼 되있는거를 [1,2,3]으로 만들던가, 아무것도 없으면 []로 만들어서 출력
        tmp = tmp.length()>0 ? String.format("[%s]\n", tmp.substring(0,tmp.length()-1)) : "[]\n";
        return tmp;
    }
}
