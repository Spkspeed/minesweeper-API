package minesweeper.service;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MineGameGridTest {

    @Test
    public void testAdjacentSquaresHaveMines() {
        MineGameGrid mineGameGrid = new MineGameGrid(20, 20, 400);
        assertThat(mineGameGrid.checkAdjacentSquaresHaveMines(5, 5), equalTo(true));
    }

    @Test
    public void testAdjacentSquaresDoNotHaveMines() {
        MineGameGrid mineGameGrid = new MineGameGrid(20, 20, 0);
        assertThat(mineGameGrid.checkAdjacentSquaresHaveMines(5, 5), equalTo(false));
    }

    @Test
    public void testIsPositionOutOfGridReturnsFalse() {
        MineGameGrid mineGameGrid = new MineGameGrid();
        assertThat(mineGameGrid.isPositionOutOfGrid((mineGameGrid.totalRows - 1), (mineGameGrid.totalCols - 1)), equalTo(false));
    }

    @Test
    public void testIsPositionOutOfGridReturnsTrue() {
        MineGameGrid mineGameGrid = new MineGameGrid();
        assertThat(mineGameGrid.isPositionOutOfGrid(mineGameGrid.totalRows + 100, mineGameGrid.totalCols + 100), equalTo(true));
    }

}
