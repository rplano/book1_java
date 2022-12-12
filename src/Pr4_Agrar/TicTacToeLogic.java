public class TicTacToeLogic {
	private static int[][] board = new int[3][3];

	public static boolean isMoveAllowed(int player, int i, int j) {
		if (board[i][j] == 0) {
			board[i][j] = player;
			return true;
		}
		return false;
	}

	public static boolean isGameOver() {
		if (checkDiagonals())
			return true;
		if (checkHorizontals())
			return true;
		if (checkVerticals())
			return true;
		return false;
	}

	private static boolean checkVerticals() {
		for (int i = 0; i < 3; i++) {
			if ((board[i][0] == 1) && (board[i][1] == 1) && (board[i][2] == 1)) {
				return true;
			}
		}
		for (int i = 0; i < 3; i++) {
			if ((board[i][0] == 2) && (board[i][1] == 2) && (board[i][2] == 2)) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkHorizontals() {
		for (int i = 0; i < 3; i++) {
			if ((board[0][i] == 1) && (board[1][i] == 1) && (board[2][i] == 1)) {
				return true;
			}
		}
		for (int i = 0; i < 3; i++) {
			if ((board[0][i] == 2) && (board[1][i] == 2) && (board[2][i] == 2)) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkDiagonals() {
		if ((board[0][0] == 1) && (board[1][1] == 1) && (board[2][2] == 1)) {
			return true;
		}
		if ((board[0][0] == 2) && (board[1][1] == 2) && (board[2][2] == 2)) {
			return true;
		}
		if ((board[2][0] == 1) && (board[1][1] == 1) && (board[0][2] == 1)) {
			return true;
		}
		if ((board[2][0] == 2) && (board[1][1] == 2) && (board[0][2] == 2)) {
			return true;
		}
		return false;
	}
}
