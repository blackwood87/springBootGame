package com.example.game.core;

public interface LivingPawn {
    public int getLifePoints();
    public default boolean isStillAlive() {
        return getLifePoints() > 0;
    }
}
