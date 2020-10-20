package minesweeper.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MinesweeperController {

    @GetMapping(path = "/test")
    @ResponseStatus(HttpStatus.OK)
    public String getTestAccess() throws Exception {
        return "Test is ok";
    }
}
