package com.example.springbootgame.views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDeleteView extends OperationView<GameDeleteView.StatusCode> {
    public enum StatusCode {
        resultOk(0),
        notExistingGame(1),
        genericError(-1);

        @Getter
        private final int value;

        StatusCode(int value) {

            this.value = value;
        }
    }
}
