package programmers.lv2;

import java.util.ArrayList;
import java.util.List;

public class UnInHabitedIslandTravel {
	int n,m,live=0;

	char[][] map;
	boolean[][] v;

	int dy[]={-1,1,0,0};
	int dx[]={0,0,-1,1};
	public int[] solution(String[] maps) {
		List<Integer> answers=new ArrayList<>();
		n=maps.length;
		m=maps[0].length();

		map=new char[n][m];

		for(int i=0; i<n; i++){
			map[i]=maps[i].toCharArray();
		}

		v=new boolean[n][m];

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(Character.isDigit(map[i][j]) && !v[i][j]){
					live=0;
					dfs(i,j);
					answers.add(live);
				}
			}
		}

		if(answers.isEmpty()){
			return new int[]{-1};
		}

		return answers.stream()
			.sorted((o1,o2)->o1-o2)
			.mapToInt(val-> val)
			.toArray();
	}

	public void dfs(int y,int x){
		v[y][x]=true;
		live+=Character.getNumericValue(map[y][x]);
		for(int i=0;i<4; i++){
			int ny=dy[i]+y;
			int nx=dx[i]+x;

			if(isOutOfRange(ny,nx)) continue;
			if(v[ny][nx]) continue;
			if(!Character.isDigit(map[ny][nx])) continue;

			dfs(ny,nx);
		}
	}

	public boolean isOutOfRange(int ny,int nx){
		return ny<0 || nx<0 || ny>=n || nx>=m;
	}
}
