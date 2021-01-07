package minesweeper.service;

import minesweeper.exception.MinesweeperException;
import minesweeper.exception.RestResponseEntityExceptionHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MinesweeperService {

    @Autowired
    MinesweeperPersistService minesweeperPersistService;

    Logger log = Logger.getLogger(MinesweeperService.class);


    protected HashMap<String, MineGameGrid> gameInstances = new HashMap();

    public void createGame(String user) throws MinesweeperException {
        MineGameGrid mineGameGrid = new MineGameGridBuilder()
                .setTotalMinesInGrid(200)
                .setTotalCols(20).setTotalRows(20).build();

        gameInstances.put(user, mineGameGrid);
    }

    public void createGame(String user, Integer rows, Integer cols, Integer totalMines) throws MinesweeperException {
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

    public SelectionResult setNotRevealedMarkSquareGrid(int col, int row, String user) throws MinesweeperException {
        MineGameGrid mineGameGrid = getMineGameGridByUser(user);
        return mineGameGrid.setSquareGrid(col, row, SquareState.NOT_REVEALED);
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
        log.debug("El problema es que devuelve: " + minesweeperPersistService);
        log.debug("El usuario es: " + user);
        log.debug("Instancias del juego del usuario: " + gameInstances.get(user));
        minesweeperPersistService.saveGame(user, gameInstances.get(user));
    }

    public void restoreGame(String user) throws MinesweeperException {
        gameInstances.put(user, minesweeperPersistService.loadGame(user));
    }
}
