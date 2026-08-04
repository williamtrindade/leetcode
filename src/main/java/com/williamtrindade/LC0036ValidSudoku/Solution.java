package com.williamtrindade.LC0036ValidSudoku;

class Solution {

    private int calculateQuad(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }

    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        boolean[][] lines = new boolean[n][n];
        boolean[][] cols = new boolean[n][n];
        boolean[][] quad = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int data = board[i][j];

                if (data == '.') {
                    continue;
                }

                data = data - '1';

                if (lines[i][data]) {
                    return false;
                }
                lines[i][data] = true;

                if (cols[j][data]) {
                    return false;
                }
                cols[j][data] = true;

                int square = this.calculateQuad(i, j);
                if (quad[square][data]) {
                    return false;
                }
                quad[square][data] = true;
            }
        }
        return true;
    }
}