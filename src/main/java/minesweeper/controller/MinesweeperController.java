package minesweeper.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import minesweeper.exception.MinesweeperException;
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
    public void createGame(String user, Integer rows, Integer cols, Integer totalMines) {
        minesweeperService.createGame(user, rows, cols, totalMines);
    }

    @PostMapping(path = "/create-game")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Creates a new Game instance using default values of rows = 20, cols = 20, totalMines = 10")
    public void createGame(String user) {
        minesweeperService.createGame(user);
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
        return (System.currentTimeMillis() - minesweeperService.getElapsedTime(user))/1000;
    }
}
