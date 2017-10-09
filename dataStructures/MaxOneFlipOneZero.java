public class MaxOneFlipOneZero {

	public static void main(String[] args) {
		int[] ar = { 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1 };
		int len = 0;
		boolean contOne = false;
		int max = 0;
		int prevZeroIndex = -1;
		int prevPrevZeroIndex = -1;
		int zeroIndex=-1;
		int pos = -1;
		//Complexity O(n^2)
		for (int i = 0; i < ar.length; i++) {
			int leftCnt = 0, rightCnt = 0;
			if (ar[i] == 0) {
				for (int j = i - 1; j >= 0 && ar[j] != 0; j--) {
					leftCnt++;
				}
				for (int j = i + 1; j < ar.length && ar[j] != 0; j++) {
					rightCnt++;
				}
				if ((leftCnt + rightCnt + 1) > max) {
					max = leftCnt + rightCnt+1;
					pos = i;
				}
			}
		}
		
		System.out.println(max + "   Pos : " + pos);
		max=0;
		//Complexity O(n)
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == 0) {
				if (i - prevPrevZeroIndex > max) {
					max = i - prevPrevZeroIndex;
					zeroIndex = i;
				}
				prevPrevZeroIndex = prevZeroIndex;
				prevZeroIndex = i;
			}
		}
		if (ar.length - prevPrevZeroIndex > max) {
			max = ar.length - prevPrevZeroIndex;
			zeroIndex = prevZeroIndex;
		}
		max--;
		System.out.println(max + "   zeroIndex : " + zeroIndex);

	}

}
