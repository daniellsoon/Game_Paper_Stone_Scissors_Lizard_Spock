package com.pssls.controller;

import java.util.Arrays;
import java.util.Scanner;

public class DialogController {

    public boolean end = false;

    private int gameMode;
    private String playerInput;
    private int pointsToWin;
    private String playerName;

    private String[] playerPoolExpanded = {"1" , "2", "3", "4", "5" , "x" , "n"};
    private String[] playerPoolStandard = {"1" , "2", "3", "x" , "n"};

    private Scanner scanner = new Scanner(System.in);

    public int getGameMode() {
        return gameMode;
    }

    public String getPlayerInput() {
        return playerInput;
    }

    public int getPointsToWin() {
        return pointsToWin;
    }

    public  String getPlayerName() {
        return playerName;
    }

    public void  gameModeChecker() {
        System.out.println("Choose game mode:\n 1. Standard Paper-Stone-Scissors \n 2. Expanded with Lizard & Spock");
        String gameModeInput = scanner.nextLine();

        while (!gameModeInput.equals("1") && !gameModeInput.equals("2")) {
            System.out.println("Please put only 1 or 2");
            gameModeInput = scanner.nextLine();
        }
        gameMode = Integer.parseInt(gameModeInput);
        maxPoint();
    }

    public void  playerMove(GameController gameController) {
        if(gameMode == 1) {
            System.out.println("Choose:\n 1. Paper \n 2. Stone \n 3. Scissors \n x. End Game! \n n. New Game");
            playerInput = scanner.nextLine();

            while (!Arrays.asList(playerPoolStandard).contains(playerInput)) {
                System.out.println("Please put only 1, 2, 3, x or n.");
                playerInput = scanner.nextLine();
            }
        } else if(gameMode == 2) {
            System.out.println("Choose:\n 1. Paper \n 2. Stone \n 3. Scissors \n 4. Lizard \n 5. Spock \n x. End Game! \n n. New Game");
            playerInput = scanner.nextLine();

            while (!Arrays.asList(playerPoolExpanded).contains(playerInput)) {
                System.out.println("Please put only 1, 2, 3, 4, 5, x or n.");
                playerInput = scanner.nextLine();
            }
        }
        if (playerInput.equals("x")) {
            quitGame(gameController);
        }
        if (playerInput.equals("n")) {
            resetGame(gameController);
        }
    }

    private void maxPoint() {
        System.out.println("Set how many points need to win:");
        pointsToWin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Whats your name?");
        playerName = scanner.nextLine();

    }

    private void resetGame(GameController gameController) {
        System.out.println("You really want restart game? (y/n)");
        String resetInput = scanner.nextLine();
        if (resetInput.equals("y")){
            gameController.resetPoints();
            pointsToWin = 0;
            playerName = null;
            gameModeChecker();
            playerMove(gameController);
        } else if (resetInput.equals("n")) {
            System.out.println("Continue...");
            playerMove(gameController);
        } else {
            System.out.println("Input only y or n.");
        }
    }

    private void  quitGame(GameController gameController) {
        System.out.println("You really want quit game? (y/n)");
        String quitInput = scanner.nextLine();
        if (quitInput.equals("y")){
            end = true;
        } else if (quitInput.equals("n")) {
            System.out.println("Continue...");
            playerMove(gameController);
        } else {
            System.out.println("Input only y or n.");
        }
    }

}
