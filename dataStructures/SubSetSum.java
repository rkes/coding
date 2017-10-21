import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubSetSum {

	public static void main(String[] args) {
		int[] ar = { 1, 2, 3, 4, 2 };
		int[][] dp = new int[ar.length][ar.length];
		for (int i = 0; i < ar.length; i++) {
			dp[i][i] = ar[i];
		}
		HashMap<Integer, ArrayList<ArrayList<Integer>>> res = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
		for (int i = 0; i < ar.length; i++) {
			for (int j = i + 1; j < ar.length; j++) {
				dp[i][j] = sum(i, j, ar);
				ArrayList<ArrayList<Integer>> subsets = res.get(dp[i][j]);
				if (subsets == null) {
					subsets = new ArrayList<ArrayList<Integer>>();
				}
				ArrayList<Integer> tempRes = new ArrayList<Integer>();
				for (int k = i; k <= j; k++) {
					tempRes.add(ar[k]);
				}
				subsets.add(tempRes);
				res.put(dp[i][j], subsets);
			}
		}
		ArrayList<ArrayList<Integer>> finalRes = new ArrayList<ArrayList<Integer>>();
		for (Map.Entry<Integer, ArrayList<ArrayList<Integer>>> op : res.entrySet()) {
			ArrayList<ArrayList<Integer>> subsetOp = op.getValue();
			if (subsetOp.size() > 1) {
				finalRes.addAll(subsetOp);
			}
		}
		for (int i = 0; i < finalRes.size(); i++) {
			System.out.println(finalRes.get(i));
		}

	}

	private static int sum(int a, int b, int[] ar) {
		int sm = 0;
		for (int i = a; i <= b; i++) {
			sm += ar[i];
		}
		return sm;
	}

}
