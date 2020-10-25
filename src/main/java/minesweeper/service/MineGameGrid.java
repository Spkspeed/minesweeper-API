package minesweeper.service;

import java.util.Random;

public class MineGameGrid {

    protected Integer totalRows = 20;
    protected Integer totalCols = 20;
    protected Integer totalMinesInGrid = 100;

    private long elapsedTime;
    private boolean gameOver;

    private MineSquare[][] gameGrid;

    protected MineGameGrid(int rows, int cols, int totalMines) {
        totalRows = rows;
        totalCols = cols;
        totalMinesInGrid = totalMines;

        initializeGameGrid();
    }

    public MineGameGrid() {
        initializeGameGrid();
    }

    private void initializeGameGrid() {
        elapsedTime = System.currentTimeMillis();
        gameOver = false;
        gameGrid = new MineSquare[totalRows][totalCols];

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                gameGrid[row][col] = new MineSquare();
            }
        }

        setMines(totalRows, totalCols);
    }

    private void setMines(int rows, int cols) {
        Random rand = new Random();

        int posX;
        int posY;
        int minesSet = 0;

        while (minesSet < totalMinesInGrid) {
            posX = rand.nextInt(rows);
            posY = rand.nextInt(cols);
            if (!gameGrid[posX][posY].getSquareMined()) {
                gameGrid[posX][posY].setSquareMined(true);
                minesSet++;
            }
        }
    }

    public SelectionResult setSquareGrid(int row, int col, SquareState selectionType) {
        if (isPositionOutOfGrid(row, col)) {
            return SelectionResult.SELECTION_ERROR;
        } else {
            if (selectionType == SquareState.REVEALED) {
                gameGrid[row][col].setSquareState(selectionType);
                if (gameGrid[row][col].getSquareMined()) {
                    setGameOver(true);
                } else {
                    if (checkAdjacentSquaresHaveMines(row, col)) {
                        showAdjacentSquares(row, col);
                    }
                }
            } else {
                gameGrid[row][col].setSquareState(selectionType);
            }

            return SelectionResult.SELECTION_OK;
        }
    }

    protected boolean checkAdjacentSquaresHaveMines(int row, int col) {
        boolean isMined = false;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int posX = row;
                int posY = col;
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    posX += j;
                    posY += i;
                    if (!isPositionOutOfGrid(posX, posY)) {
                        isMined = gameGrid[posX][posY].getSquareMined();
                    }
                }
            }
        }
        return isMined;
    }

    private void showAdjacentSquares(int row, int col) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int posX = row;
                int posY = col;
                if (i == 0 && j == 0) {
                    continue;
                } else {
                    posX += j;
                    posY += i;
                    if(!isPositionOutOfGrid(posX, posY)) {
                        gameGrid[posX][posY].setSquareState(SquareState.REVEALED);
                    }
                }
            }
        }
    }

    protected boolean isPositionOutOfGrid(int row, int col) {
        return (row > (totalRows - 1) || row < 0 || col > (totalCols - 1) || col < 0);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public Integer getTotalCols() {
        return totalCols;
    }

    public Integer getTotalMinesInGrid() {
        return totalMinesInGrid;
    }

    public MineSquare[][] getGameGrid() {
        return gameGrid;
    }

}