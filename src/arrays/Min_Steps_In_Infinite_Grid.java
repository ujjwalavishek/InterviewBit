package arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class Min_Steps_In_Infinite_Grid {
	
	public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
		int n = A.size();
		int ans = 0;
		int x1 = A.get(0);
		int y1 = B.get(0);
		for (int i = 1; i < n; i++) {
			int x2 = A.get(i);
			int y2 = B.get(i);
			if (x2 - x1 >=0) {
				if (y2 - y1 >= 0) {
					if (x2 - x1 <= y2 - y1) {
						ans += (x2 - x1);
						if (y2 > y1 + (x2 - x1)) ans += y2 - (y1 + (x2-x1));
					}
					else {
						ans += (y2 - y1);
						if (x2 > x1 + (y2 - y1)) ans += x2 - (x1 + (y2 - y1));
					}
				}
				else {
					if (x2 - x1 <= y1 - y2) {
						ans += (x2 - x1);
						if (y2 < y1 - (x2 - x1) ) ans += (y1 - (x2 - x1) - y2);
					}
					else {
						ans += (y1 - y2);
						if (x2 > x1 + (y1 - y2)) ans += x2 - (x1 + (y1 - y2));
					}
				}
			}
			else {
				if (y2 - y1 >= 0) {
					if (y2 - y1 <= x1 - x2) {
						ans += y2 - y1;
						if (x2 < x1 - (y2 - y1)) ans += (x1 - (y2 - y1)) - x2;
					}
					else {
						ans += x1 - x2;
						if (y2 > y1 + (x1 - x2)) ans += y2 - (y1 + (x1 - x2));
					}
					
				}
				else {
					if (x1 - x2 <= y1 - y2) {
						ans += x1 - x2;
						if (y2 < y1 - (x1 - x2)) ans += y1 - (x1 - x2) - y2;
					}
					else {
						ans += y1 - y2;
						if (x2 < x1 - (y1 - y2)) ans += x1 - (y1 - y2) - x2;
					}
				}
			}
			x1 = x2;
			y1 = y2;
			
		}
		return ans;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) A.add(sc.nextInt());
		ArrayList<Integer> B = new ArrayList<>();
		for (int i = 0; i < n; i++) B.add(sc.nextInt());
		System.out.println(coverPoints(A, B));
		sc.close();

	}

}
