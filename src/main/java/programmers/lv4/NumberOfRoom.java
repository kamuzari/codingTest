package programmers.lv4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class NumberOfRoom {

	class Node{
		int y,x;

		public Node(int y,int x){
			this.y=y;
			this.x=x;
		}

		public boolean equals(Object o){
			Node o1=(Node) o;

			return this.y==o1.y && this.x == o1.x;
		}

		public int hashCode(){
			return Objects.hash(y,x);
		}
	}
	int dy[]={-1,-1,0,1,1,1,0,-1},dx[]={0,1,1,1,0,-1,-1,-1};

	/**
	 * 2배율 := 스케일 아웃 하여 재방문 counting 처리
	 *
	 */
	public int solution(int[] arrows) {
		int answer = 0;
		Node cur=new Node(0,0);
		Map<Node,List<Node>> v=new HashMap<>();

		for(int dir: arrows){
			int repeat=2;
			while(repeat-->0){
				Node next=new Node(cur.y+dy[dir],cur.x+dx[dir]);
				if(!v.containsKey(next)){ // 처음 방문
					List<Node> edges=new ArrayList<>();
					edges.add(cur);
					v.put(next, edges);

					if(v.get(cur)==null){
						List<Node> edges2=new ArrayList<>();
						edges2.add(next);
						v.put(cur,edges2);
					}else{
						v.get(cur).add(next);
					}
				}else if(v.containsKey(next) && !v.get(next).contains(cur)){
					// next 정점에 이미 다른 노드가 도달한 이력이 있으며 새로운 간선이 생기는 경우 := 도형이 만들어지는 경우
					v.get(next).add(cur);
					v.get(cur).add(next);
					answer++; //도형 생성
				}

				cur= next;
			}
		}
		return answer;
	}
}
