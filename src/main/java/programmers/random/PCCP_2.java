package programmers.random;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class PCCP_2 {
	class Node{
		private int y;
		private int x;

		public Node(int y,int x){
			this.y=y;
			this.x=x;
		}
	}

	Map<Integer, Integer> areaCount;
	int dy[]={-1,1,0,0};
	int dx[]={0,0,-1,1};
	int n=0;
	int m=0;
	public int solution(int[][] land) {
		areaCount=new HashMap<>();
		n=land.length;
		m=land[0].length;

		int id=100;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(land[i][j]==1){
					searchArea(i,j,land,id);
					id++;
				}
			}
		}

		int answer=0;

		for(int i=0; i<m; i++){
			Set<Integer> ids=new HashSet<>();
			int totalOilAmount=0;
			for(int j=0; j<n; j++){
				if(land[j][i]==0) continue;

				int identification=land[j][i];
				if(ids.contains(identification)) continue;

				ids.add(identification);
				totalOilAmount+=areaCount.get(identification);
			}

			answer=Math.max(answer, totalOilAmount);
		}

		return answer;
	}


	public void searchArea(int y,int x,int[][] land, int id){
		int totalAreaCount=0;
		LinkedList<Node> q=new LinkedList<>();
		q.offer(new Node(y,x));
		land[y][x]=id;

		while(!q.isEmpty()){
			totalAreaCount++;
			Node cur=q.poll();
			for(int i=0; i<4; i++){
				int ny=cur.y + dy[i];
				int nx=cur.x + dx[i];

				if(isOutOfRange(ny,nx)) continue;
				if(land[ny][nx]!=1) continue;

				land[ny][nx]=id;
				q.offer(new Node(ny,nx));
			}

		}

		areaCount.put(id,totalAreaCount);
	}

	public boolean isOutOfRange(int ny,int nx){
		return ny<0 || nx<0 || ny>=n || nx>=m;
	}
}
