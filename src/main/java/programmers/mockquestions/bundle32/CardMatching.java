package programmers.mockquestions.bundle32;

import java.util.LinkedList;
import java.util.List;

public class CardMatching {
	public static void main(String[] args) {

	}
	class Node{
		private int y,x,dist;
		public Node(int y,int x){
			this.y=y;
			this.x=x;
		}
		public Node(int y,int x,int dist){
			this.y=y;
			this.x=x;
			this.dist=dist;
		}

		public void newSettings(int y,int x){
			this.y=y;
			this.x=x;
		}

		public boolean isEqual(Node cur) {
			return this.y==cur.y && this.x==cur.x;
		}
	}
	private List<int[]> NumberOfCase=new LinkedList<>();
	private int n,m,cardPairNumber[];
	private int dy[]={-1,1,0,0};
	private int dx[]={0,0,-1,1};
	private final int ENTER=1;
	public int solution(int[][] board, int r, int c) {
		int answer = Integer.MAX_VALUE;
		n=board.length;
		m=board[0].length;
		int count=0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(board[i][j]!=0){
					count++;
				}
			}
		}
		// AtomicInteger count = new AtomicInteger();
		// Arrays.stream(board).forEach((int[] b) -> Arrays.stream(b).filter(value -> value != 0).forEach(value -> {
		//     count.getAndIncrement();
		// }));
		// 4,2,1
		int size=count/2;
		cardPairNumber = new int[size];
		for (int i = 0; i < size; i++) {
			cardPairNumber[i] = i + 1;
		}
		pick(0,size,new boolean[size],new int[size]);

		for(int [] result : NumberOfCase){
			int totalMovingCnt=0;
			Node start=new Node(r,c);
			int copyB[][]=new int[n][m];

			for(int i=0; i<n; i++){
				copyB[i]=board[i].clone();
			}

			for(int number : result){
				int cnt=0;
				cnt+=bfs(copyB,number,start)+ENTER;
				copyB[start.y][start.x]=0;

				cnt+=bfs(copyB,number,start)+ENTER;
				copyB[start.y][start.x]=0;
				totalMovingCnt+=cnt;
			}
			answer=Math.min(totalMovingCnt,answer);
		}
		return answer;
	}
	private void pick(int cnt,int target,boolean v[],int result[]){
		if(cnt==target){
			NumberOfCase.add(result.clone());
			return;
		}
		for(int i=0; i<target; i++){
			if(!v[i]){
				v[i]=true;
				result[cnt]=cardPairNumber[i];
				pick(cnt+1,target,v,result);
				v[i]=false;
			}
		}
	}

	private int bfs(int b[][],int targetNumber,Node start){
		LinkedList<Node> q=new LinkedList<>();
		q.offer(new Node(start.y,start.x,0));
		boolean v[][]=new boolean[b.length][b[0].length];
		v[start.y][start.x]=true;

		while(!q.isEmpty()){
			Node cur=q.poll();
			if(b[cur.y][cur.x]==targetNumber){
				start.newSettings(cur.y,cur.x);
				return cur.dist;
			}
			for(int i=0; i<4; i++){
				int ny=dy[i]+cur.y;
				int nx=dx[i]+cur.x;
				if(indexOutOf(ny,nx) || v[ny][nx]){
					continue;
				}
				v[ny][nx]=true;
				q.offer(new Node(ny,nx,cur.dist+1));
			}
			for(int i=0; i<4; i++){
				Node nextCard=findCard(b,cur,i);
				if(!nextCard.isEqual(cur)) {
					v[nextCard.y][nextCard.x] = true;
					q.offer(new Node(nextCard.y, nextCard.x, cur.dist + 1));
				}
			}
		}
		return 0;
	}
	public Node findCard(int b[][],Node cur,int dir){
		int ny=cur.y+dy[dir];
		int nx=cur.x+dx[dir];
		while(!indexOutOf(ny,nx)){
			if(b[ny][nx]!=0){
				return new Node(ny,nx);
			}
			ny+=dy[dir];
			nx+=dx[dir];
		}
		return new Node(ny-dy[dir],nx-dx[dir]);
	}

	private boolean indexOutOf(int ny,int nx){
		return ny<0 || nx <0 || ny>n-1 || nx>m-1;
	}
}
