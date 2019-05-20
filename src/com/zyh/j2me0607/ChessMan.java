package com.zyh.j2me0607;

/////////////////////////////////////////
//棋子类
class ChessMan {
	private boolean m_chessMan;

	public ChessMan(boolean man) {
		m_chessMan = man;
	}

	public boolean toBool() {
		return m_chessMan;
	}
}

/////////////////////////////////////////
// 棋盘类
class ChessBoard {
	private ChessMan[][] m_board;

	/* 数组各值现在都为null */
	ChessBoard() {
		m_board = new ChessMan[1 + 8][1 + 8];
	}

	public void initChessBoard() {
		for (int x = 1; x <= 8; x++) {
			for (int y = 1; y <= 8; y++) {
				m_board[x][y] = null;
			}
		}

		m_board[4][4] = new ChessMan(AllDef.BLACK);
		m_board[5][5] = new ChessMan(AllDef.BLACK);
		m_board[4][5] = new ChessMan(AllDef.WHITE);
		m_board[5][4] = new ChessMan(AllDef.WHITE);
	}

	public ChessMan getChessMan(int x, int y) {
		return m_board[x][y];
	}

	public void changeBoard(int x, int y, boolean who) {
		m_board[x][y] = null;
		m_board[x][y] = new ChessMan(who);
	}
}

