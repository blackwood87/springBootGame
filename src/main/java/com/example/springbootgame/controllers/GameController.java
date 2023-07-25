package com.example.springbootgame.controllers;

import com.example.game.GameManager;
import com.example.game.actionresults.MakeMoveResult;
import com.example.game.core.Game;
import com.example.springbootgame.views.GameDeleteView;
import com.example.springbootgame.views.GameMoveView;
import com.example.springbootgame.views.GameStartView;
import com.example.springbootgame.views.PositionView;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "game")
public class GameController {

    @GetMapping("createNew")
    public GameStartView createNewGame() {
        GameStartView response = new GameStartView();
        try {
            String newGameId = GameManager.createNewGame();
            response.setGameId(newGameId);
            response.setStatusCode(GameStartView.StatusCode.resultOk);
        } catch (Exception ex) {
            response.setGameId("0000-0000-0000-0000");
            response.setStatusCode(GameStartView.StatusCode.genericError);
        }

        return response;
    }


    @DeleteMapping("")
    public GameDeleteView deleteGame(@RequestParam String gameId) {
        GameDeleteView response = new GameDeleteView();

        Game game = GameManager.getGame(gameId);

        if (game == null) {
            response.setStatusCode(GameDeleteView.StatusCode.notExistingGame);
        }

        if (GameManager.deleteGame(gameId)) {
            response.setStatusCode(GameDeleteView.StatusCode.resultOk);
        } else {
            response.setStatusCode(GameDeleteView.StatusCode.genericError);
        }

        return response;
    }


    @GetMapping("{gameId}/makeMove")
    public GameMoveView makeMove(@PathVariable String gameId, @RequestParam int newX, @RequestParam int newY) {
        GameMoveView response = new GameMoveView();
        Game game = GameManager.getGame(gameId);

        if (game == null) {
            response.setStatusCode(GameMoveView.StatusCode.gameNotFound);
            return response;
        }

        MakeMoveResult result = game.makeMove(newX, newY);
        if (result.isMadeMove()) {
            response.setStatusCode(GameMoveView.StatusCode.resultOk);
        } else {
            response.setStatusCode(GameMoveView.StatusCode.illegalMove);
        }

        PositionView newPosition = new PositionView();

        newPosition.setX(result.getX());
        newPosition.setY(result.getY());

        response.setNewPosition(newPosition);

        return response;
    }
}
