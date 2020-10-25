package minesweeper.service;

import minesweeper.exception.MinesweeperException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class MinesweeperServiceTest {

    MinesweeperService minesweeperService;

    @Before
    public void setUp() {
        minesweeperService = new MinesweeperService();
    }

    @Test(expected = MinesweeperException.class)
    public void testCreateGameWithInvalidMinesNumberShouldThrowException() throws Exception {
        int rows = 10;
        int cols = 10;
        int totalMines = rows * cols * 10;
         minesweeperService.createGame("user", rows, cols, totalMines);
    }

    @Test(expected = MinesweeperException.class)
    public void testCreateGameWithInvalidValuesShouldThrowException() throws Exception {
        int rows = 1000;
        int cols = 1000000;
        int totalMines = 10010;
        minesweeperService.createGame("user", rows, cols, totalMines);
    }

    @Test
    public void testCreateGameAndSelectSquareReturnsGameCompleted() throws Exception {
        int rows = 3;
        int cols = 3;
        int totalMines = 0;
        minesweeperService.createGame("user", rows, cols, totalMines);
        assertThat(minesweeperService.setSquareGridRevealed(1,1, "user"), equalTo(SelectionResult.GAME_COMPLETED));
    }

    @Test
    public void testCreateGameAndSelectSquareReturnsGameOver() throws Exception {
        int rows = 3;
        int cols = 3;
        int totalMines = 9;
        minesweeperService.createGame("user", rows, cols, totalMines);
        assertThat(minesweeperService.setSquareGridRevealed(1,1, "user"), equalTo(SelectionResult.GAME_OVER));
    }

    @Test
    public void testSetSquareGridShouldReturnTrue() throws Exception {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setSquareGridRevealed(2,2, "user"), equalTo(SelectionResult.SELECTION_OK));
    }

    @Test
    public void testSetSquareGridOutOfIndexShouldReturnFalse() throws Exception {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setSquareGridRevealed(200,200, "user"), equalTo(SelectionResult.SELECTION_ERROR));
    }

    @Test
    public void testSetRedMarkSquareGridShouldReturnOk() throws Exception {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setRedMarkSquareGrid(10,10, "user"), equalTo(SelectionResult.SELECTION_OK));
    }

    @Test
    public void testSetQuestionMarkSquareShouldReturnOk() throws Exception {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setRedMarkSquareGrid(10,10, "user"), equalTo(SelectionResult.SELECTION_OK));
    }

    @Test
    public void testSetRedMarkSquareGridOutOfIndexShouldReturnError() throws Exception {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setRedMarkSquareGrid(-1,0, "user"), equalTo(SelectionResult.SELECTION_ERROR));
    }

    @Test
    public void testSetQuestionMarkSquareGridOutOfIndexShouldReturnError() throws Exception {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setRedMarkSquareGrid(-1,0, "user"), equalTo(SelectionResult.SELECTION_ERROR));
    }

    @Test
    public void testSettingAllSquaresRevealedInGridShouldSetGameOver() throws Exception {
        minesweeperService.createGame("user");
        for(int col = 0; col < 20; col++) {
            for(int row = 0; row < 20; row++) {
                minesweeperService.setSquareGridRevealed(col, row, "user");
            }
        }
        assertThat(minesweeperService.isGameOver("user"), equalTo(true));
    }

    @Test
    public void testTwoUserGameCreatedShouldReturnTwoInstances() throws Exception {
        minesweeperService.createGame("user");
        minesweeperService.createGame("user2");
        assertThat(minesweeperService.gameInstances.size(), equalTo(2));
    }

    @Test
    public void testUserGameCreatedTwiceShouldReturnOneInstance() throws Exception {
        minesweeperService.createGame("user");
        minesweeperService.createGame("user");
        assertThat(minesweeperService.gameInstances.size(), equalTo(1));
    }
}
