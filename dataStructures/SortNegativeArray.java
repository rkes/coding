package coding.dataStructures;
public class SortNegativeArray {

	public static void main(String[] args) {
		int[] ar = { -8, -5, -3, -1, 3, 6, 9 };
		int max = 0;
		for (int i = 0; i < ar.length; i++) {
			if (ar[i]*ar[i] > max*max) {
				max = ar[i];
			}
		
		}
		int n = max;
		int[] res = new int[n + 1];
		for (int i = 0; i < ar.length; i++) {
			int index = ar[i];
			if (index < 0) {
				index = -index;
			}
			++res[index];

		}
		int[] c = new int[ar.length];
		for (int i = 1; i <= n; i++)
			res[i] = res[i] + res[i - 1];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] >= 0) {
				c[res[ar[i]] - 1] = ar[i];
				res[ar[i]]--;
			} else {
				c[res[-ar[i]] - 1] = ar[i];
				res[-ar[i]]--;
			}
		}
		for (int i = 0; i < c.length; i++)
			System.out.printf("%d  ", c[i]);

	}

}
