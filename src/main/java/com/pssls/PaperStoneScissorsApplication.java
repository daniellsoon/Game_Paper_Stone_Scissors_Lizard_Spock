package com.pssls;


import com.pssls.controller.DialogController;
import com.pssls.controller.GameController;

public class PaperStoneScissorsApplication {

    public static void main(String args[]) {

        DialogController dialogController = new DialogController();
        GameController gameController = new GameController();

        dialogController.gameModeChecker();
        while (!dialogController.end) {
            dialogController.playerMove(gameController);
            if (!dialogController.end)
            gameController.winChecker(dialogController);
        }
    }
}
