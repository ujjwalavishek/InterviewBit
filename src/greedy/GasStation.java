package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Problem Link:- "https://www.interviewbit.com/problems/gas-station/"
 */

public class GasStation {
	
	private static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
		int ans = -1;
		int n = A.size();
		for (int i = 0; i < n; i++) {
			int currGas = A.get(i);
			if (currGas >= B.get(i)) {
                currGas -= B.get(i);
				int j = (i + 1) % n;
				while (j != i) {
					currGas += A.get(j);
					if (currGas < B.get(j)) break;
					currGas -= B.get(j);
					j = (j + 1) % n;
				}
				if (currGas >= 0 && j == i) return i;
			}	
		}
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) A.add(sc.nextInt());
		List<Integer> B = new ArrayList<>();
		for (int i = 0; i < n; i++) B.add(sc.nextInt());
		int index = canCompleteCircuit(A, B);
		System.out.println(index);	
	}

}
