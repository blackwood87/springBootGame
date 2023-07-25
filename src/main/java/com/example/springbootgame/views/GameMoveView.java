package com.example.springbootgame.views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameMoveView extends OperationView<GameMoveView.StatusCode>{
    private PositionView newPosition;
    public enum StatusCode {
        resultOk(0),
        gameNotFound(2),
        illegalMove(3),
        genericError(-1);

        @Getter
        private final int value;

        StatusCode(int value) {
            this.value = value;
        }
    }
}
