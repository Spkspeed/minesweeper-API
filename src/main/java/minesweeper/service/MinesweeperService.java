package minesweeper.service;

public class MinesweeperService {

    MineGameGrid mineGameGrid;

    public boolean startGame() {
        mineGameGrid = new MineGameGrid();
        return mineGameGrid == null ? false : true;
    }

    // Set a square of the grid to show it
    public int setSquareGrid(int col, int row) {
        return mineGameGrid.setSquareGrid(col, row);
    }

    // Set a square of the grid to flag it
    public boolean setFlagSquareGrid(int col, int row) {
        return mineGameGrid.setFlaggedSquareGrid(col, row);
    }

}
