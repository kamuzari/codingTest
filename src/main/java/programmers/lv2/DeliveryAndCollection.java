package programmers.lv2;

import java.util.TreeMap;

public class DeliveryAndCollection {
	/**
	 * 어차피 최고점으로(배달 또는 수거) 위치로 간다.
	 * 그 과정에서 택배 배달할것들을 미리 쌓아두고 최곡점으로 가면서 내려준다.
	 * 그리고 최고점으로부터 돌아올때 수거할수 있는 cap 양만큼 가져온다.
	 * 최고점을 이용하니 배열의 인덱스보다 편리한 TreeMap의 lastKey()를 이용하여
	 * 배달 개수 또는 수거 할 위치를 간편하게 찾을 수 있었다.
	 *
	 * @param cap
	 * @param n
	 * @param deliveries
	 * @param pickups
	 * @return
	 */
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		TreeMap<Integer, Integer> d = new TreeMap();
		for (int i = 0; i < n; i++) {
			if( deliveries[i] ==0 ) continue;
			d.put(i + 1, deliveries[i]);
		}
		TreeMap<Integer, Integer> p = new TreeMap();
		for (int i = 0; i < n; i++) {
			if( pickups[i] ==0 ) continue;
			p.put(i + 1, pickups[i]);
		}
		int todo = 0;
		int bring = 0;
		long totalDist = 0;
		while (true) {
			int todoD = d.size() == 0 ? 0 : d.lastKey();
			int todoP = p.size() == 0 ? 0 : p.lastKey();
			// 해당 목적지 최고점을 가면서 내려준다는 점
			if (todoD != 0) {
				while (todo != cap) {
					if (d.size() == 0)
						break;
					if (todo + d.get(d.lastKey()) <= cap) {
						todo += d.get(d.lastKey());
						d.remove(d.lastKey());
					} else {
						d.put(d.lastKey(), d.get(d.lastKey()) - (cap - todo));
						todo = cap;
					}
				}
			}

			if (todoP != 0) {
				while (bring != cap) {
					if (p.size() == 0)
						break;
					if (bring + p.get(p.lastKey()) <= cap) {
						bring+=p.get(p.lastKey());
						p.remove(p.lastKey());
					} else {
						p.put(p.lastKey(), p.get(p.lastKey()) - (cap - bring));
						bring = cap;
					}
				}
			}

			totalDist += Math.max(todoD, todoP) * 2;
			todo=0;
			bring=0;
			if(p.size()==0 && d.size()==0) break;
		}

		return totalDist;
	}
}
