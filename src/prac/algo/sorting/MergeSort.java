package prac.algo.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[] {1,20,-1,5};
		
		sort(arr,0, arr.length-1);

	}

	private static void sort(int[] arr, int left, int right) {
		if(left>=right)
			return;
		
		int mid = (right-left)/2;
		System.out.println(Arrays.toString(arr));
		sort(arr, left, mid);
		sort(arr, mid+1, right-1);
		
		
	}

}
