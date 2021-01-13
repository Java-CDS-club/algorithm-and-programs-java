package prac.algo.array;

import java.util.Arrays;

public class FindMaxMin {

	private static void maxMin(int[] in) {
		if (in == null) {
			System.out.println("Empty");
			return;
		}
		if (in.length <= 1) {
			System.out.println(Arrays.toString(in));
			return;
		}

		int[] minMaxArr = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
		int low = 0;
		int high = in.length - 1;

		while (low <= high) {
			if (in[low] < minMaxArr[0])
				minMaxArr[0] = in[low];
			if (in[low] > minMaxArr[1])
				minMaxArr[1] = in[low];

			if (in[high] > minMaxArr[1])
				minMaxArr[1] = in[high];
			if (in[high] < minMaxArr[0])
				minMaxArr[0] = in[high];

			low++;
			high--;
		}

		System.out.println(Arrays.toString(minMaxArr));
	}

	public static void main(String[] args) {
		maxMin(new int[] {});
		maxMin(null);
		maxMin(new int[] {1});
		maxMin(new int[] {6,1});
		maxMin(new int[] { 9, 3, 4, 29, 0, -1, -6000, 10000 });

	}

}
