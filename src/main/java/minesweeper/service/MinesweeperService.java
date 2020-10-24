package minesweeper.service;

import java.util.HashMap;

public class MinesweeperService {

    protected HashMap<String, MineGameGrid> gameInstances = new HashMap();

    public void createGame(String user) {
        MineGameGrid mineGameGrid = new MineGameGridBuilder()
                .setTotalMinesInGrid(20)
                .setTotalCols(20).setTotalRows(20).build();

        gameInstances.put(user, mineGameGrid);
    }

    public void createGame(String user, Integer rows, Integer cols, Integer totalMines) {
        MineGameGrid mineGameGrid = new MineGameGridBuilder()
                .setTotalMinesInGrid(totalMines)
                .setTotalCols(cols).setTotalRows(rows).build();

        gameInstances.put(user, mineGameGrid);
    }

    // Set a square of the grid to show it
    public SelectionResult setSquareGridRevealed(int col, int row, String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.REVEALED);
    }

    // Set a square of the grid with red mark
    public SelectionResult setRedMarkSquareGrid(int col, int row, String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.RED_MARK);
    }

    // Set a square of the grid with question mark
    public SelectionResult setQuestionMarkSquareGrid(int col, int row, String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.QUESTION_MARK);
    }

    // Verifies if game over was provoked by mined square selected
    public boolean isGameOver(String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.isGameOver();
    }

    // Verifies if game over was provoked by mined square selected
    public long getElapsedTime(String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.getElapsedTime();
    }

}
