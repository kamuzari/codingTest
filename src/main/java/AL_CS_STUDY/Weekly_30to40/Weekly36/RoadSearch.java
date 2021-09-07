package AL_CS_STUDY.Weekly_30to40.Weekly36;

import java.util.Arrays;
import java.util.Comparator;

public class RoadSearch {

    public static void main(String[] args) {
        RoadSearch roadSearch = new RoadSearch();
        int [][] info={{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};

        roadSearch.solution(info);
    }
    private int[][] answer;
    private int idx =0 ;
    class Node implements Comparable<Node>{

        private int idx,x,y;
        private Node L,R;

        public Node(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public void ConnectLeft(Node l) {
            L = l;
        }

        public void ConnectRight(Node r) {
            R = r;
        }

        private boolean isEmptyLeft()
        {
            return this.L==null;
        }
        private boolean isEmptyRight()
        {
            return this.R==null;
        }

        @Override
        public int compareTo(Node o) {
            return o.y-this.y;
        }
    }

    Comparator<Node> comp=new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.y-o2.y==0)
                return o1.x-o2.x;
            return o2.y-o1.y;
        }
    };

    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        Node [] nodes=new Node[nodeinfo.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i]=new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]);
        }

        Arrays.sort(nodes,comp);

        Node root=nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            insert(root,nodes[i]);
        }
        preOrder(root);
        idx=0;
        postOrder(root);
        System.out.println(Arrays.toString(answer[0]));
        System.out.println(Arrays.toString(answer[1]));
        return answer;
    }
    public void insert(Node parent,Node child)
    {
        if(parent.x>child.x)
        {
            if(parent.isEmptyLeft())
            {
                parent.ConnectLeft(child);
            }
            else
            {
                insert(parent.L,child);
            }
        }
        else
        {
            if(parent.isEmptyRight())
            {
                parent.ConnectRight(child);
            }
            else
            {
                insert(parent.R,child);
            }
        }
    }
    public void preOrder(Node node)
    {
        if(node!=null)
        {
            answer[0][idx++]=node.idx;
            preOrder(node.L);
            preOrder(node.R);
        }
    }

    public void postOrder(Node node)
    {
        if(node!=null)
        {
            postOrder(node.L);
            postOrder(node.R);
            answer[1][idx++]=node.idx;
        }
    }
}

