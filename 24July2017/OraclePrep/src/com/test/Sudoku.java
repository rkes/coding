public class Sudoku {
	static int [][]grid = {
		    {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
	public static void main(String []args){
				
				if (solveSudoku(9,9))
				    printGrid(grid);
				else
				   System.out.println("No solution exists");
				printGrid(grid);

	}

	private static void printGrid(int[][] grid) {
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++)
				System.out.printf("%d \t",grid[i][j]);
			System.out.println();
		}
		
	}

	public static boolean solveSudoku( int m, int n) {
		int row, col = 0;
		boolean flag = true;
		for (row = 0; row < m; row++) {
			for (col = 0; col < n; col++) {
				if (grid[row][col] == 0) {
					flag = false;
					break;
				}
			}
			if(!flag)
				break;
		}
		if (flag)
			return true;
		for (int i = 1; i <= 9; i++) {
			if (isSafe(grid, row, col, i, n)) {
				grid[row][col] = i;
				if (solveSudoku( m, n))
					return true;
				grid[row][col] = 0;

			}
		}

		return false;

	}

	private static boolean isSafe(int[][] grid, int row, int col, int num, int n) {
		return     !UsedInRow(grid, row, col, num, n) 
				&& !UsedInCol(grid, row, col, num, n)
				&& !UsedInBox(grid, row - row % 3, col - col % 3, num, n);
	}

	private static boolean UsedInBox(int[][] grid, int boxStartRow, int boxStartColumn, int num, int n) {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (grid[i + boxStartRow][j + boxStartColumn] == num)
					return true;
		return false;
	}

	private static boolean UsedInCol(int[][] grid, int row, int col, int num, int n) {
		for (int i = 0; i < n; i++)
			if (grid[i][col] == num)
				return true;
		return false;
	}

	private static boolean UsedInRow(int[][] grid, int row, int col, int num, int n) {
		for (int i = 0; i < n; i++)
			if (grid[row][i] == num)
				return true;
		return false;
	}

}
