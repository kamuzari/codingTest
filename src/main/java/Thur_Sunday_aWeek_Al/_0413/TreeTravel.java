package Thur_Sunday_aWeek_Al._0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTravel {
    static int in[], post[], idx[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        in=new int[n];
        post=new int[n];
        idx=new int[n+1];
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i]=Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            idx[in[i]]=i;
        }

            divide(0,n-1,0,n-1);
    }
    static void divide(int inS,int inE,int postS,int postE)
    {
        if(inS>inE || postS>postE)
            return;

        int root=post[postE];
        System.out.print(root+" ");
        int index=idx[root];
        int left=index-inS;
        divide(inS,index-1,postS,postS+left-1);
        divide(index+1,inE,postS+left,postE-1);

    }
}
/*
7
4 2 7 5 1 3 6
4 7 5 2 6 3 1

-> 1 2 4 5 7 3 6
*/