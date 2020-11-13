package eight_queens;

import java.util.Arrays;
import java.util.Random;

public class QueensProblem {
    static final int ROW_NUMBER = 8;
    static final int COL_NUMBER = 8;
    static final int QUEENS = 8;

    static char[][] desk =
            {{'*', '*', '*', '*', '*', '*', '*', '*'},
                    {'*', '*', '*', '*', '*', '*', '*', '*'},
                    {'*', '*', '*', '*', '*', '*', '*', '*'},
                    {'*', '*', '*', '*', '*', '*', '*', '*'},
                    {'*', '*', '*', '*', '*', '*', '*', '*'},
                    {'*', '*', '*', '*', '*', '*', '*', '*'},
                    {'*', '*', '*', '*', '*', '*', '*', '*'},
                    {'*', '*', '*', '*', '*', '*', '*', '*'}};

    boolean[][] possibleMoves = new boolean[8][8];

    public static void solve() {
        Random random = new Random();
        QueensProblem queensProblem = new QueensProblem();
        int queenCounter = 1;

        for (int i = 0; i < COL_NUMBER; i++) {
            Arrays.fill(queensProblem.possibleMoves[i], Boolean.TRUE);
        }

        int initRow = 0;
        int initCol = 0;

        int row = initRow;
        int col = initCol;

        removeMoves(queensProblem.possibleMoves, row, col);
        desk[row][col] = '!';


        while (queenCounter != QUEENS) {
            boolean flag = false;
            for (int i = 0; i < ROW_NUMBER; i++) {
                for (int j = 0; j < COL_NUMBER; j++) {
                    if (queensProblem.possibleMoves[i][j]) {
                        flag = true;
                        row = i;
                        col = j;
                        desk[row][col] = '!';
                        queenCounter++;
                        removeMoves(queensProblem.possibleMoves, row, col);

                    } else flag = false;
                }
            }
            if (!flag) {
                queenCounter = 0;
                fillMovesArray(queensProblem.possibleMoves);

                if (initCol+1 < COL_NUMBER) {
                    initCol++;
                } else {
                    initRow++;
                    initCol = 0;
                }

                if(initRow >= ROW_NUMBER) break;

                fillDeskArray(desk);

                row = initRow;
                col = initCol;
                removeMoves(queensProblem.possibleMoves, row, col);
                desk[row][col] = '!';
            }
        }

        for (int i = 0; i < COL_NUMBER; i++) {
            System.out.println(Arrays.toString(desk[i]));
        }
    }

    public static void removeMoves(boolean[][] possibleMoves, int row, int col) {
        for (int j = 0; j < COL_NUMBER && j >= 0; j++) {
            possibleMoves[row][j] = false;
        }
        for (int i = 0; i < ROW_NUMBER; i++) {
            possibleMoves[i][col] = false;
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            possibleMoves[i][j] = false;
        }

        for (int i = row, j = col; i < ROW_NUMBER && j < COL_NUMBER; i++, j++) {
            possibleMoves[i][j] = false;
        }

        for (int i = row, j = col; i < ROW_NUMBER && j >= 0; i++, j--) {
            possibleMoves[i][j] = false;
        }

        for (int i = row, j = col; i >= 0 && j < COL_NUMBER; i--, j++) {
            possibleMoves[i][j] = false;
        }
    }

    public static void fillMovesArray(boolean[][] arr) {
        for (int i = 0; i < ROW_NUMBER; i++) {
            Arrays.fill(arr[i], Boolean.TRUE);
        }
    }

    public static void fillDeskArray(char[][] arr) {
        for (int i = 0; i < ROW_NUMBER; i++) {
            Arrays.fill(arr[i], '*');
        }
    }

}
