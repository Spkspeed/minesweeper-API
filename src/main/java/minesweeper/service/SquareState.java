package minesweeper.service;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SquareState {

    RED_MARK("1"),
    QUESTION_MARK("2"),
    NOT_REVEALED("3"),
    REVEALED("4");

    private String value;

    SquareState(String value){
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }
}
