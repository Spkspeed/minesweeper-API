package minesweeper.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class MinesweeperServiceTest {

    private final int SELECTION_FULFILLED = 1;
    private final int INCORRECT_SELECTION = 0;

    MinesweeperService minesweeperService = new MinesweeperService();

    @Test
    public void testStartGameShouldReturnTrue() {
        assertThat(minesweeperService.startGame(), equalTo(true));
    }

    @Test
    public void testSetSquareGridShouldReturnTrue() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setSquareGrid(2,2), equalTo(SELECTION_FULFILLED));
    }

    @Test
    public void testSetSquareGridOutOfIndexShouldReturnFalse() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setSquareGrid(200,200), equalTo(INCORRECT_SELECTION));
    }

    @Test
    public void testSetFlagSquareGridShouldReturnTrue() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setFlagSquareGrid(2,2), equalTo(true));
    }

    @Test
    public void testSetFlagSquareGridOutOfIndexShouldReturnFalse() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setFlagSquareGrid(-1,0), equalTo(false));
    }
}
