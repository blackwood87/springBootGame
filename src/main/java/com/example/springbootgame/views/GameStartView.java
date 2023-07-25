package com.example.springbootgame.views;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameStartView extends OperationView<GameStartView.StatusCode>{
    private String gameId;

    public enum StatusCode {
        resultOk(0),
        genericError(1);

        public final int value;

        StatusCode(int value) {

            this.value = value;
        }
    }
}
