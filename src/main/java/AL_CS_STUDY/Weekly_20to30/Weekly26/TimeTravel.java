package AL_CS_STUDY.Weekly_20to30.Weekly26;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TimeTravel {

    private static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        list[0]=new ArrayList<>();
        StringTokenizer st;
        int answer=0;
        StringBuilder sb=new StringBuilder();
        for (int i = 1; i <= n; i++) {
            list[i]=new ArrayList<>();
            st=new StringTokenizer(br.readLine());
            char cmd=st.nextToken().charAt(0);
            if(cmd=='a')
            {
                list[i].addAll(list[i-1]);
                list[i].add(Integer.parseInt(st.nextToken()));
                answer= list[i].get(list[i].size()-1);
            }
            else if(cmd=='s')
            {
                ArrayList<Integer> temp = list[i - 1];
                list[i].addAll(temp);
                answer=getLast(temp,i,'s');
            }

            else if(cmd=='t')
            {
                int val = Integer.parseInt(st.nextToken());
                ArrayList<Integer> past = list[val - 1];
                list[i].addAll(past);
                answer=getLast(past,i,'t');
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
    static int getLast(ArrayList<Integer> tmp, int i, char type) {
        int res = 0;
        if (type == 's')
            list[i].remove(tmp.size() - 1);
        if(list[i].size()==0)
            res = -1;
        else
            res = list[i].get(list[i].size() - 1);
        return res;
    }
}
