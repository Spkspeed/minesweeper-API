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
