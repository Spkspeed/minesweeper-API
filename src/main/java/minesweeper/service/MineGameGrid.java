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

        while(minesSet < totalMinesInGrid) {
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
            if(selectionType == SquareState.REVEALED) {
                gameGrid[row][col].setSquareState(selectionType);
                if (gameGrid[row][col].getSquareMined()) {
                    setGameOver(true);
                }
            } else {
                gameGrid[row][col].setSquareState(selectionType);
            }

            return SelectionResult.SELECTION_OK;
        }
    }

    private boolean verifyPositionOutOfGrid(int row, int col) {
        if (row > GRID_ROWS || row < 0 || col > GRID_COLS || col < 0) {
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