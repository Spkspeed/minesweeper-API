package minesweeper.service;

import minesweeper.exception.MinesweeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MinesweeperService {

    @Autowired
    MinesweeperPersistService minesweeperPersistService;

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

    public SelectionResult setSquareGridRevealed(int col, int row, String user) throws MinesweeperException {
        MineGameGrid mineGameGrid = getMineGameGridByUser(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.REVEALED);
    }

    public SelectionResult setRedMarkSquareGrid(int col, int row, String user) throws MinesweeperException {
        MineGameGrid mineGameGrid = getMineGameGridByUser(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.RED_MARK);
    }

    public SelectionResult setQuestionMarkSquareGrid(int col, int row, String user) throws MinesweeperException {
        MineGameGrid mineGameGrid = getMineGameGridByUser(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.QUESTION_MARK);
    }

    public boolean isGameOver(String user) throws MinesweeperException {
        MineGameGrid mineGameGrid = getMineGameGridByUser(user);
        return mineGameGrid.isGameOver();
    }

    public long getElapsedTime(String user) throws MinesweeperException {
        MineGameGrid mineGameGrid = getMineGameGridByUser(user);
        return mineGameGrid.getElapsedTime();
    }

    public MineGameGrid getMineGameGridByUser(String user) throws MinesweeperException {
        if(gameInstances.get(user) == null) {
            throw new  MinesweeperException("User not found in game list");
        }

        return gameInstances.get(user);
    }

    public void saveGame(String user) throws MinesweeperException {
        minesweeperPersistService.saveGame(user, gameInstances.get(user));
    }

    public void restoreGame(String user) throws MinesweeperException {
        gameInstances.put(user, minesweeperPersistService.loadGame(user));
    }
}
