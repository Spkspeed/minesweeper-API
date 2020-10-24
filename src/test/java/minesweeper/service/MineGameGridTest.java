package minesweeper.service;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class MineGameGridTest {

    @Test
    public void testAdjacentSquaresHaveMines() {
        MineGameGrid mineGameGrid = new MineGameGrid(400);
        assertThat(mineGameGrid.checkAdjacentSquaresHaveMines(5, 5), equalTo(true));
    }

    @Test
    public void testAdjacentSquaresDoNotHaveMines() {
        MineGameGrid mineGameGrid = new MineGameGrid(0);
        assertThat(mineGameGrid.checkAdjacentSquaresHaveMines(5, 5), equalTo(false));
    }
}
