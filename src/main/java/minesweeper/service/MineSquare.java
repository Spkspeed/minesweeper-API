package minesweeper.service;

/**
 * Basic square object for storing states
 */
public class MineSquare {

    private Boolean squareVisible;
    private Boolean squareMined;
    private Boolean squareFlagged;

    public MineSquare() {
        squareVisible = false;
        squareMined = false;
        squareFlagged = false;
    }

    public Boolean getSquareVisible() {
        return squareVisible;
    }

    public void setSquareVisible(Boolean squareVisible) {
        this.squareVisible = squareVisible;
    }

    public Boolean getSquareMined() {
        return squareMined;
    }

    public void setSquareMined(Boolean squareMined) {
        this.squareMined = squareMined;
    }

    public Boolean getSquareFlagged() {
        return squareFlagged;
    }

    public void setSquareFlagged(Boolean squareFlagged) {
        this.squareFlagged = squareFlagged;
    }

}