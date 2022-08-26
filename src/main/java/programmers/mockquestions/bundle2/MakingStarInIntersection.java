package programmers.mockquestions.bundle2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MakingStarInIntersection {
	/**
	 note : 필요해 보이는 기능들: 교점 구하기 기능(5개의 점), 교점에 대해 배열의 자리로 변환하는 기능
	  - 교점 구하기 기능
	  - 두 직선이 교차하는 여부도 판단해야 함.
	  - 1000개 인데.. 1 + 2
	  - 교점들에 대해 배열 자리로 변환하는 기능
	  - 교점들에 대해 배열 자리에 표시하는 기능
	 */
	public String[] solution(int[][] line) {
		ArrayList<Point> points=new ArrayList<>();

		long minX=Long.MAX_VALUE;
		long minY=Long.MAX_VALUE;
		long maxX=Long.MIN_VALUE;
		long maxY=Long.MIN_VALUE;

		for(int i=0; i<line.length-1; i++){
			long a=line[i][0];
			long b=line[i][1];
			long e=line[i][2];

			for(int j=i+1; j<line.length; j++){
				long c=line[j][0];
				long d=line[j][1];
				long f=line[j][2];

				long adbc= a*d-b*c;

				if(adbc==0) continue; //평행

				long bfed= b*f-e*d;
				if(bfed%adbc!=0) continue; //x가 정수x

				long ecaf= e*c-a*f;
				if(ecaf%adbc!=0) continue; //y가 정수x

				long x= bfed/adbc;
				long y= ecaf/adbc;

				points.add(new Point(y,x));

				minX=Math.min(minX,x);
				minY=Math.min(minY,y);
				maxX=Math.max(maxX,x);
				maxY=Math.max(maxY,y);
			}
		}

		long row=maxY-minY+1;
		long col=maxX-minX+1;

		String[] answer=new String[(int)row];
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<col; i++){
			sb.append(".");
		}

		Arrays.fill(answer,sb.toString());

		for(Point point: points){
			long insertY=maxY-point.y;
			long insertX=point.x-minX;
			answer[(int)insertY]=answer[(int)insertY].substring(0,(int)insertX)+"*"+
				answer[(int)insertY].substring((int)insertX+1);
		}

		return answer;
	}

	class Point{
		long y,x;

		public Point(long y,long x){
			this.y=y;
			this.x=x;
		}
	}
}
