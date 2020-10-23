package minesweeper.service;

/**
 * Basic square object for storing states
 */
public class MineSquare {

    private Boolean squareMined;
    private SquareState squareState;

    public MineSquare() {
        squareMined = false;
        squareState = SquareState.NOT_REVEALED;
    }

    public Boolean getSquareMined() {
        return squareMined;
    }

    public void setSquareMined(Boolean squareMined) {
        this.squareMined = squareMined;
    }

    public SquareState getSquareState() {
        return squareState;
    }

    public void setSquareState(SquareState squareState) {
        this.squareState = squareState;
    }
}