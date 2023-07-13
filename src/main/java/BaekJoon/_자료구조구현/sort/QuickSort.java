package BaekJoon._자료구조구현.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		CustomSortable sortable = new QuickSortImpl();

		int[] arr = {3, 1, 5, 6, 20, 10, 7, 11, 15, 9};
		sortable.sort(arr);

		System.out.println(Arrays.toString(arr));
	}
}
