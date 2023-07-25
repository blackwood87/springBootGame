package com.example.game.core;

import com.example.game.actionresults.MakeMoveResult;

import java.util.List;

public class Game {
    private final int MAX_X = 10;
    private final int MAX_Y = 10;
    private final Board board;

    public Game() {
        board = new Board(MAX_X, MAX_Y);

        Charact p1 = new Charact("Giocatore 1", 1, 1);
        Charact p2 = new Charact("Giocatore 2", MAX_X, MAX_Y);

        board.addCharacter(p1);
        board.addCharacter(p2);
    }

    public List<Charact> getCharacters(){
        return board.charactersOrder();
    }

    public MakeMoveResult makeMove(int deltaX, int deltaY) {
        return board.makeMove(deltaX, deltaY);
    }
}
