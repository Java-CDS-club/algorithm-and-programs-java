package prac.algo.array;

import java.util.Arrays;

public class ReverseString {
	//ABC--> CBA, 1234--> 4321
	//Logic is two pointer to reverse it in n/2 time complexity. that is n only
	
	private static String reverse(String in) {
		if(in==null)
			return "";
		if(in.length()==1)
			return in;
		
		char[] chArr = in.toCharArray();
		int low= 0;
		int high= chArr.length-1;
		while(low<high) {
			char ch = chArr[low];
			chArr[low] = chArr[high];
			chArr[high] = ch;
			low++;
			high--;
		}
		
		return Arrays.toString(chArr);
	}
	public static void main(String[] args) {
		System.out.println(reverse(null));
	}

}
