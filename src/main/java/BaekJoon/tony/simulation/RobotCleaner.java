package BaekJoon.tony.simulation;

import java.util.Scanner;
import java.util.StringTokenizer;

public class RobotCleaner {
	static Scanner sc=new Scanner(System.in);
	static StringTokenizer st;
	static int dy[]={-1,0,1,0}; // 북 동 남 서  90도 회전
	static int dx[]={0,1,0,-1};
	static int n,m,answer;
	static int[][] map;
	public static void main (String[] args) throws java.lang.Exception {
		st=new StringTokenizer(in());
		n=to(next());
		m=to(next());

		st=new StringTokenizer(in());
		int sy=to(next());
		int sx=to(next()) ;
		int dir=to(next());

		map=new int[n][m];
		int one=0,zero=0;
		for(int i=0; i<n; i++){
			st=new StringTokenizer(in());
			for(int j=0; j<m; j++){
				map[i][j]=to(next());
				if(map[i][j]==1){
					one++;
				}else{
					zero++;
				}
			}
		}

		clean(sy,sx,dir);
		print(String.valueOf(answer));
	}

	static void clean(int y,int x, int dir){
		// print(String.format("y: %d | x: %d | dir: %d",y,x,dir));
		if(map[y][x]==0){
			map[y][x]=-2; // 청소
			answer++;
		}

		for(int i=0; i<4; i++){
			dir =(dir + 3) % 4;
			int ny= y+dy[dir];
			int nx= x+dx[dir];

			if(isOutOfRange(ny,nx)) continue;
			if(map[ny][nx]==0){
				clean(ny,nx,dir);
				return;
			}
		}

		int nextDir = (dir + 2) % 4; // 후진

		int ny= dy[nextDir] + y;
		int nx= dx[nextDir] + x;

		// 범위 넘지 않으며 벽이 아니여야 함
		if(!isOutOfRange(ny,nx) && map[ny][nx] !=1){
			clean(ny,nx,dir);
		}

	}

	static void print(String s){
		System.out.println(s);
	}

	static boolean isOutOfRange(int ny,int nx){
		return ny<0 || nx<0 || ny>=n || nx>=m;
	}

	static String next(){
		return st.nextToken();
	}
	static int to(String s){
		return Integer.parseInt(s);
	}

	static String in(){
		return sc.nextLine();
	}
}
