package minesweeper.service;

public class MineGameGrid {

    private final Integer GRID_ROWS = 20;
    private final Integer GRID_COLS = 20;

    private MineSquare[][] gameGrid = new MineSquare[GRID_ROWS][GRID_COLS];

    private int totalMinesInGrid = 10;

    public MineGameGrid() {
        for (int row = 0; row < GRID_ROWS; row++) {
            for (int col = 0; col < GRID_COLS; col++) {
                gameGrid[row][col] = new MineSquare();
            }
        }
    }

    public boolean setSquareGrid(int row, int col) {
        if (verifyOutOfGrid(row, col)) {
            return false;
        } else {
            gameGrid[row][col].setSquareVisible(true);
            return true;
        }
    }

    public boolean setFlaggedSquareGrid(int row, int col) {
        if (verifyOutOfGrid(row, col)) {
            return false;
        } else {
            gameGrid[row][col].setSquareVisible(true);
            return true;
        }
    }

    private boolean verifyOutOfGrid(int row, int col) {
        if (row > GRID_ROWS || row < 0 || col > GRID_COLS || col < 0) {
            return true;
        }
        return false;
    }

}