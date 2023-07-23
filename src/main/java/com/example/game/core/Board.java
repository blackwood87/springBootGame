package com.example.game.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Board {
    private final int maxXLength;
    private final int maxYLength;
    private final Queue<Charact> characters = new LinkedBlockingQueue<>();

    private void nextCharacter() {
        Charact temp = characters.poll();
        characters.add(temp);
    }

    public Board(int maxX, int maxY) {
        this.maxXLength = maxX;
        this.maxYLength = maxY;
    }

    public List<Charact> addCharacter(Charact newCharacter) {
        characters.add(newCharacter);
        return new ArrayList<>(characters);
    }

    public Charact currentCharacter() {
        return characters.peek();
    }

    public List<Charact> charactersOrder() {
        return new ArrayList<>(characters);
    }

    public boolean makeMove(int deltaX, int deltaY) {
        Charact currentPlayer = currentCharacter();

        int newX = currentPlayer.getXPosition() + deltaX;
        boolean isOverX = newX > maxXLength;
        boolean isXBelowOne = newX < 1;

        int newY = currentPlayer.getYPosition() + deltaY;
        boolean isOverY = newY > maxYLength;
        boolean isYBelowOne = newY < 1;

        if (isOverX || isOverY || isXBelowOne || isYBelowOne) {
            return false;
        }

        currentPlayer.setNewPosition(newX, newY);

        nextCharacter();
        return true;
    }
}
