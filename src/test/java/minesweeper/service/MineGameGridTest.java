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

    @Test
    public void testIsPositionOutOfGridReturnsFalse() {
        MineGameGrid mineGameGrid = new MineGameGrid();
        assertThat(mineGameGrid.isPositionOutOfGrid((mineGameGrid.GRID_ROWS - 1), (mineGameGrid.GRID_COLS - 1)), equalTo(false));
    }

    @Test
    public void testIsPositionOutOfGridReturnsTrue() {
        MineGameGrid mineGameGrid = new MineGameGrid();
        assertThat(mineGameGrid.isPositionOutOfGrid(mineGameGrid.GRID_ROWS + 100, mineGameGrid.GRID_COLS + 100), equalTo(true));
    }
}
