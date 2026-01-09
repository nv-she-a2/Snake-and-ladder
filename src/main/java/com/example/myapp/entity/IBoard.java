package com.example.myapp.entity;

import java.util.List;

public interface IBoard {
    public char[] getCells();
    public void makeSnake(List<Pair<Integer, Integer>> snakes);
    public void makeLadder(List<Pair<Integer, Integer>>  ladders);

    public int getSnakeEnd(int cell);

    public int getLadderEnd(int cell);
}
