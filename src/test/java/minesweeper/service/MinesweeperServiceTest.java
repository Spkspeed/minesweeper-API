package minesweeper.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class MinesweeperServiceTest {

    MinesweeperService minesweeperService = new MinesweeperService();

    @Test
    public void testStartGameShouldReturnTrue() {
        assertThat(minesweeperService.createGame("user"), equalTo(true));
    }

    @Test
    public void testSetSquareGridShouldReturnTrue() {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setSquareGridRevealed(2,2, "user"), equalTo(SelectionResult.SELECTION_OK));
    }

    @Test
    public void testSetSquareGridOutOfIndexShouldReturnFalse() {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setSquareGridRevealed(200,200, "user"), equalTo(SelectionResult.SELECTION_ERROR));
    }

    @Test
    public void testSetRedMarkSquareGridShouldReturnOk() {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setRedMarkSquareGrid(10,10, "user"), equalTo(SelectionResult.SELECTION_OK));
    }

    @Test
    public void testSetQuestionMarkSquareShouldReturnOk() {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setRedMarkSquareGrid(10,10, "user"), equalTo(SelectionResult.SELECTION_OK));
    }

    @Test
    public void testSetRedMarkSquareGridOutOfIndexShouldReturnError() {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setRedMarkSquareGrid(-1,0, "user"), equalTo(SelectionResult.SELECTION_ERROR));
    }

    @Test
    public void testSetQuestionMarkSquareGridOutOfIndexShouldReturnError() {
        minesweeperService.createGame("user");
        assertThat(minesweeperService.setRedMarkSquareGrid(-1,0, "user"), equalTo(SelectionResult.SELECTION_ERROR));
    }

    @Test
    public void testSettingAllSquaresRevealedInGridShouldSetGameOver() {
        minesweeperService.createGame("user");
        for(int col = 0; col < 20; col++) {
            for(int row = 0; row < 20; row++) {
                minesweeperService.setSquareGridRevealed(col, row, "user");
            }
        }
        assertThat(minesweeperService.isGameOver("user"), equalTo(true));
    }

    @Test
    public void testTwoUserGameCreatedShouldReturnTwoInstances() {
        minesweeperService.createGame("user");
        minesweeperService.createGame("user2");
        assertThat(minesweeperService.gameInstances.size(), equalTo(2));
    }

    @Test
    public void testUserGameCreatedTwiceShouldReturnOneInstance() {
        minesweeperService.createGame("user");
        minesweeperService.createGame("user");
        assertThat(minesweeperService.gameInstances.size(), equalTo(1));
    }
}
