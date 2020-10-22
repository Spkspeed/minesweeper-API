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
        assertThat(minesweeperService.setSquareGrid(2,2), equalTo(true));
    }

    @Test
    public void testSetSquareGridOutofIndexShouldReturnFalse() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setSquareGrid(200,200), equalTo(false));
    }

    @Test
    public void testSetFlagSquareGridShouldReturnTrue() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setFlagSquareGrid(2,2), equalTo(true));
    }

    @Test
    public void testSetFlagSquareGridWithIncorrectValuesShouldReturnFalse() {
        minesweeperService.startGame();
        assertThat(minesweeperService.setFlagSquareGrid(-1,0), equalTo(false));
    }
}
