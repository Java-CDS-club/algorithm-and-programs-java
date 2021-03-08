package prac.ds.patterns.slidingWindow;

public class MaximumSumOfContiArray {
	
	static int maxSumArray(int[] in, int winSize) {
		int winStart = 0, winSum=0, MAX_SUM=Integer.MIN_VALUE;
		
		for(int winEnd=0;winEnd<in.length;winEnd++ ) {
			winSum+=in[winEnd];
			if(winEnd>=winSize-1) {
				MAX_SUM = Math.max(winSum, MAX_SUM);
				winSum-=in[winStart++];
			}
		}
		
		return MAX_SUM;
	}

	public static void main(String[] args) {
		int[] inputs = new int[] {5,6,8, 20,1};
		int k = 2;
		System.out.println(maxSumArray(inputs, k));

	}

}
