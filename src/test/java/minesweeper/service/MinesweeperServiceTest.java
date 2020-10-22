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
    public void testStartGameShouldReturn() {
        assertThat(minesweeperService.startGame(), equalTo(true));
    }

    @Test
    public void testSetSquareGrid() {
        fail("Should fail");
    }

    @Test
    public void testSetFlagSquareGrid() {
        fail("Should fail");
    }
}
