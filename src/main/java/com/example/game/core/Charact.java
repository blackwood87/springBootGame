package com.example.game.core;

import lombok.Getter;

@Getter
public class Charact implements Placeable, LivingPawn {
    private int xPosition;
    private int yPosition;
    private int lifePoints;
    private final String name;

    public Charact(String name, int startingX, int startingY) {
        this.name = name;
        xPosition = startingX;
        yPosition = startingY;
    }

    void setNewPosition(int newX, int newY) {
        xPosition = newX;
        yPosition = newY;
    }

    public boolean inflictDamage(int damage) {
        if (damage > 0) {
            lifePoints -= damage;
        }

        return isStillAlive();
    }

    public boolean healDamage(int heal) {
        if (heal > 0) {
            lifePoints += heal;
        }

        return isStillAlive();
    }
}
