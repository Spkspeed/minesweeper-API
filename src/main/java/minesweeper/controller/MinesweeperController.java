package minesweeper.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Minesweeper API basic services")
public class MinesweeperController {

    @GetMapping(path = "/test")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Basic test endpoint")
    public String getTestAccess() throws Exception {
        return "Test is ok";
    }
}
