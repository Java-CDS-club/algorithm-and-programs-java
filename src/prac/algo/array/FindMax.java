package prac.algo.array;

public class FindMax {

	private static void find(int []input) {
		if(input==null || input.length==0) {
			System.out.println("Invalid Input.");
			return;
		}
		
		int maxVal = Integer.MIN_VALUE;
		for(int i:input) {
			if(i>maxVal)
				maxVal=i;
		}
		System.out.println("MaxValue:> "+maxVal);
	}
	
	public static void main(String[] args) {
		int []input= {1,10,45,87,0,4};
		find(input);

	}

}
