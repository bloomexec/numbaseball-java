package com.example.numbaseball;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

@Getter
@Setter
public class App {

    public static void main(String[] args) {
        App game = new App();
        game.playGame();
    }

    private Integer strike;
    private Integer ball;
    private Integer out;
    private Integer attempt;
    private Integer[] correctAnswer;
    private Integer[] playerAnswer;

    public void playGame() {
        initGame();
        for (int i = getAttempt(); i > 0; i--) {
            initInning();
            setPlayerAnswer(getPlayerInput());
            score(getCorrectAnswer(), getPlayerAnswer());
            System.out.printf("%d: [%d, %d, %d] - %dS %dB %dO\n", getAttempt() - i + 1, getPlayerAnswer()[0], getPlayerAnswer()[1], getPlayerAnswer()[2], getStrike(), getBall(), getOut());
            judge();
        }
    }

    private void initGame() {
        setStrike(0);
        setBall(0);
        setOut(0);
        setAttempt(9);
        setCorrectAnswer(generateCorrectAnswer());
    }

    private void initInning() {
        setStrike(0);
        setBall(0);
    }

    private Integer[] generateCorrectAnswer() {
        Integer[] result = new Integer[3];
        Random random = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(10);
            if ((i > 0 && result[i] == result[i-1]) || (i == result.length - 1 && result[i] == result[i-2])) {
                i--;
            }
        }
        return result;
    }

    private Integer[] getPlayerInput() {
        Integer[] result = new Integer[3];
        try {
            for (int i = 0; i < result.length; i++) {
                System.out.printf("Enter your %dst number[0-9]: ", i + 1);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String read = reader.readLine();
                if (read.equals("q")) {
                    System.exit(0);
                } else {
                    result[i] = Integer.parseInt(read);
                }
                if ((i > 0 && result[i] == result[i-1]) || (i == result.length - 1 && result[i] == result[i-2])) {
                    System.out.println("Duplication isn't allowed.");
                    i--;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void score(Integer[] correct, Integer[] player) {
        for (int i = 0; i < correct.length; i++) {
            for (int j = 0; j < player.length; j++) {
                if (correct[i] == player[j]) {
                    if (i == j) {
                        setStrike(getStrike() + 1);
                    } else {
                        setBall(getBall() + 1);
                    }
                }
            }
        }
        if (getStrike() == 0 && getBall() == 0) {
            setOut(getOut() + 1);
        }
    }

    private void judge() {
        if (getStrike() == 3) {
            System.out.println("YOU WIN: You hit the answer.");
            System.out.printf("The answer was [%d, %d, %d].", getCorrectAnswer()[0], getCorrectAnswer()[1], getCorrectAnswer()[2]);
            System.exit(0);
        }
        if (getOut() == 3) {
            System.out.println("GAME OVER: You didn't hit the answer.");
            System.out.printf("The answer was [%d, %d, %d].", getCorrectAnswer()[0], getCorrectAnswer()[1], getCorrectAnswer()[2]);
            System.exit(0);
        }
        if (getAttempt() == 0) {
            System.out.println("GAME OVER: You used up all chances.");
            System.out.printf("The answer was [%d, %d, %d].", getCorrectAnswer()[0], getCorrectAnswer()[1], getCorrectAnswer()[2]);
            System.exit(0);
        }
    }

}
