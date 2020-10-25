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

    public SelectionResult setSquareGridRevealed(int col, int row, String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.REVEALED);
    }

    public SelectionResult setRedMarkSquareGrid(int col, int row, String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.RED_MARK);
    }

    public SelectionResult setQuestionMarkSquareGrid(int col, int row, String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.QUESTION_MARK);
    }

    public boolean isGameOver(String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.isGameOver();
    }

    public long getElapsedTime(String user) {
        MineGameGrid mineGameGrid = gameInstances.get(user);
        return mineGameGrid.getElapsedTime();
    }

}
