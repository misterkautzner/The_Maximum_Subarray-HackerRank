import java.util.Scanner;


public class TheMaximumSubarray {

	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		//Number of test cases.
		int t = in.nextInt();
		
		long output[][] = new long[t][2];
		
		//Iterate on test case number.  Get all input, do all calculations, store prepared output.
		for(int i = 0; i < t; i++) {
			
			//Number of elements in the array.
			int n = in.nextInt();
			int inar[] = new int[n];
			
			for(int j = 0; j < n; j++) {
				inar[j] = in.nextInt();
			}
			
			//This stores the output in an array.  Rows are test cases.  First column contig, Second column noncontig.
			output[i][0] = contig(inar);
			output[i][1] = noncontig(inar);
		}
		in.close();
		
		
		for(int i = 0; i < t; i++) {
			System.out.println(output[i][0] + " " + output[i][1]);
		}
	}
	
	//Returns the maximum sum of all possible contiguous subarrays.
	public static long contig(int nar[]) {
		
		long sum = 0;
		long tempsum = 0;
		
		for(int i = 0; i < nar.length; i++) {
			
			tempsum += nar[i];
			
			if(tempsum < 0) {
				
				tempsum = 0;
			}
			
			else if (tempsum > sum) {
				sum = tempsum;
			}
			
		}
		
		if(sum == 0) {
			sum = nar[0];
			for(int i = 0; i < nar.length; i++) {
				if(nar[i] > sum) {
					sum = nar[i];
				}
			}
		}

		return sum;
	}
	
	//Returns the maximum sum of all possible noncontiguous subarrays.
	public static long noncontig(int nar[]) {
		
		long sum = 0;
		for(int i = 0; i < nar.length; i++) {
			if(nar[i] > 0) {
				sum += nar[i];
			}
		}
		
		//In case all elements are negative, output should be the greatest single elemet.
		if(sum == 0) {
			sum = nar[0];
			for(int i = 0; i < nar.length; i++) {
				if(nar[i] > sum) {
					sum = nar[i];
				}
			}
		}

		return sum;
	}
	
}


