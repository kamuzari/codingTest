package tues_thurs_sat.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class simulation_Hallegali {
    static Deque<Integer> doDack=new LinkedList<>();
    static Deque<Integer> suDack=new LinkedList<>();

    static ArrayList<Integer> doGround=new ArrayList<>();
    static ArrayList<Integer> suGround=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(br.readLine());
            doDack.offerLast(Integer.parseInt(st.nextToken()));
            suDack.offerLast(Integer.parseInt(st.nextToken()));
        }
        while (m>0)
        {
            int dodo=doDack.pollLast();
            doGround.add(dodo);

            if(check())
            {
                return;
            }
            if(dodo==5)
            {
                //dodo가 종치고 가져오기
                doGet();
            }
            else if(!suGround.isEmpty() && !doGround.isEmpty() && dodo+suGround.get(suGround.size()-1)==5)
            {
                suGet();
            }

            m--;
//
//            if(check())
//            {
//                return;
//            }

            if(m==0)
            {
                break;
            }

            int susu=suDack.pollLast();
            suGround.add(susu);

            if(check())
            {
                return;
            }
            if(susu==5)
            {
                doGet();
            }
            else if(!suGround.isEmpty() && !doGround.isEmpty() && susu+doGround.get(doGround.size()-1)==5)
            {
                suGet();
            }

            m--;
            if(m==0)
            {
                break;
            }
        }

        if(doDack.size()==suDack.size())
        {
            System.out.println("dosu");
        }
        else
        {
            int criteria = doDack.size()> suDack.size()? 1:-1;
            if(criteria==1)
            {
                System.out.println("do");
            }
            else
            {
                System.out.println("su");
            }
        }
    }

    private static boolean check() {
        if(doDack.isEmpty() || suDack.isEmpty())
        {
            if(doDack.size()==0)
            {
                System.out.println("su");
            }
            else
                System.out.println("do");

            return true;
        }
        return false;
    }

    private static void suGet() {
        while (!doGround.isEmpty())
        {
            suDack.addFirst(doGround.remove(0));
        }
        while (!suGround.isEmpty())
        {
            suDack.addFirst(suGround.remove(0));
        }
    }

    private static void doGet() {
        while (!suGround.isEmpty())
        {
            doDack.addFirst(suGround.remove(0));
        }
        while (!doGround.isEmpty())
        {
            doDack.addFirst(doGround.remove(0));
        }
    }
}
