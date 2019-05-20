package com.zyh.j2me0607;

/////////////////////////////////////////
//�����
public class Player {
	private boolean m_turn;
	private static ChessBoard m_bod;

	public int m_scroe;

	Player(boolean who) {
		m_turn = who;
		m_bod = new ChessBoard();
		m_bod.initChessBoard();

		m_scroe = 0;
	}

	private boolean eat(int x, int y, int xChange, int yChange) {
		// �������λ�����������С,����false
		if (x < 1 || x > 8 || y < 1 || y > 8) {
			return AllDef.ERROR;
		}
		if (m_bod.getChessMan(x, y) != null) {
			return AllDef.ERROR;
		}
		int xNext = x + xChange;
		int yNext = y + yChange;
		while (true) {
			// ��������ƶ�����,��һ���ӵ����������С,���������̷�Χ,����false
			// �����һ�����Ӻ�Ҫ�µ�������ͬһ����ɫ,����false
			if (xNext < 1 || xNext > 8 || yNext < 1 || yNext > 8 || m_bod.getChessMan(xNext, yNext) == null
					|| m_bod.getChessMan(x + xChange, y + yChange).toBool() == m_turn) {
				return AllDef.ERROR;
			}
			// ����
			if (m_bod.getChessMan(xNext, yNext).toBool() == m_turn) {
				do {
					x = x + xChange;
					y = y + yChange;
					m_bod.changeBoard(x, y, m_turn); // ����
				} while (x != xNext || y != yNext);
				break;
			}
			xNext = xNext + xChange;
			yNext = yNext + yChange;
		}
		return AllDef.OK;
	}

	private boolean judge(int x, int y, int xChange, int yChange) {
		int xNext = x + xChange;
		int yNext = y + yChange;
		if (m_bod.getChessMan(x, y) != null) {
			return AllDef.ERROR;
		}
		while (true) {
			if (xNext < 1 || xNext > 8 || yNext < 1 || yNext > 8 || m_bod.getChessMan(xNext, yNext) == null
					|| m_bod.getChessMan(x + xChange, y + yChange).toBool() == m_turn) {
				return AllDef.ERROR;
			}
			// �ж�
			if (m_bod.getChessMan(xNext, yNext).toBool() == m_turn) {
				break;
			}
			xNext = xNext + xChange;
			yNext = yNext + yChange;
		}
		return AllDef.OK;
	}

	public int result() {
		// ���ؽ�� WIN NOWIN NOSET
		int x, y;
		boolean result = false;

		for (x = 1; x <= 8 && false == result; x++) {
			for (y = 1; y <= 8 && false == result; y++) {
				result = judge(x, y, 0, -1) || result;
				result = judge(x, y, 0, 1) || result;
				result = judge(x, y, -1, -1) || result;
				result = judge(x, y, -1, 0) || result;
				result = judge(x, y, -1, 1) || result;
				result = judge(x, y, 1, -1) || result;
				result = judge(x, y, 1, 0) || result;
				result = judge(x, y, 1, 1) || result;
			}
		}
		if (false == result) {
			return AllDef.NOSET;
		}

		for (x = 1; x <= 8; x++) {
			for (y = 1; y <= 8; y++) {
				if (m_bod.getChessMan(x, y) != null && m_bod.getChessMan(x, y).toBool() != m_turn) {
					return AllDef.NOWIN;
				}
			}
		}
		return AllDef.WIN;
	}

	public int getNum() {
		int num = 0;
		for (int x = 1; x <= 8; x++) {
			for (int y = 1; y <= 8; y++) {
				if (m_bod.getChessMan(x, y) != null && m_bod.getChessMan(x, y).toBool() == m_turn) {
					num++;
				}
			}
		}
		return num;
	}

	public boolean setChess(int x, int y) {
		// �ж��ܲ����º���
		// ���ؽ�� OK ERROR
		boolean result = false;
		result = eat(x, y, 0, -1) || result;
		result = eat(x, y, 0, 1) || result;
		result = eat(x, y, -1, -1) || result;
		result = eat(x, y, -1, 0) || result;
		result = eat(x, y, -1, 1) || result;
		result = eat(x, y, 1, -1) || result;
		result = eat(x, y, 1, 0) || result;
		result = eat(x, y, 1, 1) || result;// �ֱ��ڰ˸������ϳ���

		if (AllDef.OK == result) {
			m_bod.changeBoard(x, y, m_turn);
		}
		return result;
	}

	public ChessMan getChess(int x, int y) {
		return m_bod.getChessMan(x, y);
	}

	public void init() {
		m_bod.initChessBoard();
	}

	public int[] aiXY() {
		int x, y;
		int xy[] = new int[2];
		boolean temp[][] = new boolean[1 + 8][1 + 8];
		for (x = 1; x <= 8; x++) {
			for (y = 1; y <= 8; y++) {
				temp[x][y] = false;
				boolean result = false;
				result = judge(x, y, 0, -1) || result;
				result = judge(x, y, 0, 1) || result;
				result = judge(x, y, -1, -1) || result;
				result = judge(x, y, -1, 0) || result;
				result = judge(x, y, -1, 1) || result;
				result = judge(x, y, 1, -1) || result;
				result = judge(x, y, 1, 0) || result;
				result = judge(x, y, 1, 1) || result;
				if (result == true) {
					temp[x][y] = true;
				}
			}
		}
		for (x = 1; x <= 8; x++) {
			for (y = 1; y <= 8; y++) {

				if (true == temp[x][y]) {
					if ((1 == x || 3 == x || 6 == x || 8 == x) && (1 == y || 3 == y || 6 == y || 8 == y) && x != y
							&& x != y + 3 && y != x + 3) {
						xy[0] = x;
						xy[1] = y;
						return xy;
					}
				}
			}
		}
		for (x = 1; x <= 8; x++) {
			for (y = 1; y <= 8; y++) {
				if ((2 == x || 7 == x || 2 == y || 7 == y) && true == temp[x][y]) {
					continue;
				}
				if (true == temp[x][y]) {
					xy[0] = x;
					xy[1] = y;
					return xy;
				}
			}
		}
		for (x = 1; x <= 8; x++) {
			for (y = 1; y <= 8; y++) {
				if ((2 == x && 7 == y) || (7 == x && 2 == y) || (2 == x && 2 == y) || (7 == x && 7 == y)
						|| (1 == x && 2 == y) || (2 == x && 1 == y) || (1 == x && 7 == y) || (7 == x && 1 == y)
						|| (8 == x && 2 == y) || (2 == x && 8 == y) || (8 == x && 7 == y) || (7 == x && 8 == y)) {
					continue;
				}
				if (true == temp[x][y]) {
					xy[0] = x;
					xy[1] = y;
					return xy;
				}
			}
		}
		for (x = 1; x <= 8; x++) {
			for (y = 1; y <= 8; y++) {
				if (true == temp[x][y]) {
					xy[0] = x;
					xy[1] = y;
					return xy;
				}
			}
		}
		xy[0] = xy[1] = -2;
		return xy;
	}
}