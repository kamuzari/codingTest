package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmoticonDiscountEvent {
	final List<Integer> discounts = List.of(10, 20, 30, 40);
	List<int[]> sales = new ArrayList<>();

	class Buyer {
		int id, conditionPercent, limitCost, totalCost;

		public Buyer(int id, int conditionPercent, int limitCost, int totalCost) {
			this.id = id;
			this.conditionPercent = conditionPercent;
			this.limitCost = limitCost;
			this.totalCost = totalCost;
		}

		public boolean isPossible(int percent) {
			return conditionPercent <= percent;
		}

		public void add(int percent, int origin) {
			double discount = origin * (percent / 100.0);
			int partCost = origin - (int)discount;
			this.totalCost += partCost;
		}

		public boolean isOver() {
			return this.totalCost >= limitCost;
		}
	}

	public int[] solution(int[][] users, int[] emoticons) {
		int maxSignUpCnt = 0;
		int maxProfit = 0;

		decideDiscount(0, new int[emoticons.length]);

		for (int[] sale : sales) {
			List<Buyer> buyers = new ArrayList<>();
			for (int i = 0; i < users.length; i++) {
				Buyer buyer = new Buyer(i + 1, users[i][0], users[i][1], 0);
				for (int j = 0; j < sale.length; j++) {
					if (buyer.isPossible(sale[j])) {
						buyer.add(sale[j], emoticons[j]);
					}
				}
				buyers.add(buyer);
			}
			int emoticonPlusCnt = 0;
			int profit = 0;
			for (Buyer buyer : buyers) {
				if (buyer.isOver()) {
					emoticonPlusCnt++;
				} else {
					profit += buyer.totalCost;
				}
			}

			if (emoticonPlusCnt > maxSignUpCnt) {
				maxSignUpCnt = emoticonPlusCnt;
				maxProfit = profit;
			} else if (emoticonPlusCnt == maxSignUpCnt && profit >= maxProfit) {
				maxSignUpCnt = emoticonPlusCnt;
				maxProfit = profit;
			}
		}

		return new int[] {maxSignUpCnt, maxProfit};
	}

	public void decideDiscount(int cnt, int[] percents) {
		if (cnt == percents.length) {
			sales.add(percents.clone());
			return;
		}

		for (int i = 0; i < 4; i++) {
			percents[cnt] = discounts.get(i);
			decideDiscount(cnt + 1, percents);
		}
	}
}
