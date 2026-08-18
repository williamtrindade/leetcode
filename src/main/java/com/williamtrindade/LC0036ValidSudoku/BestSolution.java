package com.williamtrindade.LC0036ValidSudoku;

/**
 * A solution using a 3D array to store the boxes.
 * Facilitating the calculation of the box index.
 */
class BestSolution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] lines = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][][] boxes = new boolean[3][3][9];

        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int number = board[i][j] - '1';
                if (this.alreadyOnBoard(lines, columns, boxes, i, j, number)) {
                    return false;
                }
                lines[i][number] = true;
                columns[j][number] = true;
                boxes[i/3][j/3][number] = true;
            }
        }

        return true;
    }

    public boolean alreadyOnBoard(boolean[][] lines, boolean[][] columns, boolean[][][] boxes, int i, int j, int number) {
        return lines[i][number] || columns[j][number] || boxes[i/3][j/3][number];
    }
}