package com.pssls.controller;

import java.util.Random;

public class GameController {

    private Random randomGenerator = new Random();
    private int[][] resultTableStandard = {
            {0 , 1 , 3},
            {1 , 0 , 2},
            {3 , 2 , 0} };
    private int[][] resultTableExpanded = {
            {0 , 1 , 3 , 4 , 1},
            {1 , 0 , 2 , 2 , 5},
            {3 , 2 , 0 , 3 , 5},
            {4 , 2 , 3 , 0 , 4},
            {1 , 5 , 5 , 4 , 0}};

    private int playerMove;
    private int siChoose;
    private int winResult;
    private int playerPoints;
    private int siPoints;

    private void  pointCounter(DialogController dialogController) {
        System.out.println();
        if(playerMove == winResult) {
            playerPoints++;
        }
        if(siChoose + 1 == winResult) {
            siPoints++;
        }
        if(playerPoints == dialogController.getPointsToWin() || siPoints == dialogController.getPointsToWin()) {
            dialogController.end = true;
        }
        System.out.println("\nPoints: \n " + dialogController.getPlayerName() + " = " + playerPoints + "\n SI: " + siPoints);
    }

    private void siMove(DialogController dialogController) {
        System.out.println("Si choose:");
        if (dialogController.getGameMode() == 1) {
            siChoose = randomGenerator.nextInt(3);
        }else if(dialogController.getGameMode() == 2 ) {
            siChoose = randomGenerator.nextInt(5);
        }
        switch (siChoose) {
            case 0:
                System.out.println("Paper!\n");
                break;
            case 1:
                System.out.println("Stone!\n");
                break;
            case 2:
                System.out.println("Scissors!\n");
                break;
            case 3:
                System.out.println("Lizard!\n");
                break;
            case 4:
                System.out.println("Spock!\n");
                break;
        }
    }

    public void winChecker(DialogController dialogController) {
        playerMove = Integer.parseInt(dialogController.getPlayerInput());
        siMove(dialogController);
        if (dialogController.getGameMode() == 1) {
            winResult = resultTableStandard[playerMove - 1][siChoose];
        } else {
            winResult = resultTableExpanded[playerMove - 1][siChoose];
        }

       if (winResult == 1){
           System.out.println("<<Paper Win!>>");
       }else if (winResult == 2){
           System.out.println("<<Stone Win!>>");
       }else if (winResult == 3) {
           System.out.println("<<Scissors Win!>>");
       } else if (winResult == 4) {
           System.out.println("<<Lizard Win!>>");
       }else if (winResult == 5) {
           System.out.println("<<Spock Win!>>");
       } else {
            System.out.println("<<Draw!>>");
       }
        pointCounter(dialogController);
    }

    public void resetPoints() {
        playerPoints = 0;
        siPoints = 0;
    }

}
