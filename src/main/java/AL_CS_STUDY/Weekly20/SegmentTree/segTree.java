package AL_CS_STUDY.Weekly20.SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
 *  풀이 1.
 *  Tree 및 Node class 만들어서 root node를 이용해서 풀이
 */

public class segTree {
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 9, 6, 4, 1, 2, 1};

        SegmentTree segmentTree = new SegmentTree(arr, 9);

        System.out.println(Arrays.toString(segmentTree.seg));


    }
}
class SegmentTree
{
    int [] seg;
    public SegmentTree(int arr[],int n) {
        //int x = (int) Math.ceil(Math.log(n) / Math.log(2));

        //int segmentSize = (int) Math.pow(2, x) * 2 - 1;

        //segmentArr = new int[segmentSize];
        seg=new int[(n*4)];
        init(arr,0,n-1,1);
    }
    public int init(int arr[],int l,int r,int node)
    {
        if(l==r)
        {
            return seg[node]=arr[l];
        }
        int mid=(l+r)/2;

        seg[node]+=init(arr,l,mid,node*2);
        seg[node]+=init(arr,mid+1,r,node*2+1);
        return seg[node];
    }
}