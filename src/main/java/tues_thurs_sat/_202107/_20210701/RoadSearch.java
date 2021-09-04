package tues_thurs_sat._20210701;
import java.util.*;

public class RoadSearch {
    class Node{
        int x,y,value;
        Node l,r;

        public Node(int x,int y,int value,Node l,Node r)
        {
            this.x=x;
            this.y=y;
            this.value=value;
            this.l=l;
            this.r=r;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + value +
                    ", l=" + l +
                    ", r=" + r +
                    '}';
        }
    }

    int [][] answer;
    int idx;
    public int[][] solution(int[][] nodeinfo) {
        int n=nodeinfo.length;
        Node[] node=new Node[n];
        for(int i=0; i<n;i++)
        {
            node[i]=new Node(nodeinfo[i][0],nodeinfo[i][1],i+1,null,null);
        }

        Arrays.sort(node,new Comparator<Node>(){
            @Override
            public int compare(Node o1,Node o2)
            {
                if(o1.y==o2.y) return o1.x-o2.x;
                return o2.y-o1.y;
            }
        });

        Arrays.toString(node);

        Node root=node[0];
        for(int i=1; i<n;i++)
        {
            insert(root,node[i]);
        }
        answer = new int [2][n];
        idx=0;
        preOrder(root);
        idx=0;
        postOrder(root);
        return answer;
    }
    public void insert(Node parent,Node child)
    {
        if(parent.x>child.x)
        {
            if(parent.l==null)
            {
                parent.l=child;
            }
            else{
                insert(parent.l,child);
            }
        }
        else
        {
            if(parent.r==null)
            {
                parent.r=child;
            }
            else{
                insert(parent.r,child);
            }
        }
    }
    public void preOrder(Node root)
    {
        if(root!=null)
        {
            answer[0][idx++]=root.value;
            preOrder(root.l);
            preOrder(root.r);
        }
    }

    public void postOrder(Node root)
    {
        if(root!=null)
        {

            postOrder(root.l);
            postOrder(root.r);
            answer[1][idx++]=root.value;
        }
    }
}
