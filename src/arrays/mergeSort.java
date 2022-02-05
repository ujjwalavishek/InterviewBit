package arrays;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class mergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(7,6,8,9,3,4,2,1,5));
		System.out.println(a);
		int n = a.size();
		sort(a, 0, n - 1);
		System.out.println(a);
	}
	
	private static void sort(ArrayList<Integer> a, int start, int end) {
		if (start == end) return;
		int mid = start + (end - start) / 2;
		sort(a, start, mid);
//		System.out.println(a+" "+start+" "+mid);
		sort(a, mid + 1, end);
//		System.out.println(a+" "+(mid+1)+" "+end);
		merge(a, start, mid, end);
	}
	
	private static void merge(ArrayList<Integer> a, int start, int mid, int end) {
		ArrayList<Integer> temp = new ArrayList<>();
		int i = start;
		int j = mid + 1;
		while ( i <= mid && j <= end) {
			if (a.get(i) <= a.get(j)) {
				temp.add(a.get(i));
				i++;
			}
			else {
				temp.add(a.get(j));
				j++;
			}
		}
		 
		while (i <= mid) {
			temp.add(a.get(i));
			i++;
		}
		while (j <= end) {
			temp.add(a.get(j));
			j++;
		}
		int k = 0;
		for (i = start; i <= end; i++) {
			a.set(i, temp.get(k)); k++;
		}
	}

}
