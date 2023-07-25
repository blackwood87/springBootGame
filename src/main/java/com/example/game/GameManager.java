package com.example.game;

import com.example.game.core.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameManager {
    private static Map<String, Game> gamesContainer = new HashMap<>();

    private GameManager(){}


    public static String createNewGame() {
        Game newGame = new Game();
        String newUuid = UUID.randomUUID().toString();

        gamesContainer.put(newUuid, newGame);

        return newUuid;
    }

    public static boolean deleteGame(String gameId) {
        if (gamesContainer.containsKey(gameId)) {
            gamesContainer.remove(gameId);
            return true;
        }

        return false;
    }

    public static Game getGame(String gameId) {
        return gamesContainer.get(gameId);
    }
}
