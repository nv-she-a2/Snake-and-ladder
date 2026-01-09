package com.example.myapp.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Player {
    private String name;
    private List<Integer> historyPositions;
    private int position = 1;
    private boolean canPlay = true;

    public Player(String name , boolean canPlay) {
        this.name = name;
        this.historyPositions = new ArrayList<>();
        this.canPlay = canPlay;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    public void addHistoryPositions(int position) {
        this.historyPositions.add(position);
    }
}
