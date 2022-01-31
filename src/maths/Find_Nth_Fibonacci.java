package maths;

import java.util.*;

/*
 * Problem link:- https://www.interviewbit.com/problems/find-nth-fibonacci/
 */

public class Find_Nth_Fibonacci {
	
	public static final int MOD = (int)  1e9+7;
	
	public static ArrayList<ArrayList<Long>> matrix = new ArrayList<ArrayList<Long>>();
	public static ArrayList<ArrayList<ArrayList<Long>>> dp = new ArrayList<ArrayList<ArrayList<Long>>>();
	
	public static ArrayList<ArrayList<Long>> multiply(ArrayList<ArrayList<Long>> A, ArrayList<ArrayList<Long>> B){
		ArrayList<ArrayList<Long>> res = new ArrayList<ArrayList<Long>>();
		for (int i = 0; i < A.size(); i++) {
			ArrayList<Long> temp = new ArrayList<Long>();
			for (int j = 0; j < B.get(0).size(); j++) {
				temp.add(0L);
			}
			res.add(temp);
		}
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < B.get(0).size(); j++) {
				long sum = 0;
				for (int k = 0; k < B.size(); k++) {
					sum = (sum % MOD + (((A.get(i).get(k) % MOD)  * (B.get(k).get(j) % MOD) )% MOD) % MOD) % MOD;
				}
				res.get(i).set(j, sum);
			}
		}
		
		return res;
	}
	
	
	public static Long solve (int n) {
		if (n == 1) return 1l;
		char[] bits = new char[32];
		n--;
		for (int i = 0; i <= 31; i++) {
			if (n % 2 == 0) bits[i] = '0';
			else bits[i] = '1';
			n = n >> 1;
		}
		System.out.println(bits);
		ArrayList<Long> row1 = new ArrayList<Long>();
		row1.add(1l); row1.add(1l); matrix.add(row1);
		ArrayList<Long> row2 = new ArrayList<Long>();
		row2.add(1l); row2.add(0l); matrix.add(row2);
		
		for (int i = 0; i < 32; i++) {
			dp.add(matrix);
		}
		for (int i = 1; i < 32; i++) {
			dp.set(i, multiply(dp.get(i - 1), dp.get(i - 1) ) );
		}
		System.out.println(dp);
		
		
		ArrayList<ArrayList<Long>> tillNow = new ArrayList<ArrayList<Long>>(matrix);
		boolean flag = false;
		for (int i = 0; i <= 31; i++) {
			if (bits[i] == '1') {
				 if ( !flag ) {
					 tillNow = dp.get(i);
					 flag = true;
				 }
				 else {
					 tillNow = multiply(tillNow, dp.get(i));
				 }
			}
		}
		return tillNow.get(0).get(0);	
	}
	
	

//	private static ArrayList<ArrayList<Integer>> mul(int pow) {
//		// TODO Auto-generated method stub
////		System.out.println("matrix2 "+matrix2+" "+pow);
//		
//		
////		if (pow == 1) return matrix2;
////		if (pow == 2) {
////			return multiply(matrix2, matrix2);
////		}
//		return multiply(mul(matrix2, pow/2),mul(matrix2, pow / 2));
//	}

	public static long power(int n) {
		long[] dp = new long[64];
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i <= 63; i++) {
			if (i % 2 == 0)
				dp[i] = ((dp[i/2] % MOD) * (dp[i/2] % MOD) ) % MOD;
			else
				dp[i] = ((dp[i/2] % MOD) * 2 * (dp[i/2] % MOD) ) % MOD ;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solve(n));
//		System.out.println(power(n));
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		arr.add(5);
//		System.out.println(arr.size());
//		arr.ensureCapacity(6);
//		System.out.println(arr);
		
		
	}
}
