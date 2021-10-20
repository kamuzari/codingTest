package Basic.SolvedAC3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ1074_Z {
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int size=(int)Math.pow(2,n);

//        recursion(size,r,c);
        loop(size,r,c);
        System.out.println(answer);
    }

    private static void recursion(int size, int r, int c) {
        if(size==1) return;
        int divide=size/2;
        if(r<divide && c<divide){
            answer+=divide*divide*0;
            recursion(divide,r,c);
        }else if(r<divide && c>=divide){
            answer+=divide*divide*1;
            recursion(divide,r,c-divide);
        }else if(r>=divide && c<divide){
            answer+=divide*divide*2;
            recursion(divide,r-divide,c);
        }else {
            answer+=divide*divide*3;
            recursion(divide,r-divide,c-divide);
        }
    }
    private static int loop(int size,int r,int c){
        int anwer=0;
        int y=0,x=0;
        while (size>0){
            size/=2;
            if(r<y+size && c<x+size){
                answer+=size*size*0;
            }else if(r<y+size && c>=x+size){
                answer+=size*size*1;
                x+=size;
            }else if(r>=y+size && c<x+size){
                answer+=size*size*2;
                y+=size;
            }else{
                answer+=size*size*3;
                y+=size;
                x+=size;
            }
            if(size==1){
                break;
            }
        }
        return answer;
    }
}
