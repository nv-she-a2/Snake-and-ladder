package com.example.myapp;

import com.example.myapp.entity.*;
import com.example.myapp.service.Game;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pair<Integer, Integer>>  snakes = new ArrayList<>();
        List<Pair<Integer, Integer>> ladders = new ArrayList<>();

        IBoard board = new SnakeAndLadderBoard();

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(); //input for snakes
        for(int i=0; i<s; i++)  {
            int ss = sc.nextInt(); //snake start
            int se = sc.nextInt(); //snake end
            snakes.add(new Pair<>(ss, se));
        }

        board.makeSnake(snakes);

        int l =  sc.nextInt(); //input for ladders
        for(int i=0; i<l; i++)  {
            int ls = sc.nextInt(); //ladder start
            int le = sc.nextInt(); //ladder end
            ladders.add(new Pair<>(ls, le));
        }

        board.makeLadder(ladders);

        int n = sc.nextInt(); // no of players
        List<Player> players = new ArrayList<>();
        for(int i=0; i<n; i++)  {
            players.add(new Player(sc.next(), true));
        }

        Game game = new Game(players, board,1);
        game.startGame();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,4);
        map.put(2,3);

        Map<Integer, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2,
                        HashMap::new));
        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {}
    }
}