package minesweeper.service;

public class MineGameGrid {

    private final Integer GRID_ROWS = 20;
    private final Integer GRID_COLS = 20;

    private MineSquare[][] gameGrid = new MineSquare[GRID_ROWS][GRID_COLS];

    private int totalMinesInGrid = 10;

    public MineGameGrid() {
        for (int row = 1; row <= GRID_ROWS; row++) {
            for (int col = 1; col <= GRID_COLS; col++) {
                gameGrid[row][col] = new MineSquare();
            }
        }
    }

}