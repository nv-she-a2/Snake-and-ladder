package com.example.myapp.entity;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SnakeAndLadderBoard implements IBoard {
    char[] cells;

    private HashMap<Integer, Integer> cellToSnakeEndMap = new HashMap<>();

    private HashMap<Integer, Integer> cellToLadderEndMap = new HashMap<>();

    // default board size
    public SnakeAndLadderBoard() {
        this.cells = new char[101];
        Arrays.fill(this.cells, '.');
    }

    public SnakeAndLadderBoard(int boardSize) {
        this.cells = new char[boardSize+1];
        Arrays.fill(this.cells, '.');
    }

    @Override
    public char[] getCells() {
        return new char[0];
    }

    @Override
    public void makeSnake(List<Pair<Integer, Integer>> snakes) {
        for (Pair<Integer, Integer> snake : snakes) {
            cells[snake.getKey()] = 's';
            cellToSnakeEndMap.put(snake.getKey(), snake.getValue());
        }
    }

    @Override
    public void makeLadder(List<Pair<Integer, Integer>> ladders) {
        for (Pair<Integer, Integer> ladder : ladders) {
            cells[ladder.getKey()] = 'l';
            cellToLadderEndMap.put(ladder.getKey(), ladder.getValue());
        }
    }

    @Override
    public int getSnakeEnd(int cell) {
        return cellToSnakeEndMap.get(cell);
    }

    @Override
    public int getLadderEnd(int cell) {
        return cellToLadderEndMap.get(cell);
    }
}
