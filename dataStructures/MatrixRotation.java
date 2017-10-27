public class MatrixRotation {
	/* Only for Square Matrix*/
	public static void main(String[] args) {
		int n = 5;
		int[][] mat = 
				{ 
					{ 1, 2, 3, 4,5}, 
					{ 6, 7, 8,9,10 }, 
					{ 11, 12,13,14,15 }, 
					{ 16,17,18,19,20 },
					{ 21,22,23,24,25 }
				};
				
		rotateBy90(mat, n);
	}

	public static void rotateBy90(int[][] mat, int n) {
		int row = 0, col = n-1,tempRow=0,tempCol=n-1,temp=mat[0][n-1],rowCol=0,temp2,offset=0;
		int direction=0;
		
		System.out.println(" Original Matrix ....... ");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.printf("%d    ",mat[i][j]);
			}
			System.out.println();
		}

		
		for(int i=0;i<n*n;i++){
			switch(direction){
				case 0:
					temp=mat[tempRow+row][tempCol];
					mat[tempRow+row][tempCol]=mat[tempRow][tempRow+row];
					direction=1;
				break;
				case 1:
					temp2=temp;
					temp=mat[tempCol][tempCol-row];
					mat[tempCol][tempCol-row]=temp2;
					direction=2;
				break;
				case 2:
					temp2=temp;
					temp=mat[tempCol-row][tempRow];
					mat[tempCol-row][tempRow]=temp2;
					direction=3;
				break;
				case 3:
					mat[tempRow][tempRow+row]=temp;
					direction=0;
					row++;
				break;				
			}
			if(row>0&&row%(n-1)==0){
				tempRow++;
				tempCol--;
				row=0;
			}
		}
		System.out.println(" Rotated Matrix ....... ");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.printf("%d    ",mat[i][j]);
			}
			System.out.println();
		}
	}
}
