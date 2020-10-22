package minesweeper.service;

public class MinesweeperService {

    MineGameGrid mineGameGrid;

    public boolean startGame() {
        mineGameGrid = new MineGameGrid();
        return mineGameGrid == null ? false : true;
    }

    // Set a square of the grid to show it
    public void setSquareGrid(int col, int row) {
    }

    // Set a square of the grid to flag it
    public void setFlagSquareGrid(int col, int row) {
    }

}
