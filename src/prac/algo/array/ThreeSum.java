package prac.algo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSum {

	/**
	 * Given an array with numbers. find the triplets where sum=0. O(N^2)
	 */

	private static void find(int[] input) {

		// Its must to have a negative number in array else not possible to counter the
		// sum as Zero.
		boolean findNegative = false;
		for (int i : input) {
			if (i < 0) {
				findNegative = true;
				break;
			}
		}

		if (!findNegative) {
			System.out.println("No -ve elements, hence cant get the Sum zero.");
			return;
		}

		Arrays.sort(input);

		Map<String, Integer> trips = new HashMap<>();
		for (int i = 0; i < input.length - 1; i++) {
			int []sum = new int[3];
			sum[0] = input[i];
			sum[1] = input[i + 1];

			for (int k = 0; k < input.length; k++) {
				if (k != i && k != (i + 1) && k != i - 1) {
					sum[2] = input[k];
					trips.put(sum[0]+","+sum[1]+","+sum[2],  Arrays.stream(sum).reduce(0, Integer::sum));
				}
			}
		}
		
		for (String key : trips.keySet()) {
			if(trips.get(key)==0)
				System.out.println("Triplet: "+key+", Sum: "+trips.get(key));
		}

	}

	public static void main(String[] args) {
		int[] input = { -1, 0, 1, 2, -1, -4 };
		find(input);
	}

}
