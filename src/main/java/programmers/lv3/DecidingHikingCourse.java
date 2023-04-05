package programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class DecidingHikingCourse {
	static final int INF=Integer.MAX_VALUE;

	class Node implements Comparable<Node>{
		int v,w;

		public Node(int v,int w){
			this.v=v;
			this.w=w;
		}

		@Override
		public int compareTo(Node o){
			return this.w - o.w;
		}
	}
	List<Node> adj[];
	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		adj=new List[n+1];
		for(int i=0; i<=n; i++){
			adj[i]=new ArrayList<>();
		}

		Set<Integer> starts=Arrays.stream(gates).boxed().collect(Collectors.toSet());
		Set<Integer> targets=Arrays.stream(summits).boxed().collect(Collectors.toSet());

		// 출입구 또는 봉우리는 반드시 한번 지나야한다! 그렇기에 출입구는 나가는 간선만, 봉우리는 들어가는 간선만
		for(int[] path: paths){
			int from=path[0];
			int to=path[1];
			int weight=path[2];
			if(starts.contains(from) || targets.contains(to)){
				adj[from].add(new Node(to,weight));
			}else if(starts.contains(to) || targets.contains(from)){
				adj[to].add(new Node(from,weight));
			}else{
				adj[from].add(new Node(to,weight));
				adj[to].add(new Node(from,weight));
			}
		}

		return dijkstra(n,gates,summits);
	}

	int[] dijkstra(int n,int[] gates, int[] summits){
		int intensities[]=new int[n+1]; // 현재까지 경로를 따라서 온 인텐시티의 최댓값
		Arrays.fill(intensities,INF);
		PriorityQueue<Node> pq=new PriorityQueue<>();

		for(int start:gates){
			intensities[start]=0;
			pq.offer(new Node(start,0));
		}

		while(!pq.isEmpty()){
			Node cur=pq.poll();

			if(intensities[cur.v] < cur.w) continue;

			for(Node next: adj[cur.v]){
				// 현재까지 온 인텐시티 최소값 과 현재 경로의 코스트 값 중 누가 큰가
				int intensity=Math.max(intensities[cur.v],next.w);
				if(intensities[next.v] > intensity){ // 현재까지 온 인텐시티 보다 큰게 있다면 교체
					intensities[next.v]=intensity;
					pq.offer(new Node(next.v, intensity));
				}

			}
		}
		int minIntensity=INF;
		int minSummit=0;

		Arrays.sort(summits); // 인텐시티가 같다면 가장 작은 봉우리를 가진 것이 우선
		for(int summit: summits){
			if(intensities[summit] <minIntensity){
				minIntensity=intensities[summit];
				minSummit=summit;
			}
		}

		return new int[]{minSummit,minIntensity};
	}
}
