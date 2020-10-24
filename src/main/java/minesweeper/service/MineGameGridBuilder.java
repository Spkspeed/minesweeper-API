package minesweeper.service;

public class MineGameGridBuilder {

    protected Integer totalRows;
    protected Integer totalCols;
    protected Integer totalMinesInGrid;

    public MineGameGridBuilder setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
        return this;
    }

    public MineGameGridBuilder setTotalCols(Integer totalCols) {
        this.totalCols = totalCols;
        return this;
    }

    public MineGameGridBuilder setTotalMinesInGrid(Integer totalMinesInGrid) {
        this.totalMinesInGrid = totalMinesInGrid;
        return this;
    }

    public MineGameGrid build() {
        return new MineGameGrid(totalRows, totalCols, totalMinesInGrid);
    }

}
