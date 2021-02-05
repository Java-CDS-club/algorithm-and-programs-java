package prac.algo.array;

public class GameOfLife {

	public static void gameOfLife(int[][] board) {

		int[][] newArr = new int[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				newArr[i][j] = board[i][j];
			}
		}

		int rows = newArr.length - 1;
		int columns = newArr[0].length - 1;

		for (int i = 0; i <= rows; i++) {
			for (int j = 0; j <= columns; j++) {
				int current = board[i][j];

				int lives = 0;

				// right
				if (j < columns && board[i][j + 1] == 1)
					lives += 1;
				// left
				if (j > 0 && board[i][j - 1] == 1)
					lives += 1;
				// up
				if (i > 0 && board[i - 1][j] == 1)
					lives += 1;
				// down
				if (i < rows && board[i + 1][j] == 1)
					lives += 1;

				// rightUpCorner
				if (j < columns && i > 0 && board[i - 1][j + 1] == 1)
					lives += 1;

				// leftUpCorner
				if (j > 0 && i > 0 && board[i - 1][j - 1] == 1)
					lives += 1;

				// rightBottomCorner
				if (i < rows && j < columns && board[i + 1][j + 1] == 1)
					lives += 1;

				// leftBottomCorner
				if (i < rows && j > 0 && board[i + 1][j - 1] == 1)
					lives += 1;

				if (lives == 3 && current == 0)
					newArr[i][j] = 1;
				else if ((lives == 2 || lives == 3) && current == 1)
					newArr[i][j] = 1;
				else if (lives > 3 || lives < 2 && current == 1)
					newArr[i][j] = 0;

				System.out.println("Pos:[" + i + "," + j + "], lives: " + lives + ", current: " + current + ", new: "
						+ newArr[i][j]);
			}
		}

		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[0].length; j++) {
				board[i][j] = newArr[i][j];
			}
		}
	}

	public static void main(String[] args) {
		int in[][] = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(in);

	}

}
