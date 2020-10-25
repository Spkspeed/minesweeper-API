package minesweeper.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minesweeper.exception.MinesweeperException;
import minesweeper.service.MineGameGrid;
import minesweeper.service.MineSquare;
import minesweeper.service.MinesweeperService;
import minesweeper.service.SelectionResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Minesweeper API basic services")
public class MinesweeperController {

    MinesweeperService minesweeperService = new MinesweeperService();

    @PostMapping(path = "/create-custom-game")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Creates a new customized game instance by setting rows, cols and number of mines")
    public String createGame(String user, Integer rows, Integer cols, Integer totalMines) throws MinesweeperException {
        minesweeperService.createGame(user, rows, cols, totalMines);
        return "Game created successfully";
    }

    @PostMapping(path = "/create-game")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Creates a new Game instance using default values of rows = 20, cols = 20, totalMines = 10")
    public String createGame(String user) throws MinesweeperException {
        minesweeperService.createGame(user);
        return "Game created successfully";
    }

    @GetMapping(path = "/square-selection-reveal")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Selects an square in the grid for reveal it, will throw Game Over if mined square is revealed")
    public SelectionResult setSquareGridRevealed(int col, int row, String user) throws MinesweeperException {
        return minesweeperService.setSquareGridRevealed(col, row, user);
    }

    @GetMapping(path = "/square-selection-red-mark")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Selects an square in the grid with red marking will not set GameOver")
    public SelectionResult setRedMarkSquareGrid(int col, int row, String user) throws MinesweeperException {
        return minesweeperService.setRedMarkSquareGrid(col, row, user);
    }

    @GetMapping(path = "/square-selection-question-mark")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Selects an square in the grid with question marking will not set GameOver")
    public SelectionResult setQuestionMarkSquareGrid(int col, int row, String user) throws MinesweeperException {
        return minesweeperService.setQuestionMarkSquareGrid(col, row, user);
    }

    @GetMapping(path = "/verify-game-over")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Verifies if game is over due to revealing a mined square")
    public boolean isGameOver(String user) throws MinesweeperException {
        return minesweeperService.isGameOver(user);
    }

    @GetMapping(path = "/show-elapsed-time")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Shows the elapsed time of the game in seconds")
    public long getElapsedTime(String user) throws MinesweeperException {
        return (System.currentTimeMillis() - minesweeperService.getElapsedTime(user)) / 1000;
    }

    @GetMapping(path = "/save-game")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Saves current game using user as identifier")
    public void saveGame(String user) throws MinesweeperException {
        minesweeperService.saveGame(user);
    }

    @GetMapping(path = "/restore-game")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Restores a game grid instance by user")
    public void restoreGame(String user) throws MinesweeperException {
        minesweeperService.restoreGame(user);
    }

    @GetMapping(path = "/get-game-grid")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Returns the game grid of a current instance in Json format")
    public MineSquare[][] getGameGrid(String user) throws MinesweeperException {
        MineGameGrid mineGameGrid = minesweeperService.getMineGameGridByUser(user);
        return mineGameGrid.getGameGrid();
    }
}
