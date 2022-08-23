import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	
	static Scanner fs;
	
	public static void main(String[] args) {
		fs = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = 6;
			int[][] a = new int[n][];
			for (int i = 0; i < n; i++) {
				a[i] = readArray(n);
			}
			int max = Integer.MIN_VALUE;
			for (int i = 1; i < n - 1; i++) {
				for (int j = 1; j < n - 1; j++) {
					int sum = a[i][j];
					for (int k = -1; k <= 1; k++) {
						sum += a[i-1][j+k];
					}
					for (int k = -1; k <= 1; k++) {
						sum += a[i+1][j+k];
					}
					max = Math.max(max, sum);
				}
			}
			out.println(max);
		}
		fs.close();
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static int[] readArray(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = fs.nextInt();
		}
		return a;
	}
}
