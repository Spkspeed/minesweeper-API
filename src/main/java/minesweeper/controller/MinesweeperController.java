package minesweeper.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @GetMapping(path = "/test")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Basic test endpoint")
    public String getTestAccess() {
        return "Test is ok";
    }

    @PostMapping(path = "/create-custom-game")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Creates a new customized game instance by setting rows, cols and number of mines")
    public String createGame(String user, Integer rows, Integer cols, Integer totalMines) {
        minesweeperService.createGame(user, rows, cols, totalMines);
        return "Ok";
    }

    @PostMapping(path = "/create-game")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Creates a new Game instance using default values of rows = 20, cols = 20, totalMines = 10")
    public String createGame(String user) {
        minesweeperService.createGame(user);
        return "Ok";
    }
    @GetMapping(path = "/square-selection-reveal")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Selects an square in the grid for reveal it, will throw Game Over if mined square is revealed")
    public SelectionResult setSquareGridRevealed(int col, int row, String user) {
        return minesweeperService.setSquareGridRevealed(col, row, user);
    }

    @GetMapping(path = "/square-selection-red-mark")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Selects an square in the grid with red marking")
    public SelectionResult setRedMarkSquareGrid(int col, int row, String user) {
        return minesweeperService.setRedMarkSquareGrid(col, row, user);
    }

    @GetMapping(path = "/square-selection-question-mark")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Selects an square in the grid with question marking")
    public SelectionResult setQuestionMarkSquareGrid(int col, int row, String user) {
        return minesweeperService.setQuestionMarkSquareGrid(col, row, user);
    }

    @GetMapping(path = "/verify-game-over")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Verifies if game is over due to revealing a mined square")
    public boolean isGameOver(String user) {
        return minesweeperService.isGameOver(user);
    }

    @GetMapping(path = "/show-elapsed-time")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Shows the elapsed time of the game in seconds")
    public long getElapsedTime(String user) {
        return (System.currentTimeMillis() - minesweeperService.getElapsedTime(user))/1000;
    }
}
