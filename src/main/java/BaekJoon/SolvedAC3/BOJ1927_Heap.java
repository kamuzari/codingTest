package BaekJoon.SolvedAC3;
import java.util.*;
import java.io.*;
public class BOJ1927_Heap {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        List<Integer> answers=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int input=Integer.parseInt(br.readLine());
            if(input==0){
                if(pq.isEmpty()){
                    answers.add(0);
                }else{
                    answers.add(pq.poll());
                }
            }else{
                pq.offer(input);
            }
        }
        answers.forEach(System.out::println);
    }
}
