package WeeklyThurseday.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class diameter_Tree{
    static class Node{
        int vertax, dist; //노드 번호, 거리
        public Node(int vertax, int dist){
            this.vertax = vertax;
            this.dist = dist;
        }
    }
    public static boolean visit[];
    public static int n, maxDist;
    public static Node maxDistNode;
    public static LinkedList<Node> tree[];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i, parent, child, dist;
        String line[];
        n = Integer.parseInt(br.readLine());
        tree = new LinkedList[n];
        visit = new boolean[n];
        for(i=0;i<n;i++) tree[i] = new LinkedList<>();
        for(i=1;i<n;i++){
            line = br.readLine().split(" ");
            parent = Integer.parseInt(line[0])-1; //노드번호 인덱스로 취급해 -1함
            child = Integer.parseInt(line[1])-1; // 위에와 똑같이.
            dist = Integer.parseInt(line[2]);
            tree[parent].add(new Node(child, dist)); //부모->자식
            tree[child].add(new Node(parent, dist)); //자식->부모
        }
        //루트로 부터 최대거리 노드(maxDistNode) 탐색
        for(Node root : tree[0]){ // tree[0] 번째가 루트 노드이므로 최댓값을 찾는다.\
            visit[0] = true;
            dfs(root, root.dist);
            visit[0] = false;
        }
        maxDist = 0; //다음 탐색을 위해 0으로 초기화
        //maxDistNode로 부터 최대거리 노드 탐색. maxDist에 최대 거리값이 담긴다.
        dfs(maxDistNode, 0);
        bw.write(String.valueOf(maxDist));
        bw.close();
        br.close();
    }

    private static void dfs(Node curNode, int dist){
        /* 현재 노드 재탐색 방지(양방향 그래프이기 때문)*/
        // 해주지 1->2->3->2 와 같이 중복탐색하게 됨 */
        visit[curNode.vertax] = true;

        for(Node tmp : tree[curNode.vertax]){
            if(!visit[tmp.vertax]){
                visit[tmp.vertax] = true;
                dfs(tmp, dist+tmp.dist);
                visit[tmp.vertax] = false;
            }
        }
        if(dist > maxDist){
            maxDistNode = curNode;
            maxDist = dist;
        }
        visit[curNode.vertax] = false;
    }
}

