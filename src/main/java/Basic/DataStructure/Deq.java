package Basic.DataStructure;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

// 스택 수열 다시 한번 해보기;;
public class Deq {
    //add 마지막에 삽입 - push 앞에 삽입
    // pop 맨 앞에 제거-pollFirst =pollLast
    //peek 제일 앞에꺼  peekFirst =peekLast

    public static void main(String args[]) throws IOException{
        Deque <String> dq=new ArrayDeque<String>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int N=Integer.parseInt(br.readLine());

        while(N-->0)
        {
            String instuction=br.readLine();
            String ins[]=instuction.split(" ");

            switch (ins[0]) {

                case "push_front":
                    dq.push(ins[1]);
                    break;
                case "push_back":
                    dq.add(ins[1]);
                    break;
                case "pop_front":
                    if(dq.isEmpty())
                    {
                        bw.write("-1\n");
                    }
                    else
                        bw.write(dq.pollFirst()+"\n");
                    break;
                case "pop_back":
                    if(dq.isEmpty())
                    {
                        bw.write("-1\n");
                    }
                    else
                        bw.write(dq.pollLast()+"\n");
                    break;
                case "size":
                    bw.write(dq.size()+"\n");
                    break;
                case "empty":
                    if(dq.isEmpty())
                    {
                        bw.write("1\n");
                    }
                    else
                        bw.write("0\n");
                    break;
                case "front":
                    if(dq.isEmpty())
                    {
                        bw.write("-1\n");
                    }
                    else
                        bw.write(dq.peekFirst()+"\n");
                    break;
                case "back":
                    if(dq.isEmpty())
                    {
                        bw.write("-1\n");
                    }
                    else
                        bw.write(dq.peekLast()+"\n");
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}