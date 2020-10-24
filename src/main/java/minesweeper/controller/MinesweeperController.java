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

    @PostMapping(path = "/create-game")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Creates a new Game instance")
    public String createGame(String user) {
        minesweeperService.createGame(user);
        return "Ok";
    }

    @GetMapping(path = "/square-selection-reveal")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Selects an square in the grid for reveal it")
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
    @ApiOperation(value = "Verifies is game is over were set if mined square was revealed")
    public boolean isGameOver(String user) {
        return minesweeperService.isGameOver(user);
    }

    @GetMapping(path = "/show-elapsed-time")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Basic test endpoint")
    public long getElapsedTime(String user) {
        return (System.nanoTime() - minesweeperService.getElapsedTime(user));
    }
}
