package minesweeper.service;

public class MinesweeperService {

    MineGameGrid mineGameGrid;

    public boolean createGame() {
        mineGameGrid = new MineGameGrid();
        return mineGameGrid == null ? false : true;
    }

    // Set a square of the grid to show it
    public SelectionResult setSquareGridRevealed(int col, int row) {
        return mineGameGrid.setSquareGrid(col, row, SquareState.REVEALED);
    }

    // Set a square of the grid with red mark
    public SelectionResult setRedMarkSquareGrid(int col, int row) {
        return mineGameGrid.setSquareGrid(col, row, SquareState.RED_MARK);
    }

    // Set a square of the grid with question mark
    public SelectionResult setQuestionMarkSquareGrid(int col, int row) {
        return mineGameGrid.setSquareGrid(col, row, SquareState.QUESTION_MARK);
    }

    // Verifies if game over was provoked by mined square selected
    public boolean isGameOver() {
        return mineGameGrid.isGameOver();
    }
}
