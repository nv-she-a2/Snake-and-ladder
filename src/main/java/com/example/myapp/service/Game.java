package com.example.myapp.service;

import com.example.myapp.entity.Dice;
import com.example.myapp.entity.IBoard;
import com.example.myapp.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    IBoard board;
    private Dice dice = null;
    private final int minPlayersToContinueGame = 1;

    public Game(List<Player> players, IBoard board,int noOfDicesSupported) {
        this.players = players;
        this.board = board;
        this.dice = new Dice(noOfDicesSupported);
    }

    public void startGame() {
        List<Player> playersToContinue = new ArrayList<>(players);
        char[] cells = board.getCells();

        int turn = 0, n = players.size();
        while(n > minPlayersToContinueGame) {
            if(dice.rollDice()){
                continue;
            }else{
                int rolledDice = dice.getRolledDice();
                Player player = playersToContinue.get(turn++ % n);
                if(!player.isCanPlay()) {
                    initializePlayer(player, rolledDice);
                    if(!player.isCanPlay()) {
                        System.out.println(player + " is skipped as the player has not yet rolled 1 or 6");
                        continue;
                    }
                }
                int oldPosition = player.getPosition();
                int position = oldPosition + rolledDice;
                if(position > cells.length-1) {
                    position = oldPosition;
                    System.out.println(player + " rolled a " + rolledDice + " and moved from " + oldPosition + " to " + position);
                } else {
                    player.addHistoryPositions(oldPosition);
                    if (cells[position] == 's') {
                        position = board.getSnakeEnd(position);
                    } else if (cells[position] == 'l') {
                        position = board.getLadderEnd(position);
                    }
                    System.out.println(player + " rolled a " + rolledDice + " and moved from " + oldPosition + " to " + position);
                    if (position == cells.length-1) {
                        System.out.println(player + " wins the game ");
                        playersToContinue.remove(player);
                        n--;
                    }
                }
            }
        }

    }

    private void initializePlayer(Player player, int dice) {
        if(dice == 1 || dice >= 6){
            player.setCanPlay(true);
        }
    }

}
