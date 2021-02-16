package prac.algo.array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayReverseFromNthPosition {

	/*
	 * Algo to Reverse an Array from given nth positions.
	 * 
	 */

	private static void rotate(char[] input, int position) {
		System.out.println("Input:>	" + Arrays.toString(input));
		if ((input != null && input.length == 0) || input.length < position) {
			System.out.println("No Input or Invalid Input.");
			return;
		}
		int length = input.length;
		for (int i = 0; i < (length - position) / 2; i++) {
			char temp = input[i + position];
			input[i + position] = input[length - i - 1];
			input[length - i - 1] = temp;
		}
		
		System.out.println("Output:>" +  Arrays.toString(input));
	}

	public static void main(String[] args) {
		String input = "1234567";
		rotate(input.toCharArray(), 1);
		
		Map<String, String> map = new LinkedHashMap<>();
		map.put("1", "Hi");
	}

}
