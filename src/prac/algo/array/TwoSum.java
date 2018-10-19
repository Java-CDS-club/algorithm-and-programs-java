package prac.algo.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {

	/*
	 * Problem: Given array, find the pair of number which sum will equal to the target value.
	 * Example: input: [1, 2, 4, 8, 10], target:6, O/P:{2, 4}
	 * 
	 */
	
	private static void findPair(int[] input, int target) {
		Set<Integer> inputSet = new HashSet<>();
		for(int i:input) {
			inputSet.add(i);
		}
		
		int count = inputSet.size();
		
		for(int i:inputSet) {
			int diff = target-i;
			if(inputSet.contains(diff)) {
				System.out.println("Pair is: {"+i+", "+diff+"}");
				break;
			}
			count--;
		}
		
		if(count==0) {
		 System.out.println("No pair found.");
		}
	}
	
	
	public static void main(String[] args) {
		int input[]= {1, 2, 3, 5, 10, 12};
		int target = 14;
		
		findPair(input, target);

	}

}
