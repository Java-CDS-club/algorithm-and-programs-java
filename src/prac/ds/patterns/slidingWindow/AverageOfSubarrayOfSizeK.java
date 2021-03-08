package prac.ds.patterns.slidingWindow;

import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {

	static double[] average(int [] in, int K) {
		int winStart = 0, winEnd = 0;
		int winSum=0;
		double avg[] = new double[in.length-K+1];
		
		while(winEnd<in.length) {
			winSum+=in[winEnd];
			if(winEnd>=K-1) {
				avg[winStart]=winSum/K;
				winSum-=in[winStart++];
			}
			winEnd++;
		}
		
		return avg;
	}
	
	public static void main(String[] args) {
		int[] inputs = new int[] {1,2,3,4,5,6,7,8};
		int k=2;
		double [] op = average(inputs, k);
		Arrays.stream(op).forEach(s->System.out.println(s));
	}

}
