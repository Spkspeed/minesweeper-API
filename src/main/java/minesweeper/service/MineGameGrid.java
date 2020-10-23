package minesweeper.service;

import java.util.Random;

public class MineGameGrid {

    private final Integer GRID_ROWS = 20;
    private final Integer GRID_COLS = 20;

    private boolean gameOver;

    private MineSquare[][] gameGrid = new MineSquare[GRID_ROWS][GRID_COLS];

    private int totalMinesInGrid = 10;

    public MineGameGrid() {
        gameOver = false;

        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
                gameGrid[row][col] = new MineSquare();
            }
        }

        setMines(GRID_ROWS, GRID_COLS);
    }

    private void setMines(int rows, int cols) {
        Random rand = new Random();

        int posX;
        int posY;
        int minesSet = 0;

        while (minesSet < totalMinesInGrid) {
            posX = rand.nextInt(rows);
            posY = rand.nextInt(cols);
            if (!gameGrid[posX][posY].getSquareMined()) {
                gameGrid[posX][posY].setSquareMined(true);
                minesSet++;
            }
        }
    }

    public SelectionResult setSquareGrid(int row, int col, SquareState selectionType) {
        if (verifyPositionOutOfGrid(row, col)) {
            return SelectionResult.SELECTION_ERROR;
        } else {
            if (selectionType == SquareState.REVEALED) {
                gameGrid[row][col].setSquareState(selectionType);
                if (gameGrid[row][col].getSquareMined()) {
                    setGameOver(true);
                } else {
                    if(checkAdjacentSquaresHaveMines(row, col)) {
                        showAdjacentSquares(row, col);
                    }
                }
            } else {
                gameGrid[row][col].setSquareState(selectionType);
            }

            return SelectionResult.SELECTION_OK;
        }
    }

    private boolean checkAdjacentSquaresHaveMines(int row, int col) {
        boolean isMined = false;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int posX = row;
                int posY = col;
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    posX += j;
                    posY += i;
                    if(!verifyPositionOutOfGrid(posX, posY)) {
                        isMined = gameGrid[posX][posY].getSquareMined();
                    }
                }
            }
        }
        return isMined;
    }

    private void showAdjacentSquares(int row, int col) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int posX = row;
                int posY = col;
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    posX += j;
                    posY += i;
                    if(!verifyPositionOutOfGrid(posX, posY)) {
                        gameGrid[posX][posY].setSquareState(SquareState.REVEALED);
                    }
                }
            }
        }
    }

    private boolean verifyPositionOutOfGrid(int row, int col) {
        if (row > (GRID_ROWS - 1) || row < 0 || col > (GRID_COLS - 1) || col < 0) {
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}