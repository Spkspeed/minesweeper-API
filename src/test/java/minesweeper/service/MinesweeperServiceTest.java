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
        assertThat(minesweeperService.startGame(), equalTo(true));
    }

    @Test
    public void testSetSquareGridShouldReturnTrue() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setSquareGridRevealed(2,2), equalTo(SelectionResult.SELECTION_OK));
    }

    @Test
    public void testSetSquareGridOutOfIndexShouldReturnFalse() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setSquareGridRevealed(200,200), equalTo(SelectionResult.SELECTION_ERROR));
    }

    @Test
    public void testSetRedMarkSquareGridShouldReturnOk() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setRedMarkSquareGrid(10,10), equalTo(SelectionResult.SELECTION_OK));
    }

    @Test
    public void testSetQuestionMarkSquareShouldReturnOk() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setRedMarkSquareGrid(10,10), equalTo(SelectionResult.SELECTION_OK));
    }

    @Test
    public void testSetRedMarkSquareGridOutOfIndexShouldReturnError() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setRedMarkSquareGrid(-1,0), equalTo(SelectionResult.SELECTION_ERROR));
    }

    @Test
    public void testSetQuestionMarkSquareGridOutOfIndexShouldReturnError() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setRedMarkSquareGrid(-1,0), equalTo(SelectionResult.SELECTION_ERROR));
    }

    @Test
    public void testSettingAllSquaresRevealedInGridShouldSetGameOver() {
        minesweeperService.startGame();
        for(int col = 0; col < 20; col++) {
            for(int row = 0; row < 20; row++) {
                minesweeperService.setSquareGridRevealed(col, row);
            }
        }
        assertThat(minesweeperService.isGameOver(), equalTo(true));
    }

}
