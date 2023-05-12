package BaekJoon.tony.simulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CandidateRefer {
	static Scanner sc=new Scanner(System.in);
	static class Node implements Comparable<Node>{
		int idx,order,refer;

		public Node(int idx,int refer,int order){
			this.idx=idx;
			this.refer=refer;
			this.order=order;
		}
		public int compareTo(Node o){
			if(o.refer == this.refer){
				return o.order - this.order;
			}

			return o.refer - this.refer;
		}

		public boolean equals(Object o){
			Node o1=(Node)o;

			return this.idx == o1.idx && this.refer == o1.refer && this.order == o1.order;
		}

		public void increase(){
			this.refer+=1;
		}

		public int hashCode(){
			return Objects.hash(idx,refer,order);
		}
	}
	public static void main(String []args){
		int size=parse(sc.nextLine());
		int n=parse(sc.nextLine());
		StringTokenizer st=new StringTokenizer(sc.nextLine());
		int refers[]=new int[n];
		for(int i=0; i<n; i++){
			refers[i]=parse(st.nextToken());
		}
		int order=0;

		Map<Integer, Node> map=new HashMap<>();
		for(int referer: refers){

			if(map.containsKey(referer)){
				map.get(referer).increase();
				continue;
			}

			if(map.size() >= size){
				List<Node> rankings=map.keySet().stream()
					.map(key-> map.get(key))
					.sorted()
					.collect(Collectors.toList());

				Node last=rankings.get(rankings.size()-1);
				map.remove(last.idx);
			}

			map.put(referer,new Node(referer,1,order++));
		}

		int[] answer=map.keySet().stream()
			.map(key-> map.get(key).idx)
			.sorted((a,b)-> a-b)
			.mapToInt(v->v)
			.toArray();

		for(int i=0; i<answer.length; i++){
			System.out.print(answer[i]+" ");
		}
	}

	static int parse(String s){
		return Integer.parseInt(s);
	}
}
